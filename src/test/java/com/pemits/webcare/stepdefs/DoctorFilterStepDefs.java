package com.pemits.webcare.stepdefs;

import static com.pemits.webcare.constants.PagesUrl.DASHBOARD_URL;
import static com.pemits.webcare.constants.PagesUrl.DOCTOR_COMPONENT_URL;
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

import com.pemits.webcare.pages.DoctorPage;
import com.pemits.webcare.pages.LoginPage;

public class DoctorFilterStepDefs {

    private WebDriver webDriver;
    private WebDriverWait wait;
    private DoctorPage doctorPage;
    private String initialPaginationLabel = null;
    private String filteredPaginationLabel = null;

    @Given("I am logged into the system for doctor filtering")
    public void iAmLoggedIntoTheSystemForDoctorFiltering() {
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

    @When("I open initial doctor component")
    public void iOpenInitialDoctorComponent() {
        webDriver.get(DOCTOR_COMPONENT_URL);
        wait.until(ExpectedConditions.urlToBe(DOCTOR_COMPONENT_URL));
        doctorPage = new DoctorPage(webDriver);
        initialPaginationLabel = doctorPage.getWePaginationLabel().getText();
    }

    @And("I filter doctor by name")
    public void iFilterDoctorByName() {
        doctorPage.getWeBtnFilter().click();
        wait.until(ExpectedConditions.visibilityOf(doctorPage.getWeName()));
        doctorPage.getWeName().sendKeys("elvin");
        doctorPage.getWeBtnFilterSearch().click();
        wait.until(ExpectedConditions.visibilityOf(doctorPage.getWePaginationLabel()));
        filteredPaginationLabel = doctorPage.getWePaginationLabel().getText();
    }

    @Then("I should have a doctor list filtered")
    public void iShouldHaveADoctorListFiltered() {
        Assert.assertNotNull(initialPaginationLabel);
        Assert.assertNotNull(filteredPaginationLabel);
        Assert.assertNotEquals(initialPaginationLabel, filteredPaginationLabel);
        webDriver.close();
    }
}
