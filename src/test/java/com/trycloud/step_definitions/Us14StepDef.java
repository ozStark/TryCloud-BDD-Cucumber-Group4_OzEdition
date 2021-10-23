package com.trycloud.step_definitions;

import com.trycloud.pages.CommonPOM;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Us14StepDef {
String search = "Talk";
    @When("Search any existing file folder user name")
    public void search_any_existing_file_folder_user_name() {
    new CommonPOM().searchIcon.click();
    BrowserUtil.waitFor(1);

    new CommonPOM().searchBox.sendKeys(search);


    }
    @Then("Verify the app displays the expected result option")
    public void verify_the_app_displays_the_expected_result_option() {
        Assert.assertEquals(search,new CommonPOM().searchResult.getText());
    }
}
