package com.nathalia.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum DriverEnum {
    CHROME {
        @Override
        public WebDriver create() {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            if ("true".equals(System.getProperty("headless"))) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }

            return new ChromeDriver(options);
        }
    },

    FIREFOX {
        @Override
        public WebDriver create() {
            WebDriverManager.firefoxdriver().setup();

            return new FirefoxDriver();
        }
    };

    public abstract WebDriver create();
}
