package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.runner.manipulation.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sql.rowset.BaseRowSet;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import static org.junit.Assert.assertTrue;


public class Us06StepDef {

    FilesPage filesPage = new FilesPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);


    @When("Choose a folder from the page")
    public void chooseAFolderFromThePage() {

        wait.until(ExpectedConditions.elementToBeClickable(filesPage.filesBtn));
        filesPage.clickFilesBtn();

    }

    @When("Click the “+” icon on top")
    public void click_the_icon_on_top() {
        //wait.until(ExpectedConditions.elementToBeClickable(filesPage.createNewFolderBtn));
        //filesPage.createNewFolderBtn.click();
        BrowserUtil.waitFor(1);
        filesPage.clickFilesBtn();
        BrowserUtil.waitFor(3);
        filesPage.plusIcon.click();
        BrowserUtil.waitFor(1);
    }

    @Then("Write a folder name")
    public void write_a_folder_name() {
        BrowserUtil.waitFor(1);
        Faker faker = new Faker();
        filesPage.newFolderInputNameBox.sendKeys(faker.name().username());
    }

    @Then("Click submit icon")
    public void click_submit_icon() {
        filesPage.newFolderInputNameSubmitBtn.click();

    }

    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        BrowserUtil.waitFor(2);
        assertTrue(filesPage.youCreatedNewFolderConfirmMsg.isDisplayed());
    }


    @And("Click “upload file”")
    public void clickUploadFile() {

    }

    String addFileName;
    @Then("Upload a file")
    public void uploadFileViaRobot() throws AWTException {
        String filePath="/Users/wangyuliang/Downloads/bug/5.png";

        addFileName=filePath.substring(filePath.lastIndexOf("/")+1);
        System.out.println("addedFileName1:"+addFileName);

        filesPage.hiddenFileUpload.sendKeys(filePath);

    }

    @Then("Verify the file is displayed on the page")
    public void verifyTheFileIsDisplayedOnThePage() {
        BrowserUtil.waitFor(2);
        filesPage.refreshCurrentPage();
        BrowserUtil.waitFor(2);
        System.out.println("addedFileName2 :"+addFileName);
        System.out.println("filesListOnThePage :"+filesPage.allFilesList1());
        assertTrue( filesPage.allFilesList1().contains(addFileName));
    }
}
