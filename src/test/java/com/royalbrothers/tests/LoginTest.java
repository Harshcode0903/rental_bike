package com.royalbrothers.tests;

import com.royalbrothers.base.BaseTest;
import com.royalbrothers.factory.DriverFactory;
import com.royalbrothers.pages.LoginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void happyPathLogin() throws Exception {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver();
        LoginPage login = new LoginPage(driver);

        // example flow - update with real behavior
        login.enterPhone("9999999999");
        login.tapLogin();

        // add assertions appropriate to the app
        // e.g., wait for OTP screen or home screen element
        // For demo:
        Assert.assertTrue(true, "Replace with real verification");
    }
}
