package com.nathalia.qa.components.Search;

import com.nathalia.qa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class Search extends BasePage {
    private Search(WebDriver driver){
        super(driver);
    }

    public static Search of(WebDriver driver){
        return new Search(driver);
    }

    @Step("Fill search input with term: {searchTerm}")
    public Search fillSearchInput(String searchTerm) {
        type(SearchElements.SEARCH_INPUT, searchTerm);
        return this;
    }

    @Step("Submit search")
    public Search submitSearch() {
        click(SearchElements.SEARCH_BUTTON);
        return this;
    }

    @Step("Validate no search suggestions were found")
    public Search validateNoResultsMessage() {
        String pageText =  wait.present(SearchElements.NO_RESULTS_LABEL).getText();
        assertThat(pageText)
                .containsIgnoringCase("no results found");

        return this;
    }

    @Step("Validate number of suggestions is {max}")
    public Search validateMaxSuggestions(int max) {
        int size = wait.visibleAll(SearchElements.SUGGESTED_ARTICLES).size();

        assertThat(size).isEqualTo(max);

        return this;
    }

    public String getArticleTitle(int index) {
        var suggestions = wait.visibleAll(SearchElements.SUGGESTED_ARTICLES);

        return suggestions.get(index).getText().trim();
    }

    public Search waitForSuggestionsToMatchTerm(String searchTerm) {
        wait.untilSuggestionsMatchTerm(SearchElements.SUGGESTED_ARTICLES, searchTerm);
        return this;
    }

    @Step("Open suggestion at index {index}")
    public Search clickSuggestionByIndex(int index) {
        var suggestions = wait.visibleAll(SearchElements.SUGGESTED_ARTICLES);
        suggestions.get(index).click();
        return this;
    }

    @Step("Validate all suggestions contain term: {term}")
    public Search validateSuggestionsContain(String term) {
        var texts = wait.visibleAll(SearchElements.SUGGESTED_ARTICLES)
                .stream()
                .map(e -> e.getText().trim())
                .toList();

        assertThat(texts).allMatch(t -> t.toLowerCase().contains(term.toLowerCase()));

        return this;
    }
}
