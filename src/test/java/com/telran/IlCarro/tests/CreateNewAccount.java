package com.telran.IlCarro.tests;

import com.telran.IlCarro.fm.HelperBase;
import com.telran.IlCarro.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccount extends TestBase {

    @BeforeMethod
    public void ensurePreConditions(){
        if (!app.getHeader().isSignUpTabPresent()) {
            app.getHeader().clickLogoutTab();
        }
    }

    @Test
    public void createNewAccontPositiveTest() {
        app.getHeader().clickSignUpTab();
        app.getUser().isRegistrationFormPresent();
        app.getUser().fillInRegistrationForm(new User().setName("Oliver6").setLastName("King6").setEmail("o6.king@mail.ru").setPassword("Ww123456&"));
        //acceptTermsOfUse();
        //clickWithActions(By.cssSelector("#terms-of-use"));
        app.getUser().clickPolicyBox();
        HelperBase.pause(2);
        //app.getUser().clickRegistrationButton();
        app.getUser().clickRegistrationButton();

        Assert.assertTrue(app.getHeader().isDeleteTabPresent());
    }
}
