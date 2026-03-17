package com.ankit.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    // LOCATORS
    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addProductToCart() {

        System.out.println("Waiting for Add to Cart button...");

        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn)).click();

        System.out.println("Product added to cart");
    }

    public void openCart() {

        System.out.println("Opening cart...");

        driver.findElement(cartIcon).click();
    }
}