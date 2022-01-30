package YandexBrowserTests;

import com.PageObject.*;
import com.UserOperations;
import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginToPersonalAccountTest {
    private UserOperations userOperations;
    private Map<String, String> userData;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        Configuration.browser = "chrome";
        userOperations = new UserOperations();
        userData = userOperations.register();
    }


    @Test
    @DisplayName("Вход в ЛК через кнопку войти в аккаунт на главной")
    public void successfulLoginToPersonalAccountOnTheButtonSignIn() {

        HomePageStellaburgers homePageStellaburger = open("https://stellarburgers.nomoreparties.site/",
                HomePageStellaburgers.class);

        homePageStellaburger.clickLoginButton();
        AuthorizathionPage authorizathionPage = page(AuthorizathionPage.class);
        authorizathionPage.setEmailField(userData.get("email"));
        authorizathionPage.setPasswordField(userData.get("password"));
        authorizathionPage.clickLogInButton();

        boolean isDisplayed = homePageStellaburger.haslinkToThePersonalAccount();
        Assert.assertTrue(isDisplayed);

        homePageStellaburger.clickLinkToThePersonalAccount();

        AccountProfilePage accountProfilePage = page(AccountProfilePage.class);
        accountProfilePage.clickExitButton();

    }

    @Test
    @DisplayName("Вход в ЛК по ссылке Личный кабинет")
    public void successfulLoginToPersonalAccountThroughButtonPersonalAccount() {

        HomePageStellaburgers homePageStellaburger = open("https://stellarburgers.nomoreparties.site/",
                HomePageStellaburgers.class);

        homePageStellaburger.clickLinkToThePersonalAccount();
        AuthorizathionPage authorizathionPage = page(AuthorizathionPage.class);
        authorizathionPage.setEmailField(userData.get("email"));
        authorizathionPage.setPasswordField(userData.get("password"));
        authorizathionPage.clickLogInButton();

        boolean isDisplayed = homePageStellaburger.haslinkToThePersonalAccount();
        Assert.assertTrue(isDisplayed);

        homePageStellaburger.clickLinkToThePersonalAccount();

        AccountProfilePage accountProfilePage = page(AccountProfilePage.class);
        accountProfilePage.clickExitButton();

    }

    @Test
    @DisplayName("Вход в ЛК через кнопку войти на странице регистрации")
    public void successfulLoginToPersonalAccountThroughButtonSignInOnRegisterPage() {

        HomePageStellaburgers homePageStellaburger = open("https://stellarburgers.nomoreparties.site/",
                HomePageStellaburgers.class);

        homePageStellaburger.clickLinkToThePersonalAccount();

        AuthorizathionPage authorizathionPage = page(AuthorizathionPage.class);
        authorizathionPage.clickSignUpLink();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.clickSignUpButton();

        authorizathionPage.setEmailField(userData.get("email"));
        authorizathionPage.setPasswordField(userData.get("password"));
        authorizathionPage.clickLogInButton();

        boolean isDisplayed = homePageStellaburger.haslinkToThePersonalAccount();
        Assert.assertTrue(isDisplayed);

        //homePageStellaburger.clickLinkToThePersonalAccount();

        // AccountProfilePage accountProfilePage = page(AccountProfilePage.class);
        // accountProfilePage.clickExitButton();

    }

    @Test
    @DisplayName("Вход через с формы восстановления пароля")
    public void successfulLoginToPersonalAccountThroughLinkToTheRecoverPassword() {

        HomePageStellaburgers homePageStellaburger = open("https://stellarburgers.nomoreparties.site/",
                HomePageStellaburgers.class);

        homePageStellaburger.clickLinkToThePersonalAccount();

        AuthorizathionPage authorizathionPage = page(AuthorizathionPage.class);
        authorizathionPage.clickLinkToTheRecoverPassword();

        PasswordRecoveryPage passwordRecoveryPage = page(PasswordRecoveryPage.class);
        passwordRecoveryPage.clickLinkToSignIn();

        authorizathionPage.setEmailField(userData.get("email"));
        authorizathionPage.setPasswordField(userData.get("password"));
        authorizathionPage.clickLogInButton();

        boolean isDisplayed = homePageStellaburger.haslinkToThePersonalAccount();
        Assert.assertTrue(isDisplayed);

        homePageStellaburger.clickLinkToThePersonalAccount();

        AccountProfilePage accountProfilePage = page(AccountProfilePage.class);
        accountProfilePage.clickExitButton();

    }

}
