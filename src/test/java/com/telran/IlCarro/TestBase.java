package com.telran.IlCarro;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://ilcarro.xyz/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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


    public boolean isSignUpTabPresent() {
        return isElementPresent(By.xpath("//a[contains(.,' Sign up ')]"));
    }

    public void clickSignUpTab() {
        click(By.xpath("//a[contains(.,' Sign up ')]"));
    }

    public void clickLogoutTab(){
        click(By.xpath("//a[contains(.,' Logout ')]"));
    }

    public boolean isRegistrationFormPresent(){
        return  isElementPresent(By.cssSelector(".login-registration-container"));
    }

    public void clearField(By by) {
        driver.findElement(by).clear();
    }

    public void sendKeysField(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void acceptTermsOfUse(){
        driver.findElement(By.cssSelector("#terms-of-use"));
    }

    public void clickWithActions(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).build().perform();
        element.click();
    }

    public void clickRegistrationButton() {
        click(By.xpath("//button[text()='Y’alla!']"));
    }

    public void fillInField(By locator, String text) {
        click(locator);
        clearField(locator);
        sendKeysField(locator, text);
    }

    public void fillInRegistrationForm(String name, String lastName, String email, String password) {
        fillInField(By.cssSelector("#name"), name);
        fillInField(By.cssSelector("#lastName"), lastName);
        fillInField(By.cssSelector("#email"), email);
        fillInField(By.cssSelector("#password"), password);
    }

    public boolean isDeleteTabPresent(){
        return isElementPresent(By.xpath("//a[contains(.,'Delete account')]"));
    }


    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }

}
