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

    @FindBy(xpath = "//span[normalize-space(.)='Files']/..")
    WebElement filesBtn;

    public void clickFilesBtn(){
        filesBtn.click();
    }

    @FindBy(xpath = "//tr[@data-file='Talk']//span[.='Actions']/..")  // need change to dynamic according to file's name
    WebElement actionIcon;

//    @FindBy(xpath = "//tr[@data-file='Talk']//span[.='Favorited']/..") //need change to dynamic according to file's name
//    WebElement favoritedIcon;

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

// make sure there is at least one file marked with Favorite
    public boolean isAtLeastOneFileAsFavorite(){
        int count=0;
        for (WebElement eachFile : fileList) {
            String fileName = eachFile.getText();
            if (isFavoriteFile(fileName))
                count +=1;
        }
        if (count>=1){
            return true;
        }else {
            return false;
        }
    }

    public void clickRemoveFromFavorite(){
        for (WebElement eachFile : fileList) {
            String fileName = eachFile.getText();
            if (isFavoriteFile(fileName)){
                String fileNameXpath="//tr[@data-file='"+fileName+"']//span[.='Actions']/..";
                Driver.getDriver().findElement(By.xpath(fileNameXpath)).click();
                removeFromFavorite.click();
            }
        }
    }

    @FindBy(xpath = "//a[.='Favorites']")
    WebElement favoriteTab;

    public void clickFavoriteTab(){
        favoriteTab.click();
    }

    public void checkHasSameFileInFavoriteList(){

    }



}
