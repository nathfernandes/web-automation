package com.nathalia.qa.components.Search;

import com.nathalia.qa.base.BasePage;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class Search extends BasePage {
    private Search(WebDriver driver){
        super(driver);
    }

    public static Search of(WebDriver driver){
        return new Search(driver);
    }

    public Search fillSearchInput(String searchTerm) {
        type(SearchElements.SEARCH_INPUT, searchTerm);
        return this;
    }

    public Search submitSearch() {
        click(SearchElements.SEARCH_BUTTON);
        return this;
    }

    public Search validateNoResultsMessage() {
        boolean displayed = wait.visible(SearchElements.NO_RESULTS_LABEL).isDisplayed();

        assertThat(displayed).isTrue();

        return this;
    }

    public Search validateMaxSuggestions(int max) {
        int size = wait.visibleAll(SearchElements.SUGGESTED_ARTICLES).size();

        assertThat(size).isEqualTo(max);

        return this;
    }

    public String getArticleTitle(int index) {
        var suggestions = wait.visibleAll(SearchElements.SUGGESTED_ARTICLES);

        return suggestions.get(index).getText().trim();
    }

    public Search clickSuggestionByIndex(int index) {
        var suggestions = wait.visibleAll(SearchElements.SUGGESTED_ARTICLES);
        suggestions.get(index).click();
        return this;
    }

    public Search validateSuggestionsContain(String term) {
        var texts = wait.visibleAll(SearchElements.SUGGESTED_ARTICLES)
                .stream()
                .map(e -> e.getText().trim())
                .toList();;

        assertThat(texts).allMatch(t -> t.toLowerCase().contains(term.toLowerCase()));

        return this;
    }
}
