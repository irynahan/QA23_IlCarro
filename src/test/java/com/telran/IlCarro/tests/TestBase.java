package com.telran.IlCarro.tests;

import com.telran.IlCarro.fm.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setup(){
        app.init();
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        app.stop();
    }

}
