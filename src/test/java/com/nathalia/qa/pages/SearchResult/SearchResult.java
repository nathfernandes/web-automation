package com.nathalia.qa.pages.SearchResult;

import com.nathalia.qa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResult extends BasePage {
    private SearchResult(WebDriver driver) {
        super(driver);
    }

    public static SearchResult of(WebDriver driver) {
        return new SearchResult(driver);
    }

    @Step("Validate search results page title contains '{searchTerm}'")
    public SearchResult validateSearchTitle(String searchTerm) {
        String title = getText(SearchResultElements.SEARCH_RESULT_TITLE);

        assertThat(title).isNotNull().contains(searchTerm);

        return this;
    }

    @Step("Validate no search results were found")
    public SearchResult validateNoResults() {
        wait.visible(SearchResultElements.NO_RESULTS_SECTION);
        String message = getText(SearchResultElements.NO_RESULTS_MESSAGE);

        assertThat(message).containsIgnoringCase("nada foi encontrado");

        return this;
    }

    @Step("Validate all search results contain '{term}'")
    public SearchResult validateResultsContain(String term) {
        wait.untilResultsAreVisibleAndNotEmpty(SearchResultElements.SEARCH_RESULT_TITLES);
        List<WebElement> results = findAll(SearchResultElements.SEARCH_RESULT_TITLES);
        List<String> texts = results.stream()
                .map(e -> e.getText().trim())
                .filter(t -> !t.isEmpty())
                .map(String::toLowerCase)
                .toList();

        assertThat(texts).allMatch(text -> text.contains(term.toLowerCase()));

        return this;
    }

    private List<WebElement> getSafeResults(int index) {
        wait.untilListHasSize(SearchResultElements.SEARCH_RESULT_TITLES, index + 1);
        return findAll(SearchResultElements.SEARCH_RESULT_TITLES);
    }

    @Step("Get title from search result at index {index}")
    public String getArticleTitle(int index) {
        return getSafeResults(index).get(index).getText().trim();
    }

    @Step("Open search result at index {index}")
    public SearchResult openArticle(int index) {
        getSafeResults(index).get(index).click();
        return this;
    }
}
