package com.pemits.webcare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpDeskPage {

    private final WebDriver webDriver;

    @FindBy(id = "name")
    private WebElement weName;

    @FindBy(id = "email")
    private WebElement weEmail;

    @FindBy(id = "contactNumber")
    private WebElement weContactNumber;

    @FindBy(id = "query")
    private WebElement weQuery;

    @FindBy(id = "btnHelpDeskSubmit")
    private WebElement weBtnHelpDeskSubmit;

    public HelpDeskPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebElement getWeName() {
        return weName;
    }

    public WebElement getWeEmail() {
        return weEmail;
    }

    public WebElement getWeContactNumber() {
        return weContactNumber;
    }

    public WebElement getWeQuery() {
        return weQuery;
    }

    public WebElement getWeBtnHelpDeskSubmit() {
        return weBtnHelpDeskSubmit;
    }
}
