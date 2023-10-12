package org.personal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.personal.drivers.DriverSingelton;

public class LoginDemoQa {
    private WebDriver driver;
    public LoginDemoQa(){
        this.driver = DriverSingelton.getDriver();
        PageFactory.initElements(driver,this);
    }

    //a[normalize-space()='My Account']
    //input[@id='username']
    //input[@id='password']
    //button[@name='login']


    @FindBy(xpath = "/html/body/p/a")
    private WebElement btnDismiss;
    @FindBy(xpath = "//a[normalize-space()='My Account']")
    private WebElement btnMyAccount;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@name='login']")
    private WebElement btnLogin;

    @FindBy(xpath = "//strong[1]")
    private WebElement elementMyAccount;

    public void stepLogin(String username,String password){
        btnDismiss.click();
        btnMyAccount.click();
        this.inputUsername.sendKeys(username);
        this.inputPassword.sendKeys(password);
        btnLogin.click();
    }

    public String getMyAccount(){
        return  elementMyAccount.getText();
    }


}
