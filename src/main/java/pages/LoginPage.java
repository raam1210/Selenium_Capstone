package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WebDriverUtils;

public class LoginPage {

    WebDriver driver;

    public WebElement usernameField;
    public WebElement passwordField;
    public WebElement loginButton;
    public WebElement resetButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        usernameField = driver.findElement(By.name("uid"));
        passwordField = driver.findElement(By.name("password"));
        loginButton = driver.findElement(By.name("btnLogin"));
        resetButton = driver.findElement(By.name("btnReset"));
    }

    public void enterUsername(String username) {
    	WebDriverUtils.sendKeysToElement(usernameField, username);
    }

    public void enterPassword(String password) {
    	WebDriverUtils.sendKeysToElement(passwordField, password);
    }

    public void clickLoginButton() {
    	WebDriverUtils.clickElement(loginButton);
    }

    public void clickResetButton() {
    	WebDriverUtils.clickElement(resetButton);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
