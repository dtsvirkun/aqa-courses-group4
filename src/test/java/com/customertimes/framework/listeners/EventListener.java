package com.customertimes.framework.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventListener implements WebDriverEventListener {

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("clicked element with " + getLocatorFromElement(element));
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("change value of element with " + getLocatorFromElement(webElement));
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("changed value of element with " + getLocatorFromElement(webElement));
    }

    @Override
    public void afterFindBy(By by, WebElement arg1, WebDriver arg2) {
        System.out.println("found element " + by);
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("after back");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        System.out.println("after forward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("before navigation refresh");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("after navigation refresh");
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("navigated to " + url);
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        //LOGGER.info("execute script " + script);
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("click element with " + getLocatorFromElement(element));
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver arg2) {
        System.out.println("find element " + by);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("before back");
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("before forward");
    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        System.out.println("");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        System.out.println("");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        System.out.println("");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        System.out.println("");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("navigate to " + url);
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        //LOGGER.info("running script " + script);
    }

    private String getLocatorFromElement(WebElement element) {
        String str = element.toString();
        Pattern p = Pattern.compile("->\\s(.*)(?=\\])");
        Matcher m = p.matcher(str);
        return m.find() && m.groupCount() > 0 ? m.group(1) : str;
    }
}