package YandexBrowserTests;

import com.PageObject.AuthorizathionPage;
import com.PageObject.HomePageStellaburgers;
import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;

public class TransferToConstructorAndClickLogoTest {
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        Configuration.browser = "chrome";
    }

    @Test
    @DisplayName("Переход из ЛК в конструктор")
    public void successfulTransferToConstructor() {

        final String EXPECTED_URL = "https://stellarburgers.nomoreparties.site/";

        HomePageStellaburgers homePageStellaburger = open("https://stellarburgers.nomoreparties.site/",
                HomePageStellaburgers.class);
        homePageStellaburger.clickLinkToThePersonalAccount();

        AuthorizathionPage authorizathionPage = page(AuthorizathionPage.class);
        authorizathionPage.clickLinkToConstructor();

        String actualURL =  url();

        Assert.assertEquals(EXPECTED_URL, actualURL);

    }

    @Test
    @DisplayName("Переход из ЛК в конструктор по логотипу")
    public void successfulTransferToLogo() {

        final String EXPECTED_URL = "https://stellarburgers.nomoreparties.site/";

        HomePageStellaburgers homePageStellaburger = open("https://stellarburgers.nomoreparties.site/",
                HomePageStellaburgers.class);
        homePageStellaburger.clickLinkToThePersonalAccount();

        AuthorizathionPage authorizathionPage = page(AuthorizathionPage.class);
        authorizathionPage.clickLogo();

        String actualURL =  url();

        Assert.assertEquals(EXPECTED_URL, actualURL);

    }
}
