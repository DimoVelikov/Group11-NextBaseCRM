package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CRM_AppreciationTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        String browserType = ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(ConfigurationReader.getProperty("env"));

        CRM_utilities.crm_login(driver);

    }

    @Test
    public void sendingAppreciationMsgTest(){
//        Users are on the homepage
//        Users click MORE tab and select APPRECIATION
        driver.findElement(By.cssSelector("#feed-add-post-form-link-text")).click();
        BrowserUtils.sleep(3);
        driver.findElement(By.xpath("(//span[.='Appreciation'])[2]")).click();

//        Users write an Appreciation message
        driver.switchTo().frame(driver.findElement(By.cssSelector(".bx-editor-iframe")));
        driver.findElement(By.tagName("body")).sendKeys("Hello");

//        Users click the SEND button
        driver.switchTo().defaultContent();
        driver.findElement(By.id("blog-submit-button-save")).click();
//        Verify the Appreciation is displayed on the feed
        WebElement feedMsg= driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body')]"));
        String expected="Hello";
        String actual=feedMsg.getText();
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void emptyMsgTest(){
//        Users are on the homepage
//        Users click MORE tab and select APPRECIATION
        driver.findElement(By.cssSelector("#feed-add-post-form-link-text")).click();
        BrowserUtils.sleep(3);
        driver.findElement(By.xpath("//span[.='Appreciation']")).click();

//        Users click the SEND button
        driver.findElement(By.id("blog-submit-button-save")).click();
//        Verify “The message title is not specified” warning message is displayed on the page
        WebElement warningMsg=driver.findElement(By.xpath("//span[.='The message title is not specified']"));
        String expectedText="The message title is not specified";
        String actualText=warningMsg.getText();
        Assert.assertEquals(actualText,expectedText,"Warning Message did not appear!");

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.quit();
    }
}