package com.telran.IlCarro.fm;

import com.telran.IlCarro.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isRegistrationFormPresent(){
        return  isElementPresent(By.cssSelector(".login-registration-container"));
    }

    public void acceptTermsOfUse(){
        driver.findElement(By.xpath("//label[@for='terms-of-use']"));
    }

    public void clickRegistrationButton() {
        // click(By.xpath("//button[text()='Y’alla!']"));
        // click(By.xpath("/html[1]/body[1]/app-root[1]/app-navigator[1]/app-login-registration[1]/div[1]/div[1]/div[1]/app-registration[1]/form[1]/button[1]"));
        click(By.cssSelector("[type='submit']"));
    }
    public void clickRegistrationButtonWithAction() {
        clickWithActions(By.cssSelector("[type='submit']"));
    }

    public void fillInRegistrationForm(User user) {
        fillInField(By.cssSelector("#name"), user.getName());
        fillInField(By.cssSelector("#lastName"), user.getLastName());
        fillInField(By.cssSelector("#email"), user.getEmail());
        fillInField(By.cssSelector("#password"), user.getPassword());
    }

    public void clickPolicyBox() {
        WebElement element = driver.findElement(By.xpath("//label[@for='terms-of-use']"));
        Rectangle rectangle = element.getRect();
        int offSetX = rectangle.getWidth()/5;
        int offSetY = rectangle.getHeight()/2;
        Actions actions = new Actions(driver);
        actions.moveToElement(element).release().build().perform();
        System.out.println(offSetX + " "+ offSetY);
        actions.moveByOffset(offSetX, offSetY).click().release().build().perform();
    }

}
