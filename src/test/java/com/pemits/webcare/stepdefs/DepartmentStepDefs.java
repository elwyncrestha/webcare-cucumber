package com.pemits.webcare.stepdefs;

import static com.pemits.webcare.constants.PagesUrl.DASHBOARD_URL;
import static com.pemits.webcare.constants.PagesUrl.DEPARTMENT_COMPONENT_URL;
import static com.pemits.webcare.constants.PagesUrl.LOGIN_PAGE_URL;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pemits.webcare.constants.GlobalConstants;
import com.pemits.webcare.pages.DepartmentPage;
import com.pemits.webcare.pages.LoginPage;

public class DepartmentStepDefs {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @Given("I am logged into the system for department listing")
    public void iAmLoggedIntoTheSystemForDepartmentListing() {
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

    @When("I open department component")
    public void iOpenDepartmentComponent() {
        webDriver.get(DEPARTMENT_COMPONENT_URL);
        wait.until(ExpectedConditions.urlToBe(DEPARTMENT_COMPONENT_URL));
    }

    @Then("I should have department list populated")
    public void iShouldHaveDepartmentListPopulated() {
        DepartmentPage departmentPage = new DepartmentPage(webDriver);
        String paginationLabel = departmentPage.getWePaginationLabel().getText();
        Assert.assertTrue(paginationLabel.matches(GlobalConstants.PAGINATION_LABEL));
        webDriver.close();
    }
}
