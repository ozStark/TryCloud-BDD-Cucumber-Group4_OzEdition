package com.trycloud.step_definitions;

import com.trycloud.pages.CommonPOM;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Locale;

public class Us02StepDef {
CommonPOM common = new CommonPOM();

    @Then("Verify the user sees the following modules")
    public void verifyTheUserSeesTheFollowing(List<String> modules) {
        boolean result = false;

        for (int i = 0; i < modules.size(); i++) {
            if(common.iterableModuleList().get(i).contains(modules.get(i).toLowerCase())){
                //System.out.println("PASS");
                result = true;
            }else {
                //System.out.println("FAIL");
                result = false;
            }

            Assert.assertTrue(result);

            //System.out.println(modules.get(i).toLowerCase());
            //System.out.println(common.iterableModuleList().get(i));
            //System.out.println("___");
        }
    }
}
