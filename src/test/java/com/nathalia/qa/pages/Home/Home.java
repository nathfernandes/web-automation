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
        click(HomeElements.SEARCH_BUTTON);
        return this;
    }
}
