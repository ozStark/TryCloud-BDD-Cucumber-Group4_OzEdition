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
        wait.until(ExpectedConditions.elementToBeClickable(filesPage.createNewFolderBtn));
        filesPage.createNewFolderBtn.click();
    }

    @When("Click “New Folder”")
    public void click_new_folder() {
        BrowserUtil.waitFor(2);

        filesPage.selectFromCreateFolderBtn("New folder");
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
        Assert.assertTrue(filesPage.youCreatedNewFolderConfirmMsg.isDisplayed());
    }


    @And("Click “upload file”")
    public void clickUploadFile() {
        BrowserUtil.waitFor(1);
        //filesPage.selectFromCreateFolderBtn("Upload file");
        //filesPage.uploadFile.click();
       WebElement upl = Driver.getDriver().findElement(By.xpath("//label[@data-action='upload']"));
        upl.click();
        BrowserUtil.waitFor(1);
        upl.sendKeys("/Users/cristinatiscenco/datamodeler.log");

    }

    @Then("Upload a file")
    public void uploadAFile() {

        BrowserUtil.waitFor(2);


        //filesPage.uploadFile.sendKeys("/Users/cristinatiscenco/Downloads/All Cucumber.pages");
       // Actions actions = new Actions(Driver.getDriver());
       // String filePath = "/Users/cristinatiscenco/datamodeler.log";
       // actions.sendKeys(filesPage.uploadFile, filePath).doubleClick();
        //filesPage.uploadFile.sendKeys(filePath);
        //filesPage.uploadFile.click();
        //WebElement choseFile = Driver.getDriver().findElement(By.id("file-upload"));
        //choseFile.sendKeys("/Users/cristinatiscenco/datamodeler.log", Keys.ENTER);


    }

    @Then("Verify the file is displayed on the page")
    public void verifyTheFileIsDisplayedOnThePage() {



    }
}
