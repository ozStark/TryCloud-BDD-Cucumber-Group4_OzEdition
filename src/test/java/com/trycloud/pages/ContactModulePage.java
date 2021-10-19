package com.trycloud.pages;

import com.github.javafaker.Faker;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactModulePage {

    @FindBy(xpath = "//ul[@id='appmenu']//a[@aria-label='Contacts']")
    public WebElement contactButton;

    @FindBy(xpath = "//div[@class='vue-recycle-scroller__item-view']")
    private WebElement companyName;

    @FindBy(id = "contact-org")
    private WebElement companyNameField;

    @FindBy(id = "new-contact-button")
    private WebElement newContactButton;

    @FindBy(id = "contact-title")
    private WebElement title;

    @FindBy(xpath = "//input[@inputmode='tel']")
    private WebElement phone;

    @FindBy(xpath = "//input[@inputmode='email']")
    private WebElement email;

    @FindBy(css = "div:nth-of-type(2) > .property__value")
    private WebElement postBox;

    @FindBy(css = "div:nth-of-type(3) > .property__value")
    private WebElement address;

    @FindBy(css = "div:nth-of-type(5) > .property__value")
    private WebElement postalCode;

    @FindBy(css = "div:nth-of-type(6) > .property__value")
    private WebElement city;

    @FindBy(css = "div:nth-of-type(7) > .property__value")
    private WebElement state;

    @FindBy(css = "div:nth-of-type(8) > .property__value")
    private WebElement country;

    public ContactModulePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void contactButton (){
        contactButton.click();
    }

    public String contactButtonText(){
        return contactButton.getText();
    }

    public void clickOnNewContactButton(){
        newContactButton.click();
    }

    public String companyNameText(){

        return companyName.getText();
    }

    public void contactInfo(){

        companyNameField.sendKeys("Apple Inc");

        Faker faker = new Faker();

        title.sendKeys(faker.company().name());
        BrowserUtil.waitFor(1);
        phone.sendKeys(faker.phoneNumber().cellPhone());
        BrowserUtil.waitFor(1);
        email.sendKeys("apple@online.com");
        BrowserUtil.waitFor(1);
        postBox.sendKeys(faker.address().zipCode());
        BrowserUtil.waitFor(1);
        postalCode.sendKeys(faker.address().zipCode());
        BrowserUtil.waitFor(1);
        address.sendKeys(faker.address().streetAddress());
        BrowserUtil.waitFor(1);
        postalCode.sendKeys(faker.address().zipCode());
        BrowserUtil.waitFor(1);
        city.sendKeys(faker.address().city());
        BrowserUtil.waitFor(1);
        state.sendKeys(faker.address().state());
        BrowserUtil.waitFor(1);
        country.sendKeys(faker.country().name());

    }

}
