package org.personal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.personal.drivers.DriverSingelton;

public class RecuitmentPage {
    private WebDriver driver;

    public RecuitmentPage(){
        this.driver = DriverSingelton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement menuRecruitment;
    @FindBy(xpath = "//a[normalize-space()='Vacancies']")
    private WebElement btnVacancies;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAdd;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active']")
    private WebElement inputName;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    private WebElement selectJobTitle;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    private WebElement inputHiringManager;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
    private WebElement textVerify;

    public void inputFormVacancy(){
        btnVacancies.click();
        btnAdd.click();
        inputName.sendKeys("Yuhuuu");
        selectJobTitle.sendKeys("Chief");
        inputHiringManager.sendKeys("Sara  Tencrady");
        btnSubmit.click();
    }

    public String getTxt(){
        return textVerify.getText();
    }

    //a[normalize-space()='Vacancies']
    //button[normalize-space()='Add']
    //input[@class='oxd-input oxd-input--active']
    //div[@class='oxd-select-text-input']
    //input[@placeholder='Type for hints...']
    //button[@type='submit']
    //h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']

    public void gotoMenuRecuitment(){
        menuRecruitment.click();
    }
}
