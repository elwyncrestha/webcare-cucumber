package com.pemits.webcare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Elvin Shrestha on 7/2/2020
 */
public class LoginPage {

    private final WebDriver webDriver;

    @FindBy(id = "username")
    private WebElement weUsername;

    @FindBy(id = "password")
    private WebElement wePassword;

    @FindBy(id = "btnLogin")
    private WebElement weBtnLogin;

    @FindBy(className = "alert-danger")
    private WebElement weErrorDiv;

    @FindBy(id = "btnGetHelp")
    private WebElement weBtnGetHelp;

    @FindBy(id = "btnFeedback")
    private WebElement weBtnFeedback;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setUsername(String username) {
        weUsername.sendKeys(username);
    }

    public void setPassword(String password) {
        wePassword.sendKeys(password);
    }

    public void clickLoginButton() {
        weBtnLogin.click();
    }

    public WebElement getErrorDiv() {
        return weErrorDiv;
    }

    public WebElement getWeBtnGetHelp() {
        return weBtnGetHelp;
    }

    public WebElement getWeBtnFeedback() {
        return weBtnFeedback;
    }
}
