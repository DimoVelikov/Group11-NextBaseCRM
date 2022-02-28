package com.cydeo.tests;
/*
As a user, I want to access the Chat and Calls module.

1. There should be four sub-modules once the user clicks the Chat and Calls module:
Message
Notifications
Settings
Active Stream

 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class US08_Ali {
    public static WebDriver driver;
    public static Properties properties = new Properties();

    {
        try {
            FileInputStream file = new FileInputStream("us08properties.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }

    @BeforeMethod
    public static void driverSetup() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public static void  closeDriver(){
        driver.close();
    }


    @Test
    public static void clickAndVarifyChatAndCallsModule() throws InterruptedException{
        driver.get(getProperty("url"));
        driver.findElement(By.name("USER_LOGIN")).sendKeys(getProperty("username1"));
        driver.findElement(By.xpath("//div[@class='login-item']/input[@type='password']")).sendKeys(getProperty("password"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/online/']")).click();
        Thread.sleep(2000);

        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(@class,'bx-desktop-tab')]"));

        List<String> expected = new ArrayList<>(Arrays.asList("Message", "Notifications", "Settings", "Active Stream"));
        List<String> actual = new ArrayList<>();

        for (WebElement element : elements) {
            String title = element.getAttribute("title");
            actual.add(title);
        }
        actual.removeAll(Collections.singleton(""));

        Assert.assertEquals(actual, expected);

    }

    @Test
    public static void clickAndVarifyChatAndCallsModule2() throws InterruptedException{
        driver.get(getProperty("url"));
        driver.findElement(By.name("USER_LOGIN")).sendKeys(getProperty("username4"));
        driver.findElement(By.xpath("//div[@class='login-item']/input[@type='password']")).sendKeys(getProperty("password"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/online/']")).click();
        Thread.sleep(2000);

        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(@class,'bx-desktop-tab')]"));

        List<String> expected = new ArrayList<>(Arrays.asList("Message", "Notifications", "Settings", "Active Stream"));
        List<String> actual = new ArrayList<>();

        for (WebElement element : elements) {
            String title = element.getAttribute("title");
            actual.add(title);
        }
        actual.removeAll(Collections.singleton(""));

        Assert.assertEquals(actual, expected);

    }

    @Test
    public static void clickAndVarifyChatAndCallsModule3() throws InterruptedException{
        driver.get(getProperty("url"));
        driver.findElement(By.name("USER_LOGIN")).sendKeys(getProperty("username7"));
        driver.findElement(By.xpath("//div[@class='login-item']/input[@type='password']")).sendKeys(getProperty("password"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/online/']")).click();
        Thread.sleep(2000);

        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(@class,'bx-desktop-tab')]"));

        List<String> expected = new ArrayList<>(Arrays.asList("Message", "Notifications", "Settings", "Active Stream"));
        List<String> actual = new ArrayList<>();

        for (WebElement element : elements) {
            String title = element.getAttribute("title");
            actual.add(title);
        }
        actual.removeAll(Collections.singleton(""));

        Assert.assertEquals(actual, expected);

    }


}