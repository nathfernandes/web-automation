package com.nathalia.qa.components.Search;

import org.openqa.selenium.By;

public class SearchElements {
    public static final By NO_RESULTS_LABEL = By.cssSelector("label.ast-search--no-results-heading");
    public static final By SEARCH_BUTTON = By.cssSelector("button#search_submit");
    public static final By SEARCH_INPUT = By.cssSelector("input[name='s']");
    public static final By SUGGESTED_ARTICLES = By.cssSelector("div.ast-live-search-results a.ast-search-item");
}
