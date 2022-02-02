package googleChomeYandexBrowserTests;

import com.codeborne.selenide.Configuration;
import com.pageObject.AccountProfilePage;
import com.pageObject.AuthorizathionPage;
import com.pageObject.HomePageStellaburgers;
import com.UserOperations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LogoutOfPersonalAccountTest {

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
    @DisplayName("Выход из учетки")
    public void successfulLogoutOfPersonalAccount() {

        HomePageStellaburgers homePageStellaburger = open(SITE_URL,
                HomePageStellaburgers.class);
        homePageStellaburger.clickLoginButton();

        AuthorizathionPage authorizathionPage = page(AuthorizathionPage.class);
        authorizathionPage.setEmailField(userData.get("email"));
        authorizathionPage.setPasswordField(userData.get("password"));
        authorizathionPage.clickLogInButton();

        homePageStellaburger.clickLinkToThePersonalAccount();

        AccountProfilePage accountProfilePage = page(AccountProfilePage.class);
        accountProfilePage.clickExitButton();

        boolean isDisplayed = authorizathionPage.hasLoginButton();
        Assert.assertTrue(isDisplayed);

    }
}
