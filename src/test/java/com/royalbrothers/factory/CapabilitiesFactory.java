package com.royalbrothers.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesFactory {
    private final Properties props;

    public CapabilitiesFactory() throws IOException {
        props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            props.load(fis);
        }
    }

    public DesiredCapabilities getAndroidCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, props.getProperty("platformName", "Android"));
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("automationName", "UiAutomator2"));
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("deviceName", "Android_Emulator"));
        String appPath = props.getProperty("app");
        if (appPath != null && !appPath.isBlank()) {
            caps.setCapability(MobileCapabilityType.APP, appPath);
        } else {
            caps.setCapability("appPackage", props.getProperty("appPackage"));
            caps.setCapability("appActivity", props.getProperty("appActivity"));
        }
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, Integer.parseInt(props.getProperty("newCommandTimeout", "120")));
        // add more caps as needed
        return caps;
    }

    public URL getServerUrl() throws MalformedURLException {
        return new URL(props.getProperty("appiumServer", "http://127.0.0.1:4723/wd/hub"));
    }
}
