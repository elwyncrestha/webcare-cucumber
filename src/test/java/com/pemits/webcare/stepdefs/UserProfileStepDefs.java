package com.pemits.webcare.stepdefs;

import static com.pemits.webcare.constants.PagesUrl.DASHBOARD_URL;
import static com.pemits.webcare.constants.PagesUrl.LOGIN_PAGE_URL;
import static com.pemits.webcare.constants.PagesUrl.PROFILE_COMPONENT_URL;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pemits.webcare.pages.LoginPage;
import com.pemits.webcare.pages.ProfilePage;

public class UserProfileStepDefs {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @Given("I am logged in")
    public void iAmLoggedIn() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(LOGIN_PAGE_URL);

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.setUsername("spadmin");
        loginPage.setPassword("123456");
        loginPage.clickLoginButton();
        wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.urlToBe(DASHBOARD_URL));
    }

    @When("I open user profile")
    public void iOpenUserProfile() {
        webDriver.get(PROFILE_COMPONENT_URL);
        wait.until(ExpectedConditions.urlToBe(PROFILE_COMPONENT_URL));
    }

    @Then("I should find profile component being loaded")
    public void iShouldFindProfileComponentBeingLoaded() {
        ProfilePage profilePage = new ProfilePage(webDriver);
        Assert.assertTrue(profilePage.isProfileComponentLoaded());
        webDriver.close();
    }
}
