package com.nextbasecrm.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRM_Utilities {


    private static String username = ConfigurationReader.getProperty("username1");
    private static String password = ConfigurationReader.getProperty("password");

    /*
    This method will log in to CRM, if no username and password provided will use Data from Configuration properties
     */
    public static void crm_login(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        wait.until(ExpectedConditions.visibilityOf(inputUsername));
        inputUsername.clear();
        inputUsername.sendKeys(username);

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        inputPassword.clear();
        inputPassword.sendKeys(password);

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    public static void crm_login(WebDriver driver, String username, String password) {
        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.clear();
        inputUsername.sendKeys(username);

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.clear();
        inputPassword.sendKeys(password);

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }

    public static void crm_login(WebDriver driver, String username) {
        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.clear();
        inputUsername.sendKeys(username);

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.clear();
        inputPassword.sendKeys(password);

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }

    public static void crm_logout(WebDriver driver) {
        WebElement userBlock = driver.findElement(By.xpath("//div[@id='user-block']"));
        userBlock.click();
        WebElement logoutButton = driver.findElement(By.xpath("//a[contains(@href, 'logout')]"));
        logoutButton.click();
    }
}
