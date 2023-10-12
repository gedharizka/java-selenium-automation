package com.personal;

import org.openqa.selenium.WebDriver;
import org.personal.drivers.DriverSingelton;
import org.personal.pages.LoginPage;
import org.personal.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingelton.getInstance(Constants.Chrome);
        driver = DriverSingelton.getDriver();
        String url =Constants.URL;
        driver.get(url);

        //step
        loginPage = new LoginPage();
    }


    @AfterClass
    public void finish(){
        DriverSingelton.delay(3);
        DriverSingelton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void validLogin(){
        loginPage.loginForm("Admin", "admin123");
        Assert.assertEquals(loginPage.getTxtDashboard(),"Dashboard");
        System.out.println("test valid login");
        loginPage.logout();
    }

    @Test(priority = 2)
    public void inValidLogin(){
        loginPage.loginForm("Admina", "admin123");
        Assert.assertEquals(loginPage.getErrorMessage(),"Invalid credentials");
        System.out.println("test valid login");
    }

    @Test(priority = 3)
    public void inValidLoginEmpyUsername(){
        loginPage.loginForm("", "admin123");
        Assert.assertEquals(loginPage.getRequiredField(),"Required");
        System.out.println("test valid login");
    }

    @Test(priority = 4)
    public void inValidLoginEmpyPassword(){
        loginPage.clearUsername();
        loginPage.clearPassword();
        loginPage.loginForm("Admin", "");
        Assert.assertEquals(loginPage.getRequiredField(),"Required");
        System.out.println("test valid login");
    }

    @Test(priority = 5)
    public void inValidLoginEmpyAll(){
        loginPage.clearUsername();
        loginPage.clearPassword();
        loginPage.loginForm("", "");
        Assert.assertEquals(loginPage.getRequiredField(),"Required");
        System.out.println("test valid login");
    }

}
