package com.customertimes.test.login;


import com.customertimes.framework.config.TestConfig;
import com.customertimes.framework.pages.LoginFluentPage;
import com.customertimes.framework.pages.LoginPage;
import com.customertimes.framework.pages.LoginPageFactory;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


@Epic("Sign in/Sign up")
@Story("Login to shop")
public class JuiceShopTest extends BaseTest {

    WebDriverWait wait;
    Customer customer;
    LoginPage loginPage;
    LoginFluentPage fluentPage;
    LoginPageFactory pageFactory;

    @BeforeClass
    public void loginBeforeClass() {
        loginPage = new LoginPage(driver);
        fluentPage = new LoginFluentPage(driver);
        pageFactory = new LoginPageFactory(driver);

        driver.get(TestConfig.CONFIG.baseUrl());

        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        wait = new WebDriverWait(driver, 5);

        customer = Customer.newBuilder().withName("dima@i.io").withPassword("12345678").build();

    }

    @Test
    @Feature("login")
    @Description("User can login to app")
    @TmsLink("JSH-123")
    public void userCanLoginToJuiceShop() {
        pageFactory.loginAs(customer);

        fluentPage.clickOnAccountButton();
        String actualNameText = pageFactory.getActualNameText(customer.getEmail());

        Assert.assertEquals(actualNameText, customer.getEmail() + "abraasa", "User name does not match ");
    }
}