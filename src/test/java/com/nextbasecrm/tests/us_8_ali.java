package com.nextbasecrm.tests;

/*
As a user, I want to access the Chat and Calls module.

1. There should be four sub-modules once the user clicks the Chat and Calls module:
Message
Notifications
Settings
Active Stream

https://login2.nextbasecrm.com/
hr31@cydeo.com
UserUser
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class us_8_ali {

    public static WebDriver driver;

    @BeforeClass
    public static void driverSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public static void clickAndVarifyChatAndCallsModule(){
        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("hr31@cydeo.com");
        driver.findElement(By.xpath("//div[@class='login-item']/input[@type='password']")).sendKeys("UserUser");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//a[@href='/online/']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(@class,'bx-desktop-tab')]"));

        List<String> expected = new ArrayList<>(Arrays.asList("Message","Notifications","Settings","Active Stream"));
        List<String> actual = new ArrayList<>();

        for (WebElement element : elements) {
            String title = element.getAttribute("title");
            actual.add(title);
        }
        actual.removeAll(Collections.singleton(""));

        Assert.assertEquals(actual,expected);

    }
}
