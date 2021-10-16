package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPagePOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Us05StepDef {

    @Given("Login as a user")
    public void login_as_a_user() {
    new LoginPagePOM().login();
    }
    @When("Click action-icon from any file on the page")
    public void click_action_icon_from_any_file_on_the_page() {

    }
    @When("Click “Remove from Favorites” option")
    public void click_remove_from_favorites_option() {

    }
    @Then("Verify that the file is removed from Favorites sub-module’s table.")
    public void verify_that_the_file_is_removed_from_favorites_sub_module_s_table() {

    }

    @When("Click the “+” icon on top")
    public void click_the_icon_on_top() {

    }
    @When("Click “upload file”")
    public void click_upload_file() {

    }
    @When("Upload a file")
    public void upload_a_file() {

    }
    @Then("Verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {

    }

}
