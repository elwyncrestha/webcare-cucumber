package com.pemits.webcare.stepdefs;

import static com.pemits.webcare.constants.PagesUrl.FEEDBACK_COMPONENT_URL;
import static com.pemits.webcare.constants.PagesUrl.LOGIN_PAGE_URL;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pemits.webcare.pages.FeedbackPage;
import com.pemits.webcare.pages.LoginPage;

public class FeedbackStepDefs {

    private WebDriver webDriver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private FeedbackPage feedbackPage;

    @Given("I am in the login page for the feedback")
    public void iAmInTheLoginPageForTheFeedback() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(LOGIN_PAGE_URL);

        loginPage = new LoginPage(webDriver);
        feedbackPage = new FeedbackPage(webDriver);
    }

    @When("I click the get feedback button")
    public void iClickTheGetFeedbackButton() {
        loginPage.getWeBtnFeedback().click();
        wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.urlToBe(FEEDBACK_COMPONENT_URL));
    }

    @And("I enter feedback details")
    public void iEnterFeedbackDetails() {
        feedbackPage.getWeName().sendKeys("Elvin");
        feedbackPage.getWeEmail().sendKeys("elwyncrestha@hotmail.com");
        feedbackPage.getWeContactNumber().sendKeys("1234567890");
        feedbackPage.getWeMessage().sendKeys("This is test feedback.");
        feedbackPage.getWeBtnFeedbackSubmit().click();
        wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
    }

    @Then("I should have feedback submitted and redirected to login page")
    public void iShouldHaveFeedbackSubmittedAndRedirectedToLoginPage() {
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(LOGIN_PAGE_URL, currentUrl);
        webDriver.close();
    }
}
