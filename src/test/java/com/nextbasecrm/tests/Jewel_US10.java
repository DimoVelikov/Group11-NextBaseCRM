package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Jewel_US10 {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com");
    }

    @Test
    public void createTask() throws InterruptedException {

        WebElement InputUserName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        InputUserName.sendKeys("hr31@cydeo.com"); // passed
       //  InputUserName.sendKeys("helpdesk31@cybertekschool.com"); //passed
       // InputUserName.sendKeys("marketing33@cybertekschool.com"); //no popup for task creation

        WebElement InputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        InputPassword.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();
        //----------------------------------------

        WebElement taskTab = driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-tasks\"]/span"));
        Thread.sleep(2000);
        taskTab.click();

        WebElement taskTitle = driver.findElement(By.xpath("//input[@data-bx-id='task-edit-title']"));
        taskTitle.sendKeys("Task Creation Test Title");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // WebElement taskContent= driver.findElement(By.xpath("//body[@class='template-bitrix24 no-paddings start-page bitrix24-default-theme']"));
        //driver.switchTo().frame(driver.findElement(By.xpath()));

        //switch to frame
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[2]")));
        WebElement taskContentBody = driver.findElement(By.xpath("//body")); // role of this line ?
        taskContentBody.sendKeys("Task Creation Test Content");

        driver.switchTo().parentFrame();
        Thread.sleep(1000);
        //click send
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        Thread.sleep(1000);

        //-----------------------

        //check popup
        WebElement taskCreatedPopUp = driver.findElement(By.xpath("//div[@class='feed-create-task-popup-title']"));
        String expectedPopUpContent = "Task has been created";
        String actualPopUpTitle = taskCreatedPopUp.getText();
        Assert.assertEquals(actualPopUpTitle, expectedPopUpContent, "popUp content not match");

        //close pop up
        WebElement closePopUp1 = driver.findElement(By.xpath("//span[@class='popup-window-close-icon']"));
        closePopUp1.click();
        Thread.sleep(1000);

    }

}

