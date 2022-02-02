package googleChomeYandexBrowserTests;

import com.pageObject.AuthorizathionPage;
import com.pageObject.HomePageStellaburgers;
import com.pageObject.RegistrationPage;
import com.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationTest {

    private final String SITE_URL = "https://stellarburgers.nomoreparties.site/";
    private User user;

    @Before
    public void setUp(){
        if (System.getProperty("browser").equals("yandex")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        } else if(System.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        }
        user = User.getRandom();
    }

    @Test
    @DisplayName("Успешная регистрация и авторизация")
    public void successfulRegistrationWithValidDataAndLogin() {

        HomePageStellaburgers homePageStellaburger = open(SITE_URL,
                HomePageStellaburgers.class);
        homePageStellaburger.clickLinkToThePersonalAccount();

        AuthorizathionPage authorizathionPage = page(AuthorizathionPage.class);
        authorizathionPage.clickSignUpLink();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setNameField(user.getName());
        registrationPage.setEmailField(user.getEmail());
        registrationPage.setPasswordField(user.getPassword());
        registrationPage.clickSignUpButton();

        authorizathionPage.setEmailField(user.getEmail());
        authorizathionPage.setPasswordField(user.getPassword());
        authorizathionPage.clickLogInButton();

        boolean isDisplayed = homePageStellaburger.haslinkToThePersonalAccount();
        Assert.assertTrue(isDisplayed);

    }

    @Test
    @DisplayName("Ошибочная регистрация при указании пароля меньше 6 символов")
    public void unsuccessfulRegistrationWithInvalidPassword() {

        HomePageStellaburgers homePageStellaburger = open(SITE_URL,
                HomePageStellaburgers.class);
        homePageStellaburger.clickLinkToThePersonalAccount();

        AuthorizathionPage authorizathionPage = page(AuthorizathionPage.class);
        authorizathionPage.clickSignUpLink();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setNameField(user.getName());
        registrationPage.setEmailField(user.getEmail());
        user.setPassword(RandomStringUtils.randomAlphabetic(5));
        registrationPage.setPasswordField(user.getPassword());
        registrationPage.clickSignUpButton();


        boolean isDisplayedErrorMessage = registrationPage.hasErrorMessage();
        Assert.assertTrue(isDisplayedErrorMessage);

    }
}
