package com.PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    //локатор поля комментарий .//label[@class='input__placeholder text noselect text_type_main-default'][contains(text(),'Имя')]
    @FindBy(how = How.XPATH, using = ".//fieldset[1]//input")
    private SelenideElement nameField;

    //локатор поля комментарий
    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input")
    private SelenideElement emailField;

    //локатор поля комментарий
    @FindBy(how = How.XPATH, using = ".//fieldset[3]//input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH,using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement signUpButton;

    @FindBy(how = How.XPATH,using = ".//a[@class='Auth_link__1fOlj']")
    private SelenideElement signInButton;


    @FindBy(how = How.XPATH, using = ".//fieldset[3]/div/p")
    private SelenideElement errorMessage;

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void setEmailField(String email) {
      //  emailField.click();
        emailField.setValue(email);
    }
    public void setNameField(String name) {
       // nameField.click();
        nameField.setValue(name);
    }
    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    public boolean hasErrorMessage() {
        return errorMessage.isDisplayed();

    }
}
