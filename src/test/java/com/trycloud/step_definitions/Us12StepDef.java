package com.trycloud.step_definitions;

import com.trycloud.pages.ContactModulePage;
import com.trycloud.pages.LoginPagePOM;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Us12StepDef {

    LoginPagePOM login = new LoginPagePOM();
    ContactModulePage button = new ContactModulePage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        login.goTo();

    }
    @Given("user provides valid {string} and {string}")
    public void user_provides_valid_credentials(String username, String password) {
        login.fillCredentials(username,password);
        login.clickLogin();

    }
    @When("user clicks on Contacts module")
    public void user_clicks_on_contacts_module() {
        button.contactButton();

    }
    @Then("user verifies the page title is Contents module's title")
    public void user_verifies_the_page_title_is_contents_module_s_title() {

        String pageTitle = Driver.getDriver().getTitle();
        String moduleTitle = button.contactButtonText();

        Assert.assertTrue(pageTitle.contains(moduleTitle));

    }


    @And("user clicks on New Contact button")
    public void userClicksOnNewContactButton() {
        BrowserUtil.waitFor(3);
        button.clickOnNewContactButton();
    }

    @When("user fills out the contact info like: Title, Phone, email, address, etc")
    public void user_fills_out_the_contact_info_like_title_phone_email_address_etc() {
        button.contactInfo();

    }
    @Then("user verifies the contact name is added to the contact list")
    public void user_verifies_the_contact_name_is_added_to_the_contact_list() {
        String actualResult = button.companyNameText();
        String expectedResult = "A\nAmazon.inc\namazon@online.com";

        Assert.assertEquals(actualResult,expectedResult);

    }
}
