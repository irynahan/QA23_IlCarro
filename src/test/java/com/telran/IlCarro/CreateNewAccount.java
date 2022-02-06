package com.telran.IlCarro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        acceptTermsOfUse();
        //clickWithActions(By.cssSelector("#terms-of-use"));
        clickRegistrationButton();
        Assert.assertTrue(isDeleteTabPresent());
    }

    @Test
    public void tryCheckBox(){
        clickSignUpTab();
        isRegistrationFormPresent();
        WebElement checkBox = driver.findElement(By.cssSelector("#terms-of-use"));
        checkBox.click();
        if(checkBox.isSelected()) {
            System.out.println("yes, is selected");
        } else {
            System.out.println("no, is not selected");
        }
    }

}
