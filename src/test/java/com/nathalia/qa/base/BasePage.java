package com.nathalia.qa.base;

import com.nathalia.qa.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitUtils wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    protected void click(By locator) {
        wait.visible(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = wait.visible(locator);

        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return wait.visible(locator).getText();
    }

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }
}
