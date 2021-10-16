package com.trycloud.pages;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPOM {

    @FindBy(xpath = "//div[@class='avatardiv avatardiv-shown']")
    private WebElement logoutDrop;

    @FindBy(xpath = "//li[@ data-id='logout']")
    private WebElement logoutBtn;

    public CommonPOM(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void logOut(){
        this.logoutDrop.click();
        BrowserUtil.waitForVisibility(By.xpath("//li[@ data-id='logout']"),3);
        this.logoutBtn.click();
    }

}
