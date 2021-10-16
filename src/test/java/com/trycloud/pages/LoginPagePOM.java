package com.trycloud.pages;

import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOM {

    @FindBy(id = "user")
    private WebElement userInput;

    @FindBy(id = "password")
    private WebElement passInput;

    @FindBy(id = "submit-form")
    private WebElement loginBtn;



    public LoginPagePOM(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void goTo(){
        Driver.getDriver().get(ConfigReader.read("url"));
    }

    public void fillCredentials(String userName, String password){
        this.userInput.sendKeys(userName);
        this.passInput.sendKeys(password);
    }

    public void clickLogin(){
        this.loginBtn.click();
    }

    public void isAtLoginPage(){
        String homePage = "http://qa2.trycloud.net/index.php/apps/dashboard/";

        Assert.assertEquals(homePage,Driver.getDriver().getCurrentUrl());
    }


}
