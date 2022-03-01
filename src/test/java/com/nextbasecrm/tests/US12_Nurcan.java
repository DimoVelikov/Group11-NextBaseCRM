package com.nextbasecrm.tests;


import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US12_Nurcan {
      /*
    Story 12:
As a user, I should be able to Make Announcements using the Announcements tab.
Acceptance Criteria:
1. Users should be able to write messages in and send announcements by clicking
the SEND button.
2. When users attempt to make announcements without a message, there should be
a working message “The message title is not specified”.
     */

    WebDriver driver;

    //Setting up the beforeMethod for every test case!
    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login.nextbasecrm.com/");
        CRM_Utilities.crm_login(driver, "hr31@cybertekschool.com", "UserUser");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void AC1_MakingAnnouncementSuccessfully() {

        // STEP 1: user go to homepage
        String expectedHomepage = "https://login.nextbasecrm.com/stream/?login=yes";
        String actualHomepage = driver.getCurrentUrl();

        // assert user is on homepage
        Assert.assertEquals(actualHomepage, expectedHomepage);


        // STEP 2:verify system should display "MORE" tab / module
        WebElement MoreTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));

        String expectedModuleText = "MORE";
        String actualModuleText = MoreTab.getText();

        Assert.assertEquals(actualModuleText, expectedModuleText);

        //click "MORE" tab
        MoreTab.click();

        WebElement AnnouncementOption = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[3]"));

        String expectedOption = "Announcement";
        String actualOption = MoreTab.getText();

        Assert.assertEquals(actualModuleText, expectedModuleText);

        //select "Announcement" Option
        AnnouncementOption.click();

        //STEP 3:Write message in text field
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        WebElement textField = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        textField.sendKeys("Test Announcement 1\n" +
                "\n" + "Test Announcement 2\n" +
                "\n" + "Test Announcement 3");

        driver.switchTo().defaultContent();


        WebElement sendButton = driver.findElement(By.xpath("(//button[@class='ui-btn ui-btn-lg ui-btn-primary'])[1]"));

        //STEP4:click "SEND" button
        sendButton.click();

        // system should display the announcement that user created under the "Activity Stream" on homepage
        // verify if actualannouncement contains expected announcement text under "Activity Stream"
        String expectedAnnouncement = "Test Announcement 1\n" +
                "\n" + "Test Announcement 2\n" +
                "\n" + "Test Announcement 3";

        WebElement sentAnnouncement = driver.findElement(By.xpath("(//div[@class= 'feed-post-text-block-inner-inner'])[1]"));

        String actualAnnouncement = sentAnnouncement.getText();


        Assert.assertTrue(actualAnnouncement.contains(expectedAnnouncement));

    }

    @Test
    public void AC2_MakingAnnouncement_WithoutTextContent() {
        // STEP 1: user go to homepage

        // assert user is on homepage
        String expectedHomepage = "https://login.nextbasecrm.com/stream/?login=yes";
        String actualHomepage = driver.getCurrentUrl();

        Assert.assertEquals(actualHomepage, expectedHomepage);


        WebElement MoreTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));

        String expectedModuleText = "MORE";
        String actualModuleText = MoreTab.getText();

        Assert.assertEquals(actualModuleText, expectedModuleText);

        //STEP2:click "MORE" tab
        MoreTab.click();

        WebElement AnnouncementOption = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[3]"));

        String expectedOption = "Announcement";
        String actualOption = MoreTab.getText();

        Assert.assertEquals(actualModuleText, expectedModuleText);

        //select the  "Announcement" option
        AnnouncementOption.click();

        //STEP 3:click "SEND" button without textcontent
        WebElement sendButton = driver.findElement(By.xpath("(//button[@class='ui-btn ui-btn-lg ui-btn-primary'])[1]"));
        sendButton.click();

        // system should display a message on the top
        //Expected message: “The message title is not specified”

        WebElement warningMessage = driver.findElement(By.xpath("//span[@class= 'feed-add-info-text']"));

        String expectedWarningMessage = "The message title is not specified";
        String actualWarningMessage = warningMessage.getText();

        Assert.assertEquals(actualWarningMessage, expectedWarningMessage);

    }




    }









