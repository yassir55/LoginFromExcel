package com.api.cucumber.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class LoginPage_PF {


    @FindBy(id = "txtUsername")
    WebElement txt_Username;

    @FindBy(id = "txtPassword")
    WebElement txt_Password;

    @FindBy(id = "btnLogin")
    WebElement login;


    WebDriver driver;

    // when this constructor call all Webelement will be initialist
    public LoginPage_PF(WebDriver driver) {
        this.driver = driver;
        // PageFactory.initElements(driver, this);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);

    }

    public void enterEmail(String usernane) {
        txt_Username.sendKeys(usernane);
    }

    public void enterPassword(String password) {
        txt_Password.sendKeys(password);
    }

    public void clilckOnConection() {
        login.click();
    }




}