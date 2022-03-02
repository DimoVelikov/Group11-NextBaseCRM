package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

//US : As a user, I want to see all the options under the user profile.
public class US_4_Gulsen {
    //1. User go to "https://login2.nextbasecrm.com/"
    //2.can able to login with valid data
    // user name = hr31@cydeo.com
    // password = UserUser
    //3.User go to homepage
    //4.User can able to see all the 5 options under the "my profile" module
    // expected option:
    // My Profile
    //Edit Profile Settings
    //Themes
    //Configure notifications
    //Logout

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String userName="hr31@cydeo.com";
        String password="UserUser";

        driver.get("https://login2.nextbasecrm.com");
        WebElement InputUserName = driver.findElement(By.xpath("//input[@class='login-inp']"));
        InputUserName.sendKeys(userName);

        WebElement InputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        InputPassword.sendKeys(password);

        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }

    @Test
    public void verifyTheOptions(){
        WebElement profileModule= driver.findElement(By.xpath("//span[@class='user-name']"));
        profileModule.click();

        WebElement module;
        ArrayList<String> actualText = new ArrayList<>();
        ArrayList<String> expectedText = new ArrayList<>(Arrays.asList("My Profile","Edit Profile Settings","Themes","Configure notifications","Logout"));
        for (int i = 1; i <=5 ; i++) {
            module=driver.findElement(By.xpath("(//div[@class='menu-popup-items'])/*["+i+"]/*[2]"));

            actualText.add(module.getText());


        }
        System.out.println("expectedText = " + expectedText);
        System.out.println("actualText = " + actualText);
        Assert.assertTrue(actualText.equals(expectedText));



    }

}
