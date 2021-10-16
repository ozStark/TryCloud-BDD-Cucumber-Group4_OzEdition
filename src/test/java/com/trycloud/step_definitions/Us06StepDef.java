package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.FilesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.runner.manipulation.Ordering;

public class Us06StepDef {

    FilesPage filesPage = new FilesPage();

    @When("Click the “+” icon on top")
    public void click_the_icon_on_top() {
       filesPage.createNewFolderBtn.click();
    }

    @When("Click “New Folder”")
    public void click_new_folder() {
     // new FilesPage().createNewFolderBtn.click();
        filesPage.newFolder.click();
    }


    @Then("Write a folder name")
    public void write_a_folder_name() {
        Faker faker = new Faker();
        filesPage.newFolderInputNameBox.sendKeys(faker.name().username());
    }
    @Then("Click submit icon")
    public void click_submit_icon() {
        filesPage.newFolderInputNameSubmitBtn.click();

    }
    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {

        Assert.assertTrue(filesPage.newFolderCreatedImg.isDisplayed());
    }


}
