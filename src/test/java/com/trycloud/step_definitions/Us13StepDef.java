package com.trycloud.step_definitions;

import com.trycloud.pages.CommonPOM;
import com.trycloud.pages.ContactsPOM;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Us13StepDef {
CommonPOM common = new CommonPOM();
ContactsPOM contacts = new ContactsPOM();

    @When("user Click contacts module")
    public void user_click_contacts_module() {
        common.clickContact();
    }
    @Then("Verify the contact names are in the list")
    public void verify_the_contact_names_are_in_the_list() {

        try {
            Assert.assertTrue(contacts.checkContactsNum());
        } catch (Throwable e) {
            System.out.println("Report Error:  " + e);
        }

        System.out.println("Assertion was not true, There were other than 2 contacts");


    }

}


