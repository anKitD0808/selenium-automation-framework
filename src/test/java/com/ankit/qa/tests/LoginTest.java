package com.ankit.qa.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ankit.qa.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        driver.get("https://example.com");

        System.out.println("Running test with: " + username + " / " + password);

        // simulate login steps (for now just print)

        // 🔴 Force fail (for screenshot check)
        //Assert.assertTrue(false);
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {

        return new Object[][] {
            {"user1", "pass1"},
            {"user2", "pass2"},
            {"user3", "pass3"}
        };
    }
}