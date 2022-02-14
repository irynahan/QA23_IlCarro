package com.telran.IlCarro.fm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase {

    public HeaderHelper(WebDriver driver) {
        super(driver);
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

    public boolean isDeleteTabPresent(){
        return isElementPresent(By.xpath("//a[contains(.,'Delete account')]"));
    }
}
