package com.royalbrothers.factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final ThreadLocal<AppiumDriver<MobileElement>> driver = new ThreadLocal<>();

    public static void initDriver() throws IOException {
        CapabilitiesFactory capsFactory = new CapabilitiesFactory();
        DesiredCapabilities caps = capsFactory.getAndroidCapabilities();
        URL server = capsFactory.getServerUrl();
        AppiumDriver<MobileElement> drv = new AndroidDriver<>(server, caps);
        drv.manage().timeouts().implicitlyWait(Long.parseLong(
                System.getProperty("implicitWait", "10")), TimeUnit.SECONDS);
        driver.set(drv);
    }

    public static AppiumDriver<MobileElement> getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        AppiumDriver<MobileElement> d = driver.get();
        if (d != null) {
            d.quit();
            driver.remove();
        }
    }
}
