package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Us07StepDef {

    FilesPage filesPage = new FilesPage();
    String expectedName;

    @When("user click action-icon from any file on the page")
    public void user_click_action_icon_from_any_file_on_the_page() {
        filesPage.filesBtn.click();
        expectedName = filesPage.chooseRandomFileInFilesPage();

    }

    @When("And user choose {string} option")
    public void and_user_choose_option(String action) {

        BrowserUtil.waitFor(3);
        filesPage.chooseAction(action);
       // filesPage.deleteFunderAction.click();
    }


    @Then("Click {string} on the left bottom corner")
    public void click_on_the_left_bottom_corner(String deleteBtn) {
        BrowserUtil.waitFor(2);
         filesPage.chooseSubModule(deleteBtn);
        //filesPage.deletedBtn.click();

    }

    @Then("Verify the deleted file is displayed no the page.")
    public void verify_the_deleted_file_is_displayed_no_the_page() {
        BrowserUtil.waitFor(4);
        List<String> listNames = BrowserUtil.getElementsText2(filesPage.deletedFileNames);
        System.out.println("listNames = " + listNames);
        System.out.println("expectedName = " + expectedName);
        BrowserUtil.waitFor(4);
        Assert.assertTrue(listNames.contains(expectedName));

    }





}
