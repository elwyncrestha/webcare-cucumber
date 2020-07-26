package com.pemits.webcare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientPage {

    private final WebDriver webDriver;

    @FindBy(id = "paginationLabel")
    private WebElement wePaginationLabel;

    public PatientPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebElement getWePaginationLabel() {
        return wePaginationLabel;
    }
}
