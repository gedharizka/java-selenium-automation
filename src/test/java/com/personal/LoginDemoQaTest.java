package com.personal;

import org.openqa.selenium.WebDriver;
import org.personal.drivers.DriverSingelton;
import org.personal.pages.LoginDemoQa;
import org.personal.pages.LoginPage;
import org.personal.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginDemoQaTest {
    private WebDriver driver;

    private LoginDemoQa loginDemoQa;

    @BeforeClass
    public void setUp(){
        DriverSingelton.getInstance(Constants.Chrome);
        driver = DriverSingelton.getDriver();
        String url =Constants.URLDEMOQA;
        driver.get(url);

        //step
        loginDemoQa = new LoginDemoQa();
    }

    @AfterClass
    public void finish(){
        DriverSingelton.delay(3);
        DriverSingelton.closeObjectInstance();
    }

    @Test
    public void validLogin(){
        loginDemoQa.stepLogin("gedharizka17","JuaraCoding@2023");
        System.out.println("Success login");
        Assert.assertEquals(loginDemoQa.getMyAccount(),"gedharizka17");
    }
}
