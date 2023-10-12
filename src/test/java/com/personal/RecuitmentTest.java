package com.personal;

import org.openqa.selenium.WebDriver;
import org.personal.drivers.DriverSingelton;
import org.personal.pages.LoginPage;
import org.personal.pages.RecuitmentPage;
import org.personal.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RecuitmentTest {
    private WebDriver driver;
    private LoginPage loginPage;

    private RecuitmentPage recuitmentPage;

    @BeforeClass
    public void setUp(){
        DriverSingelton.getInstance(Constants.Chrome);
        driver = DriverSingelton.getDriver();
        String url =Constants.URL;
        driver.get(url);

        //step
        loginPage = new LoginPage();
        recuitmentPage= new RecuitmentPage();

    }

    @AfterClass
    public void finish(){
        DriverSingelton.delay(5);
        DriverSingelton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testRecuitment(){
        loginPage.loginForm("Admin", "admin123");

        recuitmentPage.gotoMenuRecuitment();
        recuitmentPage.inputFormVacancy();
        System.out.println("Succeess get:"+recuitmentPage.getTxt());
        Assert.assertEquals(recuitmentPage.getTxt(),"Add Vacancy");
//        loginPage.logout();
    }



}
