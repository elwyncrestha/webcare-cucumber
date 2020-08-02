package com.pemits.webcare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedbackPage {

    private final WebDriver webDriver;

    @FindBy(id = "fullName")
    private WebElement weName;

    @FindBy(id = "email")
    private WebElement weEmail;

    @FindBy(id = "phoneNo")
    private WebElement weContactNumber;

    @FindBy(id = "message")
    private WebElement weMessage;

    @FindBy(id = "btnFeedbackSubmit")
    private WebElement weBtnFeedbackSubmit;

    public FeedbackPage(WebDriver webDriver) {
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

    public WebElement getWeMessage() {
        return weMessage;
    }

    public WebElement getWeBtnFeedbackSubmit() {
        return weBtnFeedbackSubmit;
    }
}
