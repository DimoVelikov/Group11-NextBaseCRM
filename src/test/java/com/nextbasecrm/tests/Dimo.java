package com.nextbasecrm.tests;

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
    }

    @Test
    public void CY_11_7() {

        // 1. Users can select one answer and click the “VOTE” button to vote for a poll.


        driver.get("https://login2.nextbasecrm.com/");


        CRM_Utilities.crm_login(driver, "marketing31@cydeo.com", "UserUser");


        WebElement voteAgainBtn = driver.findElement(By.xpath("//form[@name='vote-form-nSLjLH1065']//button[@data-bx-vote-button='showVoteForm']"));

        if (voteAgainBtn.isDisplayed()) {
            voteAgainBtn.click();
        }


        WebElement selectOption = driver.findElement(By.xpath("//form[@name='vote-form-nSLjLH1065']//label[@for='vote_radio_1106_2492']//span"));

        selectOption.click();


        WebElement voteBtn = driver.findElement(By.xpath("//form[@name='vote-form-nSLjLH1065']//button[@class= 'ui-btn ui-btn-lg ui-btn-primary']"));
        voteBtn.click();

        BrowserUtils.sleep(3);

        Assert.assertFalse(voteBtn.isDisplayed());

        String result = driver.findElement(By.xpath("//form[@name='vote-form-nSLjLH1065']//a[@data-bx-vote-answer='2492']")).getText();

        Assert.assertEquals(result, "1");


    }


}




















