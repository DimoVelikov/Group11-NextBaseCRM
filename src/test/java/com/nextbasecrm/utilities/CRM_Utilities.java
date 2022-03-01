package com.nextbasecrm.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRM_Utilities {


    public static void crm_login(WebDriver driver){

        //3. Enter valid username
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk31@cybertekschool.com");

        //4. Enter valid password
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");

        //5. Click to `Log In` button
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
    }

    public static void crm_login(WebDriver driver,String username,String password){

        //3. Enter valid username
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(username);

        //4. Enter valid password
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);

        //5. Click to `Log In` button
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
    }
}
