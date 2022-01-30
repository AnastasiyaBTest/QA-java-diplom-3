import com.PageObject.AuthorizathionPage;
import com.PageObject.HomePageStellaburgers;
import com.PageObject.RegistrationPage;
import com.codeborne.selenide.Configuration;
import com.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationTest {

    private User user;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.browser = "chrome";
        user = User.getRandom();
    }

    @Test
    @DisplayName("Успешная регистрация и авторизация")
    public void successfulRegistrationWithValidDataAndLogin() {

        HomePageStellaburgers homePageStellaburger = open("https://stellarburgers.nomoreparties.site/",
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

        HomePageStellaburgers homePageStellaburger = open("https://stellarburgers.nomoreparties.site/",
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
