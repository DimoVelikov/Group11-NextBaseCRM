package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US_5_SendTextMessage {

    /*
    User Story:
    As a user, I should be able to send simple text messages using the message tab.

    AC:
    1. When users click the MESSAGE tab, they should be able to write the message body and send a message successfully to the feed.
    2. “The message title is not specified”. Should be displayed when users send a message without content.
     */

    WebDriver driver;


    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login.nextbasecrm.com/");
        CRM_utilities.crm_login(driver, "hr31@cybertekschool.com", "UserUser");

    }

    @AfterMethod
    public void tearDownMethod() {
          driver.quit();
    }


    @Test
    public void AC1_userWrite_SendMessageSuccessfullyFunction() {

        // STEP 1: user go to homepage

        // assert user is on homepage
        String expectedHomepage = "https://login.nextbasecrm.com/stream/?login=yes";
        String actualHomepage = driver.getCurrentUrl();

        Assert.assertEquals(actualHomepage, expectedHomepage);

        // verify: system should display "MESSAGE" tab / module
        WebElement messageModule = driver.findElement(By.xpath("(//span[.='Message'])[1]"));

        String expectedModuleText = "MESSAGE";
        String actualModuleText = messageModule.getText();

        Assert.assertEquals(actualModuleText, expectedModuleText);

        // verify text in the 'MESSAGE' body before click the 'MESSAGE' tab / module
        // expected text: "Send message …"
        WebElement beforeClickMessageText = driver.findElement(By.xpath("//span[.='Send message …']"));

        String expectedTextInMessageBody = "Send message …";
        String actualTextInMessageBody = beforeClickMessageText.getText();

        Assert.assertEquals(actualTextInMessageBody, expectedTextInMessageBody);
        System.out.println("text in the 'MESSAGE' body before click the 'MESSAGE' tab / module = " + beforeClickMessageText.getText());


        // STEP 2: click the "MESSAGE" tab / module

        messageModule.click();

        // Assert after click the "MESSAGE" tab / module the system should drop task message body
        // and the text in the 'MESSAGE' body is not displayed

        Assert.assertFalse(beforeClickMessageText.isDisplayed());


        // STEP 3: user should be able to write the message in the drop message body

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        WebElement textField = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        textField.sendKeys("Test MESSAGE 1\n" +
                "\n" +
                "Test MESSAGE 2\n" +
                "\n" +
                "Test MESSAGE 3");

        driver.switchTo().defaultContent();


        // STEP 4: click "SEND" button
        WebElement sendButton = driver.findElement(By.xpath("(//button[@class='ui-btn ui-btn-lg ui-btn-primary'])[1]"));
        sendButton.click();

        // system should display the message that user created under the "Activity Stream" on homepage
        // verify if sent message contains expected message text under "Activity Stream"
        String expectedMessage = "Test MESSAGE 1\n" +
                "\n" +
                "Test MESSAGE 2\n" +
                "\n" +
                "Test MESSAGE 3";

        WebElement sentMessage = driver.findElement(By.xpath("(//div[@class= 'feed-post-text-block-inner-inner'])[1]"));

        String actualMessage = sentMessage.getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void AC2_sendMessageWithoutContentFunction() throws InterruptedException {

        // STEP 1: user go to homepage

        // verify user is on homepage
        String expectedHomepage = "https://login.nextbasecrm.com/stream/?login=yes";
        String actualHomepage = driver.getCurrentUrl();

        Assert.assertEquals(actualHomepage, expectedHomepage);

        // verify: system should display "MESSAGE" tab / module

        WebElement messageModule = driver.findElement(By.xpath("(//span[.='Message'])[1]"));

        String expectedModuleText = "MESSAGE";
        String actualModuleText = messageModule.getText();

        Assert.assertEquals(actualModuleText, expectedModuleText);


        // STEP 2: click the "MESSAGE" tab / module
        messageModule.click();


        // STEP 3: click "SEND" button without entering any text in the "MESSAGE" body
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        // system should display a message on top of the "MESSAGE" tab / module:
        //Expected message: “The message title is not specified”

        WebElement warningMessage = driver.findElement(By.xpath("//div[@class='feed-notice-block']"));

        String expectedWarningMessage = "The message title is not specified";
        String actualWarningMessage = warningMessage.getText();

        Assert.assertEquals(actualWarningMessage, expectedWarningMessage);

    }
}