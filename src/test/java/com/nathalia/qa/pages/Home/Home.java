package com.nathalia.qa.pages.Home;

import com.nathalia.qa.base.BasePage;
import org.openqa.selenium.WebDriver;

public class Home extends BasePage {
    private Home(WebDriver driver){
        super(driver);
    }

    public static Home of(WebDriver driver){
        return new Home(driver);
    }

    public Home openSearch() {
        click(HomeElements.SEARCH_BUTTON);
        return this;
    }
}
