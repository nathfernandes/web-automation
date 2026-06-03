package com.nathalia.qa.pages.BlogArticle;

import com.nathalia.qa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class BlogArticle extends BasePage {

    private BlogArticle(WebDriver driver) {
        super(driver);
    }

    public static BlogArticle of(WebDriver driver) {
        return new BlogArticle(driver);
    }

    @Step("Validate article headline matches selected result")
    public BlogArticle validateArticleHeadline(String expectedTitle) {
        String actualTitle = getText(BlogArticleElements.ARTICLE_HEADLINE);

        assertThat(actualTitle).isEqualTo(expectedTitle);

        return this;
    }
}
