package com.nextbasecrm.tests;

import com.github.javafaker.Faker;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dimo {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
        CRM_Utilities.crm_login(driver, "marketing31@cydeo.com", "UserUser");

    }


    @Test
    public void CY_11_7() {

        //1- Create a new pool by clicking on the pool button
        WebElement createPoolBtn = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']"));
        createPoolBtn.click();
        BrowserUtils.sleep(2);

        //2- Switch to the inner ifame and type random content text by using a Faker
        driver.switchTo().frame(0);
        WebElement poolContent = driver.findElement(By.xpath("//body[@contenteditable]"));
        Faker faker = new Faker();
        String poolContentInput = faker.programmingLanguage().name();
        poolContent.sendKeys(poolContentInput);

        //3- Switch to parent frame and enter input for pool questions and votes
        driver.switchTo().parentFrame();
        WebElement poolQuestion = driver.findElement(By.xpath("//input[@class='vote-block-title adda']"));
        poolQuestion.sendKeys("Test Question");
        WebElement poolAnswer1 = driver.findElement(By.xpath("//input[@id='answer_0__0_']"));
        poolAnswer1.sendKeys("vote1");
        WebElement poolAnswer2 = driver.findElement(By.xpath("//input[@id='answer_0__1_']"));
        poolAnswer2.sendKeys("vote2");

        //4- Click on the send button
        WebElement sendBtn = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendBtn.click();
        BrowserUtils.sleep(3);


        //5- Locate the first voting option on the pool we just create anc click on it
        WebElement firstVoteOption = driver.findElement(By.xpath("(//span[@class='bx-vote-block-inp-substitute'])[1]"));
        firstVoteOption.click();

        //6- Click on the vote button
        WebElement voteBtn = driver.findElement(By.xpath("(//button[@class='ui-btn ui-btn-lg ui-btn-primary'])[1]"));
        voteBtn.click();
        BrowserUtils.sleep(3);

        //7 Assert that vote button is not displayed
        Assert.assertFalse(voteBtn.isDisplayed());

    }


}























