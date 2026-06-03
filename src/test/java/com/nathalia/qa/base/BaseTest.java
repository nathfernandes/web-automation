package com.nathalia.qa.base;

import com.nathalia.qa.constants.ProjectConstants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected WebDriver driver;
    protected DriverEnum driverType;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeEach
    void setup() {
        String browser = System.getProperty("browser", "chrome");

        driverType = DriverEnum.valueOf(browser.toUpperCase());

        driver = driverType.create();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get(ProjectConstants.BASE_URL);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
