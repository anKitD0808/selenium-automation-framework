package com.ankit.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String user, String pass) {

        System.out.println("Waiting for username field...");

        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);

        System.out.println("Entering password...");
        driver.findElement(password).sendKeys(pass);

        System.out.println("Clicking login...");
        driver.findElement(loginBtn).click();
    }
}