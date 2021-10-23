package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.FilesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class US04StepDef1 {

    FilesPage obj1 = new FilesPage();

    @When("User click Action icon button on datamodeler file")
    public void userClickActionIconButton(){
    obj1.clickRandomActionBtn();

    }

        @And("user click Add to Favorites")
         public void userClickAddToFavorites(){
        obj1.addToFavorite.click();
        }


        @Then("file added to Favorites")
        public boolean fileAddedToFavorites(String filename){

        return  obj1.isFavoriteFile(filename);

        }
}
