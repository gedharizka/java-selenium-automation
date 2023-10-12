package org.personal.drivers;

import org.openqa.selenium.WebDriver;
import org.personal.drivers.strategies.DriverStrategy;
import org.personal.drivers.strategies.DriverStrategyImplementor;
import org.personal.utils.Constants;

import java.util.concurrent.TimeUnit;

public class DriverSingelton {
    public static DriverSingelton instance = null;

    private static WebDriver driver;

    public DriverSingelton(String driver){
        instantiate(driver);
    }

    public WebDriver instantiate(String strategy){
        DriverStrategy driverStrategy = DriverStrategyImplementor.chooseStrategy(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return  driver;
    }

    public static DriverSingelton getInstance(String driver){
        if(instance == null){
            instance = new DriverSingelton(driver);
        }

        return instance;
    }

    public static WebDriver getDriver (){
        return driver;
    }

    public static void delay(long detik){
        try {
            Thread.sleep(1000 * detik);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeObjectInstance(){
        instance = null;
        driver.quit();
    }
}
