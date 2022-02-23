package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CY11_UserStory2_Sina {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login.nextbasecrm.com/");
    }

    @Test
    public void checkBoxLabelAvailability(){

        WebElement checkBoxLabel = driver.findElement(By.xpath("//input[@type='checkbox']"));

        Assert.assertTrue(checkBoxLabel.isDisplayed(),"Check box label is not displayed!");
        Assert.assertTrue(checkBoxLabel.isEnabled(),"Check box label is enabled");

    }

    @Test
    public void rememberMeText(){

        WebElement rememberMeText = driver.findElement(By.xpath("//label[text()='Remember me on this computer']"));

        String expectedText = "Remember me on this computer";
        String actualText = rememberMeText.getText();

        Assert.assertEquals(actualText,expectedText,"Remember me on this computer text is not displayed!");


    }

@AfterMethod

    public void tearDown(){
        driver.quit();
}


}
