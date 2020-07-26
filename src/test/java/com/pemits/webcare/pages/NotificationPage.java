package com.pemits.webcare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationPage {

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    @FindBy(tagName = "nb-card-body")
    private WebElement weNotificationCard;

    public NotificationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 2);
        PageFactory.initElements(this.webDriver, this);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebElement getWeNotificationCard() {
        return weNotificationCard;
    }

    public boolean hasNotificationItem() {
        try {
            wait.until(ExpectedConditions.visibilityOf(weNotificationCard));
            return webDriver.findElements(By.tagName("nb-list-item")).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
