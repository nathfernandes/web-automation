package com.nathalia.qa.tests;

import com.nathalia.qa.base.BaseTest;
import com.nathalia.qa.components.Search.Search;
import com.nathalia.qa.constants.ProjectConstants;
import com.nathalia.qa.pages.BlogArticle.BlogArticle;
import com.nathalia.qa.pages.Home.Home;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Agi Blog")
@Feature("Search Suggestions")
@DisplayName("Search Suggestions Test")
public class SearchSuggestionsTest extends BaseTest {

    @BeforeEach
    void openSearch() {
        Home.of(driver).openSearch();
    }

    @Test
    @DisplayName("Should show suggestions when typing a valid term")
    void shouldShowSuggestions() {
        String term = ProjectConstants.VALID_TERM;
        Search.of(driver)
                .fillSearchInput(term)
                .waitForSuggestionsToMatchTerm(term)
                .validateSuggestionsContain(term)
                .validateMaxSuggestions(6);
    }

    @Test
    @DisplayName("Should display 'no results' message when search term has no matches")
    void shouldShowNoSuggestions() {
        String term = ProjectConstants.INVALID_TERM;
        Search.of(driver)
                .fillSearchInput(term)
                .validateNoResultsMessage();
    }

    @Test
    @DisplayName("Should open correct article from search suggestion")
    void shouldOpenCorrectArticleFromSuggestion() {
        String term = ProjectConstants.VALID_TERM;
        Search search = Search.of(driver);

        String expectedTitle = search
                .fillSearchInput(term)
                .waitForSuggestionsToMatchTerm(term)
                .getArticleTitle(2);

        search.clickSuggestionByIndex(2);

        BlogArticle.of(driver)
                .validateArticleHeadline(expectedTitle);
    }
}
