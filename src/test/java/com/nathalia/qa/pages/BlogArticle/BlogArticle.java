package com.nathalia.qa.pages.BlogArticle;

import com.nathalia.qa.base.BasePage;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class BlogArticle extends BasePage {

    private BlogArticle(WebDriver driver) {
        super(driver);
    }

    public static BlogArticle of(WebDriver driver) {
        return new BlogArticle(driver);
    }

    public BlogArticle validateArticleHeadline(String expectedTitle) {
        String actualTitle = getText(BlogArticleElements.ARTICLE_HEADLINE);

        assertThat(actualTitle).isEqualTo(expectedTitle);

        return this;
    }
}
