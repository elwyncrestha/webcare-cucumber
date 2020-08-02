package com.pemits.webcare.stepdefs;

import static com.pemits.webcare.constants.PagesUrl.HELP_DESK_COMPONENT_URL;
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

import com.pemits.webcare.pages.HelpDeskPage;
import com.pemits.webcare.pages.LoginPage;

public class HelpDeskStepDefs {

    private LoginPage loginPage;
    private HelpDeskPage helpDeskPage;
    private WebDriver webDriver;
    private WebDriverWait wait;

    @Given("I am in the login page")
    public void iAmInTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(LOGIN_PAGE_URL);

        loginPage = new LoginPage(webDriver);
        helpDeskPage = new HelpDeskPage(webDriver);
    }

    @When("I click the get help button")
    public void iClickTheGetHelpButton() {
        loginPage.getWeBtnGetHelp().click();
        wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.urlToBe(HELP_DESK_COMPONENT_URL));
    }

    @And("I enter help desk query details")
    public void iEnterHelpDeskQueryDetails() {
        helpDeskPage.getWeName().sendKeys("Elvin");
        helpDeskPage.getWeEmail().sendKeys("elwyncrestha@hotmail.com");
        helpDeskPage.getWeContactNumber().sendKeys("1234567890");
        helpDeskPage.getWeQuery().sendKeys("Test query 1?");
        helpDeskPage.getWeBtnHelpDeskSubmit().click();
        wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
    }

    @Then("I should have query requested and redirected to login page")
    public void iShouldHaveQueryRequestedAndRedirectedToLoginPage() {
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(LOGIN_PAGE_URL, currentUrl);
        webDriver.close();
    }
}
