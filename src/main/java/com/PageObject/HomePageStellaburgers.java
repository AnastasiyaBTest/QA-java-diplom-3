package com.PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageStellaburgers {


    @FindBy(how = How.LINK_TEXT, using = "Конструктор")
    private SelenideElement linkToTheConstructor;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__link__3D_hX")
    private SelenideElement linkToTheOrderFeed;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    @FindBy(how = How.XPATH, using = ".//a[@class='AppHeader_header__link__3D_hX']/p[contains(text(),'Личный Кабинет')]")
    private SelenideElement linkToThePersonalAccount;

//.//section[1]/div[1]/div[1]
    @FindBy(how = How.XPATH,using = ".//section[1]//span[contains(text(),'Булки')]")
    private SelenideElement bunButton;

    @FindBy(how = How.XPATH,using = ".//section[1]/div[2]/ul[1]/a[1]")
    private SelenideElement firstTabBunSection;

    @FindBy(how = How.XPATH,using = ".//div/section[1]/div[1]")
    private SelenideElement informationAboutBun;


    @FindBy(how = How.XPATH,using = ".//section[1]/div[1]/div[2]")
    private SelenideElement sauceButton;

    @FindBy(how = How.XPATH,using = ".//section[1]/div[2]/ul[2]/a[1]")
    private SelenideElement firstTabSauceSection;

    @FindBy(how = How.XPATH,using = ".//div/section[1]/div[1]")
    private SelenideElement informationAboutSauce;

    @FindBy(how = How.XPATH,using = ".//section[1]/div[1]/div[3]")
    private SelenideElement ingredientsButton;

    @FindBy(how = How.XPATH,using = ".//section[1]/div[2]/ul[3]/a[1]")
    private SelenideElement firstTabIngredientsSection;

    @FindBy(how = How.XPATH,using = ".//div/section[1]/div[1]")
    private SelenideElement informationAboutIngredient;


    @FindBy(how = How.XPATH,using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement logInButton;


    public void clickLinkToThePersonalAccount() {
        linkToThePersonalAccount.click();
    }

    public void clickLoginButton() {
        logInButton.click();
    }

    public void clickBunButton() {
        bunButton.click();
    }
    public void clickFirstTabBunSection() {
        firstTabBunSection.click();
    }

    public void clickSauceButton() {
        sauceButton.click();
    }
    public void clickFirstTabSauceSection() {
        firstTabSauceSection.click();
    }

    public void clickIngredientsButton() {
        ingredientsButton.click();
    }
    public void clickFirstTabIngredientsSection() {
        firstTabIngredientsSection.click();
    }


    public boolean haslinkToThePersonalAccount() {
       return linkToThePersonalAccount.isDisplayed();
    }
    public boolean hasInformationAboutBun() {
        return informationAboutBun.isDisplayed();
    }

    public boolean hasInformationAboutSauce() {
        return informationAboutSauce.isDisplayed();
    }

    public boolean hasInformationAboutIngredient() {
        return informationAboutIngredient.isDisplayed();
    }
}
