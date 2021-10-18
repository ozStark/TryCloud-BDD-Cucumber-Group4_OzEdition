package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPOM {

    @FindBy(xpath = "//*[@id=\"everyone\"]/div/div[1]")
    private WebElement allContactsCount;

    @FindBy(xpath = "//*[@id=\"everyone\"]/a/span")
    private WebElement allContactsIcon;


    public ContactsPOM() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public boolean checkContactsNum() {

        try {
            BrowserUtil.waitForVisibility(By.xpath("//*[@id=\"everyone\"]/a/span"),5);
            if (this.allContactsCount.getText().contains("2")) {
                System.out.println("2 contacts verified");
                return true;
            } else {
                System.out.println("There were " + allContactsCount.getText() +" contacts");
                return false;
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("there are no contacts");
            return false;
        }


    }


}
