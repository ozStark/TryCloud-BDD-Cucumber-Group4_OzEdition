package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.pages.LoginPagePOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class Us05StepDef {
    FilesPage filesPage = new FilesPage();

    @Given("Login as a user")
    public void login_as_a_user() {
        new LoginPagePOM().login();
    }

    @When("Click action-icon from any file on the page")
    public void click_action_icon_from_any_file_on_the_page() {
        filesPage.clickFilesBtn();
    }

    @When("Click “Remove from Favorites” option")
    public void click_remove_from_favorites_option() {
        filesPage.clickRemoveFromFavorite();
    }

    @Then("Verify that the file is removed from Favorites sub-module’s table.")
    public void verify_that_the_file_is_removed_from_favorites_sub_module_s_table() {
    filesPage.clickFavoriteTab();
            assertFalse(filesPage.checkIsSameFileInFavoriteList());
    }






}
