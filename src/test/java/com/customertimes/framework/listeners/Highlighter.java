package com.customertimes.framework.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;
import static java.lang.Thread.sleep;

public class Highlighter extends AbstractWebDriverEventListener {

    public static <T extends WebElement> T highlight(T element) {
        return highlight(element, "orange");
    }

    public static <T extends WebElement> T highlight(T element, final String color) {
        if (element != null && element.getAttribute("__selenideHighlighting") == null) {
            for (int i = 1; i < 4; i++) {
                transform(element, color, i);
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 4; i > 0; i--) {
                transform(element, color, i);
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return element;
    }

    private static void transform(WebElement element, String color, int i) {
        ((JavascriptExecutor)getWebDriver()).executeScript(
                "arguments[0].setAttribute('__selenideHighlighting', 'done'); " +
                        "arguments[0].setAttribute(arguments[1], arguments[2])",
                element,
                "style",
                "border: " + i + "px solid " + color + "; border-style: dotted; " +
                        "transform: scale(1, 1." + i + ");");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        highlight(element, "orange");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        highlight(element, "red");
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        highlight(element, "green");
    }
}