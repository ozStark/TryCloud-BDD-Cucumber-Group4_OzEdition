package com.trycloud.step_definitions;

import com.trycloud.pages.CommonPOM;
import com.trycloud.pages.FilesPage;
import com.trycloud.pages.LoginPagePOM;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

public class Us05StepDef {
    FilesPage filesPage = new FilesPage();
    CommonPOM commonPOM= new CommonPOM();

    @Given("Login as a user")
    public void login_as_a_user() {
        new LoginPagePOM().login();
    }

    @When("Click action-icon from any file on the page")
    public void click_action_icon_from_any_file_on_the_page() {
        commonPOM.clickModule("Files");
        BrowserUtil.waitForVisibility(By.xpath("//tbody[@id='fileList']/tr"),1);
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


    @When("Click the “plus+” icon on top")
    public void clickThePlusIconOnTop() {
        commonPOM.clickModule("Files");
    }
}
