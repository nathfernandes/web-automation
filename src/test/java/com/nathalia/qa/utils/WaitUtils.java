package com.nathalia.qa.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class WaitUtils {

    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement visible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> visibleAll(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement present(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void untilSuggestionsMatchTerm(By locator, String term) {
        wait.until(d -> {
            List<String> texts = d.findElements(locator).stream()
                    .map(e -> e.getText().trim().toLowerCase())
                    .filter(t -> !t.isEmpty())
                    .toList();

            if (texts.isEmpty()) return false;

            return texts.stream().allMatch(t -> t.contains(term.toLowerCase()));
        });
    }

    public void untilResultsAreVisibleAndNotEmpty(By locator) {
        wait.until(d -> {
            List<WebElement> elements = d.findElements(locator);

            List<String> texts = elements.stream()
                    .map(e -> e.getText().trim())
                    .filter(t -> !t.isEmpty())
                    .toList();

            return !texts.isEmpty();
        });
    }

    public void untilListHasSize(By locator, int minSize) {
        wait.until(driver -> driver.findElements(locator).size() >= minSize);
    }
}
