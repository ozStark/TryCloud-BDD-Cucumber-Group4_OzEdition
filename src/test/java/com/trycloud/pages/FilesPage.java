package com.trycloud.pages;

import com.github.javafaker.Faker;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class FilesPage {
    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

   // public String deletedFileName;

    @FindBy(xpath = "//span[normalize-space(.)='Files']/..")
    public WebElement filesBtn;

    public void clickFilesBtn() {
        filesBtn.click();
        BrowserUtil.waitFor(3);
    }

    @FindBy(xpath = "//tr[@data-file='Talk']//span[.='Actions']/..")  // need change to dynamic according to file's name
    public WebElement actionIcon;

    public boolean isFavoriteFile(String fileName) {
        boolean result = true;
        try {
            String sXpath = "//tr[@data-file='" + fileName + "']//span[.='Favorited']";
            Driver.getDriver().findElement(By.xpath(sXpath)).getText().equals("Favorited");
        } catch (Exception e) {
            result = false;
            System.out.println("Attention: No Favorite files in the list, please add favorite file first.");
            throw e;
        }
        return result;
    }


    @FindBy(xpath = "//li[@class='action-0']")
    public WebElement addToFavorite;

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
    public List<WebElement> fileList;

    public void refreshCurrentPage() {
        filesBtn.sendKeys(Keys.F5);

    }

    @FindBy(xpath = "//div[@id='app-content-favorites']//tbody[@id='fileList']/tr")
    List<WebElement> allFavoriteFilesList;


    @FindBy(xpath = "//span[.='Upload file']")
    public WebElement uploadFile;

    public void selectFromCreateFolderBtn(String options) {
        Driver.getDriver().findElement(By.xpath("//span[.='" + options + "']")).click();
    }

    public List<String> allFilesList1() {
        List<String> list = new ArrayList<>();
        for (WebElement each : fileList) {
            list.add(each.getAttribute("data-file"));
        }
        return list;
    }

    public static String removedFileName;

    public void clickRemoveFromFavorite(){//issue method, need modify
        for (WebElement eachFile : fileList) {
            BrowserUtil.waitFor(3);
            removedFileName = eachFile.getAttribute("data-file");
            if (isFavoriteFile(removedFileName)){
                String fileNameXpath="//tr[@data-file='"+removedFileName+"']//span[.='Actions']/..";
                Driver.getDriver().findElement(By.xpath(fileNameXpath)).click();
                removeFromFavorite.click();
                System.out.println("Removed file name: "+removedFileName);
                break;
            }
        }

    }



    @FindBy(xpath = "//a[.='Favorites']")
    WebElement favoriteTab;

    //BELOW ARE FOR FOLDER'S FILES
    /**
     * Action button
     */
    @FindBy(xpath = "//a[@data-action='menu']")
    public List<WebElement> actionButtonList;

    /**
     * Click any random file's action button
     */
    public void clickRandomActionBtn() {
        Faker faker = new Faker();
        actionButtonList.get(faker.number().numberBetween(0, fileList.size() - 1)).click();
    }

    /**
     * Plus button to upload file/folder/new_text_document
     */
    @FindBy(xpath = "//div[@id='controls']/div[2]/a")
    public WebElement addNewPlusButton;

    /**
     * New text document under Plus Button menu
     */
    @FindBy(xpath = "//span[.='New text document']")
    public WebElement newTextDocument;


    @FindBy(id = "view13-input-file")
    public WebElement newTextDocFileNameBox;

    /**
     * uploading a file
     */
    public void createNewTextDocument(String fileName) {
        addNewPlusButton.click();
        newTextDocument.click();
        newTextDocFileNameBox.sendKeys(fileName + Keys.ENTER);
        BrowserUtil.waitFor(2);
        Driver.getDriver().findElement(By.xpath("//div[@class='icons-menu']")).click();
    }

    /**
     * File's action menu items
     */
    @FindBy(xpath = "//a[@data-action='Favorite']")
    public WebElement addToFavoriteAction;
    @FindBy(xpath = "//a[@data-action='Favorite']")
    public WebElement removeFromFavoriteAction;
    @FindBy(xpath = "//a[@data-action='Details']")
    public WebElement detailsAction;
    @FindBy(xpath = "//a[@data-action='Rename']")
    public WebElement renameAction;
    @FindBy(xpath = "//a[@data-action='MoveCopy']")
    public WebElement moveOrCopyAction;
    @FindBy(xpath = "//a[@data-action='Download']")
    public WebElement downloadAction;
    @FindBy(xpath = "//a[@data-action='Delete']")
    public WebElement deleteAction;

    /**
     * Selecting file action from the dropdown menu
     *
     * @param action
     */
    public void selectFileAction(String action) {
        switch (action) {
            case "Add to favorites":
                addToFavoriteAction.click();
                break;
            case "Details":
                detailsAction.click();
                break;
            case "Rename":
                renameAction.click();
                break;
            case "Move or copy":
                moveOrCopyAction.click();
                break;
            case "Download":
                downloadAction.click();
                break;
            case "Delete file":
                deleteAction.click();
                break;
            case "Remove from favorites":
                removeFromFavoriteAction.click();
                break;
        }
    }

    /**
     * File's details window modules
     */
    @FindBy(id = "activityTabView")
    public WebElement fileActivityModule;
    @FindBy(id = "chat")
    public WebElement fileChatModule;
    @FindBy(id = "commentsTabView")
    public WebElement fileCommentsModule;
    @FindBy(id = "sharing")
    public WebElement fileSharingModule;
    @FindBy(id = "versionsTabView")
    public WebElement fileVersionsModule;

    /**
     * Selecting file's details' module
     *
     * @param detailsModule
     */
    public void selectFileDetailsModule(String detailsModule) {
        switch (detailsModule) {
            case "Activity":
                fileActivityModule.click();
                break;
            case "Chat":
                fileChatModule.click();
                break;
            case "Comments":
                fileCommentsModule.click();
                break;
            case "Sharing":
                fileSharingModule.click();
                break;
            case "Versions":
                fileVersionsModule.click();
                break;
        }
    }

    public void clickFavoriteTab(){
        BrowserUtil.waitFor(3);
        favoriteTab.click();
    }

    public boolean checkIsSameFileInFavoriteList(){
        favoriteList();
        BrowserUtil.waitFor(1);
        System.out.println("Favorite list: "+favoriteList());
        return favoriteList().contains(removedFileName);
    }

    public List<String> favoriteList(){
         List<String> favoriteFileNameList = new ArrayList<>();
        for (WebElement each : allFavoriteFilesList) {
            favoriteFileNameList.add( each.getAttribute("data-file"));
        }
        return favoriteFileNameList;
    }

    @FindBy(xpath = "//*[@id=\"controls\"]/div[2]/a")
    public WebElement plusIcon;

    @FindBy(css = "#file_upload_start")
    public WebElement hiddenFileUpload;



    @FindBy(xpath = "(//a[@data-action='menu'])")
    public WebElement actionButton;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> allFilesUploaded;


    //click random nr from 1 to list of files.size  and after click delete
    public String clickSpecificActionBtnAndGetAllText(int specific, String specificActionWithFile) {


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

        WebElement action2 = Driver.getDriver().findElement(By.xpath("(//a[@data-action='menu'])[" + specific + "]"));
        action2.click();
        String deletedFileName = action2.getText();

        Driver.getDriver().findElement(By.xpath("//span[.='" + specificActionWithFile + "']")).click();

        return deletedFileName;
    }
    /**
     * Posting comment in the comment box
     */
    public void enterCommentInCommentBox(String comment) {
        Driver.getDriver().findElement(By.xpath("//form[@class='newCommentForm']/div")).sendKeys(comment);
    }

    /**
     * clicking submit button to send comment
     */
    public void submitCommentUnderFileDetails() {
        Driver.getDriver().findElement(By.xpath("//form[@class='newCommentForm']/div")).click();
    }

    /**
     * Verify entered comment is displayed
     */
    public boolean submitedCommentIsDisplayed(String comment) {
        boolean isDisplayed = false;
        if (Driver.getDriver().findElement(By.xpath("//div[.='" + comment + "']")).getText().equals(comment)) {
            isDisplayed = true;
        }
        return isDisplayed;
    }

   @FindBy(xpath = "//a[.='Deleted files']")
   public WebElement deleteFiles;

   @FindBy(xpath = "(//span[@class='nametext extra-data'])[1]")
   public WebElement lastDeletedFile;


    @FindBy(xpath = "(//span[contains(.,'Delete f')])[2]")
    public WebElement deleteFunderAction;

    @FindBy(xpath = "//span[.='Deleted']")
    public WebElement deletedBtn;


    public int randomNumber(int a, int b) {
        return new Faker().number().numberBetween(a, b);
    }

    public int randomChosenFile(){
        return new Faker().number().numberBetween(1,allFilesUploaded.size());
    }

    public WebElement test(int a){

        WebElement dynamicFileName = Driver.getDriver().findElement(By.xpath("(//span[@class='nametext'])["+a+"]/span[1]"));
      // String dynamicFileName = Driver.getDriver().findElement(By.xpath("(//span[@class='nametext'])["+a+"]/span[1]")).getText();
      WebElement dynamicActionBtn = Driver.getDriver().findElement(By.xpath("(//a[@data-action='menu'])["+a+"]"));
      BrowserUtil.waitFor(1);
      dynamicActionBtn.click();
      //WebElement deletedFileName = dynamicActionBtn;
     // String deletedFileName = dynamicActionBtn.getText();
      BrowserUtil.waitFor(1);
      Driver.getDriver().findElement(By.xpath("(//span[@class='icon icon-delete'])[2]")).click();

      return dynamicFileName;
    }

    @FindBy(xpath = "(//tbody[@id='fileList'])[12]//tr//span[@class='nametext extra-data']/span[@class='innernametext']")
    public List<WebElement> deletedFileNames;

    @FindBy(xpath = "//a[@class='action action-menu permanent']")
    public List<WebElement> allActionsInFiles;


    public String chooseRandomFileInFilesPage() {


        int number = allActionsInFiles.size();
        String expectedFileName = Driver.getDriver().findElement(By.xpath("(//span[@class='nametext'])["+number+"]/span")).getText();
        System.out.println(expectedFileName);
        allActionsInFiles.get(number-1).click();


        return expectedFileName;

    }


    public void chooseAction(String action) {


        BrowserUtil.waitFor(2);
        Driver.getDriver().findElement(By.xpath("//li//span[contains(normalize-space(.),'"+action+"')]")).click();
    }

    public void chooseSubModule(String deleteBtn) {
        BrowserUtil.waitFor(2);
        Driver.getDriver().findElement(By.xpath("//ul[@class='with-icon']//a[normalize-space(.)='"+deleteBtn+"']")).click();
    }



    //span[text()='Add to favorites']

}
