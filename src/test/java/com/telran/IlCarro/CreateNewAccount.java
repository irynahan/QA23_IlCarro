package com.telran.IlCarro;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccount extends TestBase {

    @BeforeMethod
    public void ensurePreConditions(){
        if (!isSignUpTabPresent()) {
            clickLogoutTab();
        }
    }
        // o.butter@gmial.com passw:Qq123456& Olga Butter


    @Test
    public void createNewAccontPositiveTest() {
        clickSignUpTab();
        isRegistrationFormPresent();
        fillInRegistrationForm("Oliver", "King", "o.king@mail.ru", "Ww123456&");
        //acceptTermsOfUse();
        //clickWithActions(By.cssSelector("#terms-of-use"));
        clickPolicyBox();
        clickRegistrationButton();
        //Assert.assertTrue(isDeleteTabPresent());
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

    @Test
    public void tryCheckBox(){
        clickSignUpTab();
        isRegistrationFormPresent();
        WebElement checkBox = driver.findElement(By.cssSelector("#terms-of-use"));
        //checkBox.click();
        clickWithActions(By.cssSelector("#terms-of-use"));
        if(checkBox.isSelected()) {
            System.out.println("yes, is selected");
        } else {
            System.out.println("no, is not selected");
        }
    }

}
