package GoogleChomeTests;

import com.PageObject.HomePageStellaburgers;
import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class TransferToPersonalAccountTest {

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.browser = "chrome";
    }

    @Test
    @DisplayName("Переход в ЛК по ссылке Личный кабинет")
    public void successfulTransferToPersonalAccount() {

        final String EXPECTED_URL = "https://stellarburgers.nomoreparties.site/login";

        HomePageStellaburgers homePageStellaburger = open("https://stellarburgers.nomoreparties.site/",
                HomePageStellaburgers.class);

        homePageStellaburger.clickLinkToThePersonalAccount();
        String actualURL =  url();

        Assert.assertEquals(actualURL, EXPECTED_URL);

    }
}
