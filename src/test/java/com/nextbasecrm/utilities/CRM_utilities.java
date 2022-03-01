package com.nextbasecrm.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_utilities {

    // this method will log-in with helpdesk1 user when it is called

    public static void crm_login(WebDriver driver){

        // Enter valid username
        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("helpdesk1@cybertekschool.com");

//        Enter valid password
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

//         Click to Log In button
        WebElement logInButton = driver.findElement(By.xpath("//input[@type='submit']"));
        logInButton.click();
    }


    public static void crm_login(WebDriver driver, String username){

        // Enter valid username
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameInput.sendKeys(username);

//        Enter valid password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("UserUser");

//         Click to Log In button
        WebElement logInButton = driver.findElement(By.xpath("//input[@type='submit']"));
        logInButton.click();
    }


    public static void crm_login(WebDriver driver, String username, String password){

        // Enter valid username
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameInput.sendKeys(username);

//        Enter valid password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys(password);

//         Click to Log In button
        WebElement logInButton = driver.findElement(By.xpath("//input[@type='submit']"));
        logInButton.click();
    }

}

