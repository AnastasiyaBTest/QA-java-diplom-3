package googleChomeYandexBrowserTests;

import com.pageObject.HomePageStellaburgers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class TransferToPersonalAccountTest {

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
    @DisplayName("Переход в ЛК по ссылке Личный кабинет")
    public void successfulTransferToPersonalAccount() {

        final String EXPECTED_URL = "https://stellarburgers.nomoreparties.site/login";

        HomePageStellaburgers homePageStellaburger = open(SITE_URL,
                HomePageStellaburgers.class);

        homePageStellaburger.clickLinkToThePersonalAccount();
        String actualURL =  url();

        Assert.assertEquals(actualURL, EXPECTED_URL);

    }
}
