package com.customertimes.test.aws;


import com.customertimes.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;


public class AmazonTest extends BaseTest {

    @AfterMethod
    public void loginAfterTest() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @Test
    public void checkAmazonTitle() {
        driver.get("https://amazon.com");
        try {
            Thread.sleep(4_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle =  driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "title is not expected");
    }
}