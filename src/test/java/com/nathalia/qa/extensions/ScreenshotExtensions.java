package com.nathalia.qa.extensions;

import io.qameta.allure.Allure;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.ByteArrayInputStream;

import com.nathalia.qa.base.BaseTest;
import com.nathalia.qa.utils.ScreenshotUtils;

public class ScreenshotExtensions implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Object instance = context.getRequiredTestInstance();

        if (instance instanceof BaseTest test) {
            Allure.addAttachment(
                    "Screenshot",
                    new ByteArrayInputStream(ScreenshotUtils.capture(test.getDriver()))
            );
        }
    }
}
