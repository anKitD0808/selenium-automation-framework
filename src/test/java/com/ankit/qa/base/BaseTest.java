package com.ankit.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        System.out.println("Launching browser in incognito mode...");

        // ✅ Chrome Options
        ChromeOptions options = new ChromeOptions();

        // 🔥 IMPORTANT LINE (Incognito Mode)
        options.addArguments("--incognito");

        // Optional (extra clean run)
        options.addArguments("--disable-notifications");

        // Launch browser with options
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        // Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Opening website...");
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {

        System.out.println("Closing browser...");
        driver.quit();
    }
}