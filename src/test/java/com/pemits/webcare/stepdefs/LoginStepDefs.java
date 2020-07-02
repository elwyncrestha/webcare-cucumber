package com.pemits.webcare.stepdefs;

import static com.pemits.webcare.constants.PagesUrl.DASHBOARD_URL;
import static com.pemits.webcare.constants.PagesUrl.LOGIN_PAGE_URL;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pemits.webcare.pages.LoginPage;

/**
 * @author Elvin Shrestha on 7/2/2020
 */
public class LoginStepDefs {

    private LoginPage loginPage;

    @Given("I am in a login page")
    public void iAmInALoginPage() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(LOGIN_PAGE_URL);
        loginPage = new LoginPage(chromeDriver);
    }

    @When("I enter invalid login credentials")
    public void iEnterInvalidLoginCredentials() {
        loginPage.setUsername("spadmin");
        loginPage.setPassword("12345678");
        loginPage.clickLoginButton();
    }

    @Then("I should not be logged into the application")
    public void iShouldNotBeLoggedIntoTheApplication() {
        WebDriverWait wait = new WebDriverWait(loginPage.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorDiv()));
        String currentUrl = loginPage.getWebDriver().getCurrentUrl();
        Assert.assertNotEquals(DASHBOARD_URL, currentUrl);
        loginPage.getWebDriver().close();
    }

    @When("I enter valid login credentials")
    public void iEnterValidLoginCredentials() {
        loginPage.setUsername("spadmin");
        loginPage.setPassword("123456");
        loginPage.clickLoginButton();
    }

    @Then("I should be logged into the application")
    public void iShouldBeLoggedIntoTheApplication() {
        WebDriverWait wait = new WebDriverWait(loginPage.getWebDriver(), 5);
        wait.until(ExpectedConditions.urlToBe(DASHBOARD_URL));
        String currentUrl = loginPage.getWebDriver().getCurrentUrl();
        Assert.assertEquals(DASHBOARD_URL, currentUrl);
        loginPage.getWebDriver().close();
    }
}
