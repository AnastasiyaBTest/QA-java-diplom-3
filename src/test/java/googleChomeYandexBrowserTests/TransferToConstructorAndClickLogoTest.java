package googleChomeYandexBrowserTests;

import com.pageObject.AuthorizathionPage;
import com.pageObject.HomePageStellaburgers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;

public class TransferToConstructorAndClickLogoTest {

    private final String SITE_URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void setUp(){
        if (System.getProperty("browser").equals("yandex")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        } else if(System.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        }
    }

    @Test
    @DisplayName("Переход из ЛК в конструктор")
    public void successfulTransferToConstructor() {

        final String EXPECTED_URL = "https://stellarburgers.nomoreparties.site/";

        HomePageStellaburgers homePageStellaburger = open(SITE_URL,
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

        HomePageStellaburgers homePageStellaburger = open(SITE_URL,
                HomePageStellaburgers.class);
        homePageStellaburger.clickLinkToThePersonalAccount();

        AuthorizathionPage authorizathionPage = page(AuthorizathionPage.class);
        authorizathionPage.clickLogo();

        String actualURL =  url();

        Assert.assertEquals(EXPECTED_URL, actualURL);

    }
}
