package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Us07StepDef {

    FilesPage filesPage = new FilesPage();
    WebElement deletedFileName;

    int random;
    //String expectedFileName;

    // String deletedFileName;


    @When("Choose “delete files” option")
    public void choose_delete_files_option() {

        BrowserUtil.waitFor(2);

       // System.out.println(BrowserUtil.getAllText(filesPage.allFilesUploaded));
       // random = filesPage.randomNumber(1,filesPage.allFilesUploaded.size());
       // expectedFileName = Driver.getDriver().findElement(By.xpath("(//span[@class='nametext'])["+random+"]/span[1]")).getText();
        BrowserUtil.waitFor(3);
      //  WebElement test = Driver.getDriver().findElement(By.xpath("(//span[@class='icon icon-more'])["+random+"]"));
       // test.click();
       // String deletedFileName = filesPage.getFileName(3);
        //String deletedFileName = filesPage.clickSpecificActionBtnAndGetAllText(3,"Delete file");




     WebElement deletedFileName = filesPage.test(filesPage.randomChosenFile());

    }

    @Then("Click deleted files on the left bottom corner")
    public void click_deleted_files_on_the_left_bottom_corner() {

        filesPage.deleteFiles.click();
        BrowserUtil.waitFor(2);



    }

    @Then("Verify the deleted file is displayed no the page.")
    public void verify_the_deleted_file_is_displayed_no_the_page() {
      //  List<String> allFilesUploadedName = BrowserUtil.getAllText(filesPage.allFilesUploaded);

        //String lastDeletedFileName = filesPage.lastDeletedFile.getText();
        BrowserUtil.waitFor(2);

       Assert.assertTrue(deletedFileName.isDisplayed());


        //Assert.assertTrue(allFilesUploadedName.contains(lastDeletedFileName));


    }

}
