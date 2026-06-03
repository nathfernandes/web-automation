package com.nathalia.qa.pages.Home;

import com.nathalia.qa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class Home extends BasePage {
    private Home(WebDriver driver){
        super(driver);
    }

    public static Home of(WebDriver driver){
        return new Home(driver);
    }

    @Step("Open search")
    public Home openSearch() {
        System.out.println("URL: " + driver.getCurrentUrl());

        var elements = driver.findElements(HomeElements.SEARCH_BUTTON);

        System.out.println("Search icons found: " + elements.size());

        if (!elements.isEmpty()) {
            System.out.println("Displayed: " + elements.get(0).isDisplayed());
        }

        click(HomeElements.SEARCH_BUTTON);

        return this;
    }
}
