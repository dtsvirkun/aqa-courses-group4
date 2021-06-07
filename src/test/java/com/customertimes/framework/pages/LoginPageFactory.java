package com.customertimes.framework.pages;

import com.customertimes.model.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;

public class LoginPageFactory extends AbstractPage {

    private WebDriverWait wait;

    @FindBy(id = "navbarAccount")
    private WebElement navbarAccount;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "navbarLoginButton")
    private WebElement loginSubmitButton;

    private By goToUserProfileButton = By.cssSelector("button[aria-label='Go to user profile'] span");


    public LoginPageFactory(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
        PageFactory.initElements(driver,this);
    }

    @Override
    public void openPage() {
        driver.get("url/login");
    }


    @Step
    public String getActualNameText(String currentEmail) {
        wait.until(ExpectedConditions.textToBe(goToUserProfileButton, currentEmail));
        String actualNameText = getWebDriver().findElement(goToUserProfileButton).getText();
        return actualNameText;
    }

    @Step("Click on account button")
    public void clickOnAccountButton() {
        navbarAccount.click();
    }

    @Step("Click on login button")
    public void clickOnLoginButton() {
        loginButton.click();
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @Step("Enter email")
    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    @Step
    public void navigateToLoginPage() {
        clickOnAccountButton();
        loginSubmitButton.click();
    }

    @Step
    public void loginAs(Customer customer) {
        navigateToLoginPage();
        enterEmail(customer.getEmail());
        enterPassword(customer.getPassword());
        clickOnLoginButton();
    }
}
