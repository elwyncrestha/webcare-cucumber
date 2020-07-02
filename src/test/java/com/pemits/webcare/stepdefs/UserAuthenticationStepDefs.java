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

public class UserAuthenticationStepDefs {

    private ChromeDriver chromeDriver;

    @Given("I am not authenticated")
    public void iAmNotAuthenticated() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    @When("I am opening dashboard using direct url")
    public void iAmOpeningDashboardUsingDirectUrl() {
        chromeDriver.get(DASHBOARD_URL);
    }

    @Then("I should be redirected to login for authentication")
    public void iShouldBeRedirectedToLoginForAuthentication() {
        WebDriverWait wait = new WebDriverWait(chromeDriver, 3);
        wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        String currentUrl = chromeDriver.getCurrentUrl();
        Assert.assertEquals(LOGIN_PAGE_URL, currentUrl);
        chromeDriver.close();
    }
}
