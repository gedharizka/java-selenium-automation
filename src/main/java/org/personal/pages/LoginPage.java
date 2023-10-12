package org.personal.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.personal.drivers.DriverSingelton;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingelton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //locator;
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    private WebElement profileBtn;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement dashboardTitle;

    @FindBy(xpath = "//p[contains(@class, 'oxd-alert-content-text')]")
    private WebElement errorMesage;
    @FindBy(xpath = "//span[contains(@class, 'oxd-input-field-error-message')]")
    private WebElement fieldRequire;

    public void login(){
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        btnLogin.click();
    }

    public void loginForm(String usernameValue, String passwordValue){
        this.username.sendKeys(usernameValue);
        this.password.sendKeys(passwordValue);
        btnLogin.click();

    }

    public void logout(){
        profileBtn.click();
        logoutBtn.click();
    }

    public void clearUsername(){
        username.sendKeys(Keys.CONTROL+"a");
        username.sendKeys(Keys.DELETE);
    }

    public void clearPassword(){
        password.sendKeys(Keys.CONTROL+"a");
        password.sendKeys(Keys.DELETE);
    }

    public String getTxtDashboard(){
        return dashboardTitle.getText();
    }

    public  String getErrorMessage(){
        return  errorMesage.getText();
    }

    public String getRequiredField(){
        return fieldRequire.getText();
    }

}
