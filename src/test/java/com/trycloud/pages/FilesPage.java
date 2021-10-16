package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    public boolean isFavoriteFile(String fileName){
        String sXpath="//tr[@data-file='"+fileName+"]//span[.='Favorited']/..";
        if (Driver.getDriver().findElement(By.xpath(sXpath)).getText().equals("Favorited")){
            return true;
        }
        return false;
    }

    @FindBy(xpath = "//li[@class='action-0']")
    WebElement addToFavorite;

    @FindBy(xpath = "//li[@class=' action-favorite-container']")
    WebElement removeFromFavorite;

    @FindBy(xpath = "//tbody[@id='fileList']/tr")
    List<WebElement> fileList;


    public void filesList(){
        for (WebElement eachFile : fileList) {
            System.out.println(eachFile.getText());
        }
    }
  



}
