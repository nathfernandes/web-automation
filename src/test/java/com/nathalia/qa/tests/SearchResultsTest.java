package com.nathalia.qa.tests;

import com.nathalia.qa.base.BaseTest;
import com.nathalia.qa.components.Search.Search;
import com.nathalia.qa.constants.ProjectConstants;
import com.nathalia.qa.pages.Home.Home;
import com.nathalia.qa.pages.SearchResult.SearchResult;
import com.nathalia.qa.pages.BlogArticle.BlogArticle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchResultsTest extends BaseTest {

    @BeforeEach
    void openSearch() {
        Home.of(driver).openSearch();
    }

    @Test
    @DisplayName("Should show search results matching query")
    void shouldShowSearchResults() {
        String term = ProjectConstants.VALID_TERM;
        Search.of(driver)
                .fillSearchInput(term)
                .submitSearch();

        SearchResult.of(driver)
                .validateSearchTitle(term)
                .validateResultsContain(term);
    }

    @Test
    @DisplayName("Should display 'nothing was found' message when search term has no matches")
    void shouldShowNoResults() {
        String term = ProjectConstants.INVALID_TERM;
        searchFor(term)
                .validateSearchTitle(term)
                .validateNoResults();
    }

    @Test
    @DisplayName("Should open correct article from search result")
    void shouldOpenCorrectArticleFromResult() {
        String term = ProjectConstants.VALID_TERM;
        SearchResult results = searchFor(term);

        String expectedTitle = SearchResult.of(driver)
                        .getArticleTitle(1);

        results.openArticle(1);

        BlogArticle.of(driver)
                .validateArticleHeadline(expectedTitle);
    }

    private SearchResult searchFor(String term) {
        Search.of(driver)
                .fillSearchInput(term)
                .submitSearch();

        return SearchResult.of(driver);
    }
}
