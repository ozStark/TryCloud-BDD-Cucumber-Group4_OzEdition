package com.trycloud.step_definitions;

import com.trycloud.pages.CommonPOM;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class Us02StepDef {
CommonPOM common = new CommonPOM();

    @Then("Verify the user sees the following modules")
    public void verifyTheUserSeesTheFollowing(List<String> modules) {


        //for (int i = 0; i < modules.size(); i++) {
            Assert.assertEquals(modules,common.iterableModuleList());
        //}

        //BrowserUtil.waitFor(3);
        //Assert.assertTrue(common.allModulesDisplayed());
    }


}
