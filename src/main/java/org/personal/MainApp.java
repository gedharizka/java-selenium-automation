package org.personal;

import org.openqa.selenium.WebDriver;
import org.personal.drivers.DriverSingelton;
import org.personal.pages.LoginPage;
import org.personal.pages.RecuitmentPage;
import org.personal.utils.Constants;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainApp {
    private static WebDriver driver;

    public static void main(String[] args) {
        DriverSingelton.getInstance(Constants.Chrome);
        driver = DriverSingelton.getDriver();
        String url =Constants.URL;
        driver.get(url);

        //step
        LoginPage loginPage = new LoginPage();
        RecuitmentPage recruitmentPage = new RecuitmentPage();
//        loginPage.login();

        loginPage.loginForm("Admin","admin123");
        System.out.println("login valid");
        recruitmentPage.gotoMenuRecuitment();
        loginPage.logout();
        System.out.println("Logout success");
        loginPage.loginForm("Adminz","admin123");
        System.out.println("login in valid");

        DriverSingelton.delay(3);
        DriverSingelton.closeObjectInstance();
    }
}