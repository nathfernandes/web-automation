package com.nathalia.qa.pages.SearchResult;

import org.openqa.selenium.By;

public class SearchResultElements {
    private static final String NO_RESULTS = "section.no-results.not-found";

    public static final By NO_RESULTS_SECTION = By.cssSelector(NO_RESULTS);
    public static final By NO_RESULTS_MESSAGE = By.cssSelector(NO_RESULTS + " p");
    public static final By SEARCH_RESULT_TITLE = By.cssSelector("h1.page-title.ast-archive-title");
    public static final By SEARCH_RESULT_TITLES =
            By.cssSelector("article.ast-archive-post h2.entry-title a");
}
