package com.customertimes.test.login;


import com.customertimes.framework.pages.LoginFluentPage;
import com.customertimes.framework.pages.LoginPage;
import com.customertimes.framework.pages.LoginPageFactory;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;

public class JuiceShopTest extends BaseTest {

    WebDriverWait wait;
    Customer customer;
    LoginPage loginPage;
    LoginFluentPage fluentPage;
    LoginPageFactory pageFactory;

    @BeforeClass
    public void loginBeforeClass() throws InterruptedException {
        driver.get("http://beeb0b73705f.sn.mynetname.net:3000/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        wait = new WebDriverWait(driver, 5);

        customer = Customer.newBuilder().withName("dima@i.io").withPassword("12345678").build();
        loginPage = new LoginPage(driver);
        fluentPage = new LoginFluentPage(driver);
        pageFactory = new LoginPageFactory(driver);
    }

    @Test
    public void userCanLoginToJuiceShop() {
        pageFactory.loginAs(customer);

        fluentPage.clickOnAccountButton();
        String actualNameText = pageFactory.getActualNameText(customer.getEmail());

        Assert.assertEquals(actualNameText, customer.getEmail(), "User name does not match ");
    }


}