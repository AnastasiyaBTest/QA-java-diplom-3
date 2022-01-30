package GoogleChomeTests;

import com.PageObject.AccountProfilePage;
import com.PageObject.AuthorizathionPage;
import com.PageObject.HomePageStellaburgers;
import com.UserOperations;
import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LogoutOfPersonalAccountTest {

    private UserOperations userOperations;
    private Map<String, String> userData;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.browser = "chrome";

        userOperations = new UserOperations();
        userData = userOperations.register();
    }

    @Test
    @DisplayName("Выход из учетки")
    public void successfulLogoutOfPersonalAccount() {

        HomePageStellaburgers homePageStellaburger = open("https://stellarburgers.nomoreparties.site/",
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
