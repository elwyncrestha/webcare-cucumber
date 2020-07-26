package com.pemits.webcare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    @FindBy(tagName = "app-profile")
    private WebElement weProfileComponent;

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 2);
        PageFactory.initElements(this.webDriver, this);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebElement getWeProfileComponent() {
        return weProfileComponent;
    }

    public boolean isProfileComponentLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOf(weProfileComponent));
            return webDriver.findElements(By.tagName("app-profile")).size() == 1;
        } catch (Exception e) {
            return false;
        }
    }
}
