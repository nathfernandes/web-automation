package com.nathalia.qa.pages.SearchResult;

import com.nathalia.qa.base.BasePage;
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

    public SearchResult validateSearchTitle(String searchTerm) {
        String title = getText(SearchResultElements.SEARCH_RESULT_TITLE);

        assertThat(title).isNotNull().contains(searchTerm);

        return this;
    }

    public SearchResult validateNoResults() {
        wait.visible(SearchResultElements.NO_RESULTS_SECTION);
        String message = getText(SearchResultElements.NO_RESULTS_MESSAGE);

        assertThat(message).containsIgnoringCase("nada foi encontrado");

        return this;
    }

    public SearchResult validateResultsContain(String term) {
        List<WebElement> results = findAll(SearchResultElements.SEARCH_RESULTS);
        List<String> texts = results.stream()
                .map(e -> e.getText().toLowerCase())
                .toList();

        assertThat(texts).allMatch(text -> text.contains(term.toLowerCase()));

        return this;
    }

    public String getArticleTitle(int index) {
        List<WebElement> results = findAll(SearchResultElements.SEARCH_RESULTS);

        return results.get(index).getText().trim();
    }

    public SearchResult openArticle(int index) {
        List<WebElement> results = findAll(SearchResultElements.SEARCH_RESULTS);
        results.get(index).click();
        return this;
    }
}
