package com.trycloud.step_definitions;

import com.trycloud.pages.CommonPOM;
import com.trycloud.pages.LoginPagePOM;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Us01StepDef {

    LoginPagePOM loginPage = new LoginPagePOM();
    CommonPOM common = new CommonPOM();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
    loginPage.goTo();
    }

    @When("user enter valid {string} and {string}")
    public void userEnterValidAnd(String username, String password) {
        loginPage.fillCredentials(username,password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLogin();
    }

    @Then("Verify user launched to the dashboard")
    public void verifyUserLaunchedToTheDashboard() {
    loginPage.isAtLoginPage();
    }

    @Then("TEST user logs out")
    public void testUserLogsOut() {
        common.logOut();
        //BrowserUtil.waitFor(4);

    }


    @When("user enter invalid credentials")
    public void userEnterInvalidCredentials() {
        loginPage.fillCredentials("wronguser","wrongpassword");
    }



    @Then("“Wrong username or password.” message should be displayed")
    public void wrongUsernameOrPasswordMessageShouldBeDisplayed() {
        BrowserUtil.waitFor(2);
        loginPage.wrongPassErrorMsgIsDisplayed();
    }


}
