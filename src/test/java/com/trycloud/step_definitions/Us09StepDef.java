package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.github.javafaker.File;
import com.trycloud.pages.CommonPOM;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class Us09StepDef {

    FilesPage filesPage = new FilesPage();

    @When("user clicks any file on the File page")
    public void user_clicks_any_file_on_the_page() {
        CommonPOM commonPOM = new CommonPOM();
        commonPOM.clickModule("Files");
        BrowserUtil.waitFor(2);
    }

    @When("clicks action icon")
    public void clicks_action_icon() {
        filesPage.clickRandomActionBtn();
        BrowserUtil.waitFor(1);
    }

    @When("clicks {string} from the action dropdown")
    public void clicks_from_the_action_dropdown(String actionItem) {
        filesPage.selectFileAction(actionItem);
        BrowserUtil.waitFor(2);
    }

    @When("clicks {string} from the details menu")
    public void clicks_from_the_details_menu(String detailsModule) {
        filesPage.selectFileDetailsModule(detailsModule);
        BrowserUtil.waitFor(2);
    }

    @When("enters {string} in the box")
    public void enters_in_the_box(String comment) {
        filesPage.enterCommentInCommentBox(comment);
    }

    @When("clicks submit button")
    public void clicks_submit_button() {
        filesPage.submitCommentUnderFileDetails();
    }

    @Then("verify the message {string} is displayed")
    public void verify_the_message_is_displayed(String comment) {
        assertTrue(filesPage.submitedCommentIsDisplayed(comment));
    }


}
