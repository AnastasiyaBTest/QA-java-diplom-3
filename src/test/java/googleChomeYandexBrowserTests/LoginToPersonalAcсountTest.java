package googleChomeYandexBrowserTests;

import com.codeborne.selenide.Configuration;
import com.pageObject.*;
import com.UserOperations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginToPersonalAcсountTest {


    private final String SITE_URL = "https://stellarburgers.nomoreparties.site/";

    private UserOperations userOperations;
    private Map<String, String> userData;

    @Before
    public void setUp(){
        if (System.getProperty("browser").equals("yandex")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        } else if(System.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        }
       userOperations = new UserOperations();
        userData = userOperations.register();
    }


    @Test
    @DisplayName("Вход в ЛК через кнопку войти в аккаунт на главной")
    public void successfulLoginToPersonalAccountOnTheButtonSignIn() {

        HomePageStellaburgers homePageStellaburger = open(SITE_URL,
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

        HomePageStellaburgers homePageStellaburger = open(SITE_URL,
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

        HomePageStellaburgers homePageStellaburger = open(SITE_URL,
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

        HomePageStellaburgers homePageStellaburger = open(SITE_URL,
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
