package com.ankit.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ankit.qa.base.BaseTest;
import com.ankit.qa.pages.*;

public class LoginTest extends BaseTest {

    @Test
    public void completeOrderTest() {

        System.out.println("Starting test...");

        // LOGIN
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");

        // HOME
        HomePage hp = new HomePage(driver);
        hp.addProductToCart();
        hp.openCart();

        // CART
        CartPage cp = new CartPage(driver);
        cp.clickCheckout();

        // CHECKOUT
        CheckoutPage ch = new CheckoutPage(driver);
        ch.enterDetails("Ankit", "Kumar", "110001");
        ch.clickContinue();
        ch.clickFinish();

        // ASSERTION (VERY IMPORTANT)
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentURL);

        Assert.assertTrue(currentURL.contains("checkout-complete"),
                "Order not completed!");

        System.out.println("Order completed successfully.");
    }
}