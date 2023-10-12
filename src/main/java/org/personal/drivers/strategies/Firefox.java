package org.personal.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {
    @Override
    public WebDriver setStrategy() {
        String path ="C:\\myTools\\geckodriver-v0.33.0-win64\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
