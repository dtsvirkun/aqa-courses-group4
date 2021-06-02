package com.customertimes.test;

import com.customertimes.framework.driver.WebdriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void beforeClassInTheBaseTest() {
        System.out.println("This is before class in the base test");
        driver = WebdriverRunner.getWebDriver();
    }

    @BeforeSuite
    public void setup() {
        System.out.println("This is before suite");
    }

    @AfterClass
    public void afterClass() {
        WebdriverRunner.closeWebDriver();
        System.out.println("This is after suite");
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("This is after suite");
    }
}