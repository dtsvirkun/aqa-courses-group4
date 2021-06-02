package com.customertimes.framework.pages;

import com.customertimes.model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends AbstractPage {

    private WebDriverWait wait;

    private By navBarAccount = By.id("navbarAccount");
    private By loginButton = By.id("loginButton");
    private By passwordField =  By.id("password");
    private By emailField = By.id("email");
    private By loginSubmitButton = By.id("navbarLoginButton");
    private By goToUserProfileButton = By.cssSelector("button[aria-label='Go to user profile'] span");
    private String searchXpathLocator = "//*[text()='%s']";


    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    public void openPage() {
        driver.get("url/login");
    }

    public void searchByText(String text) {
        driver.findElement(By.xpath(String.format(searchXpathLocator, text)));
    }

    public String getActualNameText(String currentEmail) {
        wait.until(ExpectedConditions.textToBe(goToUserProfileButton, currentEmail));
        String actualNameText = driver.findElement(goToUserProfileButton).getText();
        return actualNameText;
    }

    public void clickOnAccountButton() {
        driver.findElement(navBarAccount).click();
    }

    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void enterEmail(String email) {
        WebElement emailElement =  driver.findElement(emailField);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void navigateToLoginPage() {
        clickOnAccountButton();
        driver.findElement(loginSubmitButton).click();
    }

    public void loginAs(Customer customer) {
        navigateToLoginPage();
        enterEmail(customer.getEmail());
        enterPassword(customer.getPassword());
        clickOnLoginButton();
    }
}
