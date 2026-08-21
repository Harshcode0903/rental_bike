# Royal Brothers Appium Framework (Java + TestNG)

This is a starter Maven project for Appium-based automation of the Royal Brothers mobile app (Android). It provides a basic driver factory, page object, and a sample test.

Prerequisites
- Java 11+
- Maven 3.6+
- Android SDK & platform-tools (ADB)
- Appium server (local or remote) - Appium Desktop / Appium CLI
- Real device or emulator
- RoyalBrothers APK or package/activity info

Project layout
- src/test/java - tests, pages, factories
- src/test/resources/config.properties - config that holds device/app settings
- pom.xml - dependencies and build

How to configure
1. Edit src/test/resources/config.properties
   - Set app or appPackage/appActivity, deviceName, platformVersion, and appiumServer URL.

2. Start Appium:
   - Example: `appium` (or using Appium Desktop)
   - Ensure the device is visible with `adb devices`

Run tests
- From project root:
  `mvn clean test`
- Use system properties to override defaults:
  `mvn -DdeviceName=Pixel_7 -Dapp=path/to/app.apk clean test`

Notes & next steps
- Replace example element locators (resource-id) with the actual Royal Brothers app locators.
- Add explicit wait helpers, retry logic, screenshot capture on failure, logging and reporting (Extent/Allure).
- Add a CI pipeline (GitHub Actions/Jenkins) that starts an emulator or uses cloud device farm.
- Expand page objects and tests to cover the app flows you need.
