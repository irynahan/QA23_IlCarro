package com.telran.IlCarro.fm;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException el){
            return false;
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void clearField(By by) {
        driver.findElement(by).clear();
    }

    public void sendKeysField(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void fillInField(By locator, String text) {
        if (text != null) {
            click(locator);
            clearField(locator);
            sendKeysField(locator, text);
        }
    }

    public void clickWithActions(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).build().perform();
        element.click();
    }

    public void jumpToFutter(By  locator) {
        driver.findElement(locator).sendKeys(Keys.CONTROL, Keys.END);
    }
}
