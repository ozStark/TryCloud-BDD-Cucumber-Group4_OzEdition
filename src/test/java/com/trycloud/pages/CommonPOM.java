package com.trycloud.pages;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CommonPOM {

    @FindBy(xpath = "//div[@class='avatardiv avatardiv-shown']")
    private WebElement logoutDrop;

    @FindBy(xpath = "//li[@ data-id='logout']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//li[@data-id='dashboard']/a")
    private WebElement dashBoardBtn;

    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement textDashBoardBtn;

    @FindBy(xpath = "//li[@data-id='files']/a")
    private WebElement filesBtn;

    @FindBy(xpath = "//span[text()='Files']")
    private WebElement textFilesBtn;

    @FindBy(xpath = "//li[@data-id='photos']/a")
    private WebElement photosBtn;

    @FindBy(xpath = "//span[text()='Photos']")
    private WebElement textPhotosBtn;

    @FindBy(xpath = "//li[@data-id='activity']/a")
    private WebElement activityBtn;

    @FindBy(xpath = "//span[text()='Activity']")
    private WebElement textActivityBtn;

    @FindBy(xpath = "//li[@data-id='spreed']/a")
    private WebElement talkBtn;

    @FindBy(xpath = "//span[text()='Talk']")
    private WebElement textTalkBtn;

    @FindBy(xpath = "//li[@data-id='contacts']/a")
    private WebElement contactsBtn;

    @FindBy(xpath = "//span[text()='Contacts']")
    private WebElement textContactBtn;

    @FindBy(xpath = "//li[@data-id='calendar']/a")
    private WebElement calendarBtn;

    @FindBy(xpath = "//span[text()='Calendar']")
    private WebElement textCalendarBtn;

    @FindBy(xpath = "//li[@data-id='deck']/a")
    private WebElement deckBtn;

    @FindBy(xpath = "//span[text()='Calendar']")
    private WebElement textDeckBtn;


    public CommonPOM() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void logOut() {
        this.logoutDrop.click();
        BrowserUtil.waitForVisibility(By.xpath("//li[@ data-id='logout']"), 3);
        this.logoutBtn.click();//
    }

    public List<String> iterableModuleList(){
        Actions action = new Actions(Driver.getDriver());
        List<String> list = new ArrayList<>();
        //String str1 = this.textDashBoardBtn.getText();

        action.moveToElement(this.dashBoardBtn).perform();
        list.add(this.textDashBoardBtn.getText());

        action.moveToElement(this.filesBtn).perform();
        list.add(this.textFilesBtn.getText());

        action.moveToElement(this.photosBtn).perform();
        list.add(this.textPhotosBtn.getText());

        action.moveToElement(this.activityBtn).perform();
        list.add(this.textActivityBtn.getText());

        action.moveToElement(this.talkBtn).perform();
        list.add(this.textTalkBtn.getText());

        action.moveToElement(this.contactsBtn).perform();
        list.add(this.textContactBtn.getText());

        action.moveToElement(this.calendarBtn).perform();
        list.add(this.textCalendarBtn.getText());

        action.moveToElement(this.deckBtn).perform();
        list.add(this.textDeckBtn.getText());

        return list;

    }

    public boolean allModulesDisplayed(){
        BrowserUtil.waitForVisibility(By.xpath("//li[@data-id='dashboard']/a"),5);
        boolean result = false;
        if(this.dashBoardBtn.isDisplayed()&&
        this.filesBtn.isDisplayed()&&
        this.photosBtn.isDisplayed()&&
        this.activityBtn.isDisplayed()&&
        this.talkBtn.isDisplayed()&&
        this.contactsBtn.isDisplayed()&&
        this.contactsBtn.isDisplayed()&&
        this.deckBtn.isDisplayed()){
            result = true;
        }else {
            result = false;
        }
return result;
    }
}
