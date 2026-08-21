package com.royalbrothers.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class LoginPage {

    private final AppiumDriver<MobileElement> driver;

    @FindBy(id = "com.royalbrothers:id/phone_input")
    private MobileElement phoneInput;

    @FindBy(id = "com.royalbrothers:id/login_button")
    private MobileElement loginButton;

    // replace ids above with actual ids from the Royal Brothers app

    public LoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void enterPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void tapLogin() {
        loginButton.click();
    }
}
