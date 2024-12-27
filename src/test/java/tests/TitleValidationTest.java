package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.WebDriverUtils;

public class TitleValidationTest extends BaseTest {
	

	@Test (priority=0)
    public void validatePageTitle() {
        LoginPage loginPage = new LoginPage(driver);
        String actualTitle = loginPage.getPageTitle();
        String expectedTitle = "Guru99 Bank Home Page";
        Assert.assertEquals(actualTitle, expectedTitle, "Title validation failed!");
    }
    
    @Test (priority=1)
    public void checkLoginPageElements() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(WebDriverUtils.isElementPresent(loginPage.loginButton), "Login button is missing or has incorrect title.");
        Assert.assertTrue(WebDriverUtils.isElementPresent(loginPage.resetButton), "Reset button is missing or has incorrect title.");
        Assert.assertTrue(WebDriverUtils.isElementPresent(loginPage.usernameField), "UserID field is missing or has incorrect title.");
        Assert.assertTrue(WebDriverUtils.isElementPresent(loginPage.passwordField), "Password field is missing or has incorrect title.");
    }
    
    @Test (priority=2)
    public void checkLoginWithExcelData() throws IOException {

        ExcelUtils excelUtils = new ExcelUtils("D:\\Java automation\\CapstoneProject\\src\\main\\resources\\TestData.xlsx", "Sheet1");

        String username = excelUtils.getCellData(1, 0);  // Row 1, Column 0 (username)
        String password = excelUtils.getCellData(1, 1);  // Row 1, Column 1 (password)

        LoginPage loginPage = new LoginPage(driver);
        WebDriverUtils.sendKeysToElement(loginPage.usernameField, username);
        WebDriverUtils.sendKeysToElement(loginPage.passwordField, password);
        WebDriverUtils.clickElement(loginPage.loginButton);

        // Validate the login page title after login
        String actualTitle = loginPage.getPageTitle();
        String expectedTitle = "Guru99 Bank Manager HomePage";
        Assert.assertEquals(actualTitle, expectedTitle, "Title validation failed!");

  }

    @Test (priority=3)
    public void verifyManagerAndNewCustomerLinks() throws IOException {
    	checkLoginWithExcelData();
    	HomePage homePage = new HomePage(driver);
        Assert.assertTrue(WebDriverUtils.isElementPresent(homePage.managerLink), "Manager link is not present!");
        Assert.assertTrue(WebDriverUtils.isElementPresent(homePage.newCustomerLink), "New Customer link is not present!");
    
    }
}

