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
    public void createNewAccountPositiveTest() {
        addUser("Oliver8", "King9", "o9.king@mail.ru", "Ww123456&");
        HelperBase.pause(5);
        Assert.assertTrue(app.getHeader().isDeleteTabPresent());
    }

    public void addUser(String name, String lastName, String email, String password) {
        app.getHeader().clickSignUpTab();
        app.getUser().isRegistrationFormPresent();
        app.getUser().fillInRegistrationForm(new User().setName(name).setLastName(lastName).setEmail(email).setPassword(password));
        //acceptTermsOfUse();
        //clickWithActions(By.cssSelector("#terms-of-use"));
        app.getUser().clickPolicyBox();
        HelperBase.pause(2);
        app.getUser().clickRegistrationButton();
    }

    @Test (dataProvider = "newUserFromCSV", dataProviderClass = com.telran.IlCarro.fm.DataProviders.class)
    public void createNewAccountPositiveFromDataProviderWithCSVTest(User user) {
        app.getHeader().clickSignUpTab();
        app.getUser().isRegistrationFormPresent();
        app.getUser().fillInRegistrationForm(user);
        app.getUser().clickPolicyBox();
        HelperBase.pause(2);
        app.getUser().clickRegistrationButton();
        HelperBase.pause(5);
        Assert.assertTrue(app.getHeader().isDeleteTabPresent());
    }
}
