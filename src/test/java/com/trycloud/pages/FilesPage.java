package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.List;

public class FilesPage {
    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[normalize-space(.)='Files']/..")
    public WebElement filesBtn;


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

  
    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement createNewFolderBtn;

    @FindBy(xpath = "//span[.='New folder']")
    public WebElement newFolder;

    @FindBy(id = "view13-input-folder")
    public WebElement newFolderInputNameBox;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement newFolderInputNameSubmitBtn;

    @FindBy(xpath = "(//div[@style='background-image: url(\"/index.php/apps/theming/img/core/filetypes/folder.svg?v=0\");'])[3]")
    public WebElement newFolderCreatedImg;

    @FindBy(xpath = "//div[@class='activitysubject']")
    public WebElement youCreatedNewFolderConfirmMsg;

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


    @FindBy(xpath = "//span[.='Upload file']")
    public WebElement uploadFile;

    public void selectFromCreateFolderBtn(String options){

        Driver.getDriver().findElement(By.xpath("//span[.='"+options+"']")).click();
    }

   public WebElement delectedElement;

    public boolean clickRemoveFromFavorite(){//issue method, need modify
        WebElement result;
        for (WebElement eachFile : fileList) {
            String fileName = eachFile.getText();
            if (isFavoriteFile(fileName)){
                String fileNameXpath="//tr[@data-file='"+fileName+"']//span[.='Actions']/..";
                Driver.getDriver().findElement(By.xpath(fileNameXpath)).click();
                removeFromFavorite.click();
                break;
            }

        }
        return false;
    }

    @FindBy(xpath = "//a[.='Favorites']")
    WebElement favoriteTab;

    public void clickFavoriteTab(){
        favoriteTab.click();
    }

    public boolean checkIsSameFileInFavoriteList(){

        List<String > fileNameList = new ArrayList<>();
        for (WebElement each : fileList) {
            String fileNameInFavorite = each.getText();
            fileNameList.add(fileNameInFavorite);
        }
        String deleteFileName = delectedElement.getText();
        return fileNameList.contains(deleteFileName);


    }

    @FindBy(xpath = "(//a[@data-action='menu'])")
    public WebElement actionButton;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> allFilesUploaded;


    public void clickSpecificActionBtnAndGetAllText(int specific, String specificActionWithFile){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);

        WebElement action2 = Driver.getDriver().findElement(By.xpath("(//a[@data-action='menu'])["+specific+"]"));
        action2.click();

        Driver.getDriver().findElement(By.xpath("//span[.='"+specificActionWithFile+"']")).click();

    }



   @FindBy(xpath = "//a[.='Deleted files']")
   public WebElement deleteFiles;

   @FindBy(xpath = "(//span[@class='nametext extra-data'])[1]")
   public WebElement lastDeletedFile;


    @FindBy(xpath = "//span[.='Delete file']")
    public WebElement deleteFileUnderAction;


}
