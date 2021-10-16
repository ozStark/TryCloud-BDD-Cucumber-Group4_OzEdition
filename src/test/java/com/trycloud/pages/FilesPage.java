package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilesPage {
    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[normalize-space(.)='Files']")
    WebElement filesBtn;

    public void clickFilesBtn(){
        filesBtn.click();
    }

    @FindBy(xpath = "//tr[@data-file='Talk']//span[.='Actions']/..")  // need change to dynamic according to file's name
    WebElement actionIcon;

    @FindBy(xpath = "//tr[@data-file='Talk']//span[.='Favorited']/..") //need change to dynamic according to file's name
    WebElement favoritedIcon;

    @FindBy(xpath = "//li[@class='action-0']")
    WebElement addToFavorite;

    @FindBy(xpath = "//li[@class=' action-favorite-container']")
    WebElement removeFromFavorite;

    




}
