package com.trycloud.step_definitions;

import com.sun.xml.internal.ws.policy.AssertionSet;
import com.trycloud.pages.CommonPOM;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;

import static org.junit.Assert.*;

public class Us03StepDef {
    @Then("User click Files module")
    public void userClickFilesModule() {
        new CommonPOM().clickFilesBtn();
    }

    @Then("Verify the page title is {string}")
    public void verifyThePageTitleIs(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

}
