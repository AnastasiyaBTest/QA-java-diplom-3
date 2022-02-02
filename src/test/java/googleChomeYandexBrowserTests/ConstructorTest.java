package googleChomeYandexBrowserTests;

import com.codeborne.selenide.Configuration;
import com.pageObject.HomePageStellaburgers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {

    private final String SITE_URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void setUp(){
        if (System.getProperty("browser").equals("yandex")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        } else if(System.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        }
        Configuration.browser = "chrome";
    }

    @Test
    @DisplayName("Успешный выбор булочки")
    public void successfulClickOnBun() {

        HomePageStellaburgers homePageStellaburger = open(SITE_URL,
                HomePageStellaburgers.class);

        homePageStellaburger.clickFirstTabBunSection();

        boolean isDisplayed =  homePageStellaburger.hasInformationAboutBun();
        Assert.assertTrue(isDisplayed);

    }

    @Test
    @DisplayName("Успешный выбор соуса")
    public void successfulClickOnSauce() {

        HomePageStellaburgers homePageStellaburger = open(SITE_URL,
                HomePageStellaburgers.class);

        homePageStellaburger.clickSauceButton();
        homePageStellaburger.clickFirstTabSauceSection();

        boolean isDisplayed =  homePageStellaburger.hasInformationAboutSauce();
        Assert.assertTrue(isDisplayed);


    }

    @Test
    @DisplayName("Успешный выбор ингредиента")
    public void successfulClickOnIngredients() {

        HomePageStellaburgers homePageStellaburger = open(SITE_URL,
                HomePageStellaburgers.class);

        homePageStellaburger.clickIngredientsButton();
        homePageStellaburger.clickFirstTabIngredientsSection();

        boolean isDisplayed =  homePageStellaburger.hasInformationAboutIngredient();
        Assert.assertTrue(isDisplayed);

    }

}
