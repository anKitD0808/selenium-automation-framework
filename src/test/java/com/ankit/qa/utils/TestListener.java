package com.ankit.qa.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import com.aventstack.extentreports.*;
import com.ankit.qa.base.BaseTest;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReportInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");

        System.out.println("TEST FAILED - Screenshot captured");

        // ✅ GET DRIVER PROPERLY
        String path = ScreenshotUtil.captureScreenshot(BaseTest.getDriver(), result.getName());

        System.out.println("Driver value: " + BaseTest.getDriver());

        try {
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}