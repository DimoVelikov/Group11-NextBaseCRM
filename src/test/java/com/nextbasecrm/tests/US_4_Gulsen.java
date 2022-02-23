package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    }

    @Test
    public void verifyTheOptions(){

        String userName="hr31@cydeo.com";
        String password="UserUser";

        driver.get("https://login2.nextbasecrm.com");
        WebElement InputUserName = driver.findElement(By.xpath("//input[@class='login-inp']"));
        InputUserName.sendKeys(userName);

        WebElement InputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        InputPassword.sendKeys(password);

        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        WebElement profileModule= driver.findElement(By.xpath("//span[@class='user-name']"));
        profileModule.click();

       WebElement myProfile = driver.findElement(By.xpath("//*[@id='popup-window-content-menu-popup-user-menu']/div/div/a[1]/span[2]"));
       String actualMyProfileText = myProfile.getText();
       String expectedMyProfileText = "My Profile";
        Assert.assertTrue(actualMyProfileText.equals(expectedMyProfileText));

       WebElement editProfileSetting =driver.findElement(By.xpath("//*[@id='popup-window-content-menu-popup-user-menu']/div/div/a[2]/span[2]"));
       String actualEditProfileSettingText = editProfileSetting.getText();
       String expectedEditProfileSettingText="Edit Profile Settings";
       Assert.assertTrue(actualEditProfileSettingText.equals(expectedEditProfileSettingText));

       WebElement themes = driver.findElement(By.xpath("//*[@id='popup-window-content-menu-popup-user-menu']/div/div/span[1]/span[2]"));
       String actualThemesText= themes.getText();
       String expectedThemesText="Themes";
       Assert.assertTrue(actualThemesText.equals(expectedThemesText));


      WebElement configureNotifications = driver.findElement(By.xpath("//*[@id='popup-window-content-menu-popup-user-menu']/div/div/span[2]/span[2]"));
      String actualConfigureNotificationsText = configureNotifications.getText();
      String expectedConfigureNotificationsText="Configure notifications";
      Assert.assertTrue(actualConfigureNotificationsText.equals(expectedConfigureNotificationsText));

      WebElement logout = driver.findElement(By.xpath("//*[@id='popup-window-content-menu-popup-user-menu']/div/div/a[3]/span[2]"));
      String actualLogoutText=logout.getText();
      String expectedLogoutText="Logout";
      Assert.assertTrue(actualLogoutText.equals(expectedLogoutText));


    }

}
