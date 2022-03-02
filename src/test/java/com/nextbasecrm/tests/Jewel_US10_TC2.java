package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Jewel_US10_TC2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com");
       //user log in start;
        WebElement InputUserName = driver.findElement(By.xpath("//input[@class='login-inp']"));
        InputUserName.sendKeys("hr33@cydeo.com");

        WebElement InputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        InputPassword.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }
    //user log in end;
    @Test
    public void createTaskNoContent() throws InterruptedException {
        //test case 2 test: task with no title;
        Thread.sleep(2000);
        WebElement taskTab = driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-tasks\"]/span"));
        Thread.sleep(4000);
        taskTab.click();
        Thread.sleep(2000);

// add content
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[2]")));
        WebElement taskContentBody = driver.findElement(By.xpath("//body")); // role of this line ?

        taskContentBody.sendKeys("Task Creation Test Content");
        driver.switchTo().parentFrame();

        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();


        WebElement noNameSpecifiedPopUp = driver.findElement(By.xpath("//*[@id=\"feed-add-post-content-tasks-container\"]/div[1]"));

        String expectedNoTitleContentPopup = "The task name is not specified.";
        String actualNoTitleNoContentPopup = noNameSpecifiedPopUp.getText();

        Assert.assertEquals(actualNoTitleNoContentPopup, expectedNoTitleContentPopup, "not match");
    }
}
