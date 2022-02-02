package com.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthorizathionPage {

    //локатор поля комментарий
    @FindBy(how = How.XPATH, using = ".//fieldset[1]//input")
    private SelenideElement emailField;

    //локатор поля комментарий
    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH,using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement logInButton;

    @FindBy(how = How.XPATH,using = ".//a[@class='Auth_link__1fOlj'][contains(text(),'Зарегистрироваться')]")
    private SelenideElement signUpLink;

    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj'][contains(text(),'Восстановить пароль')]")
    private SelenideElement linkToTheRecoverPassword;

    @FindBy(how = How.XPATH, using = ".//li[1]/a/p")
    private SelenideElement linkToConstructor;

    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logo;

    //метод заполнения поля ввода комментария для курьера
    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    //метод заполнения поля ввода комментария для курьера
    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    //метод клика по кнопке заказать
    public void clickLogInButton() {
        logInButton.click();
    }

    public void clickLogo() {
        logo.click();
    }

    public void clickSignUpLink() {
        signUpLink.click();
    }

    //метод клика по кнопке заказать
    public void clickLinkToTheRecoverPassword() {
        linkToTheRecoverPassword.click();
    }

    public void clickLinkToConstructor() {
        linkToConstructor.click();
    }

    public boolean hasLoginButton() {
        return logInButton.isDisplayed();

    }

}
