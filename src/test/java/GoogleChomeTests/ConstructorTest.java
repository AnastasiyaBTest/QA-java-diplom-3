package GoogleChomeTests;

import com.PageObject.HomePageStellaburgers;
import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ConstructorTest {

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.browser = "chrome";
    }

    @Test
    @DisplayName("Успешный выбор булочки")
    public void successfulClickOnBun() {

        HomePageStellaburgers homePageStellaburger = open("https://stellarburgers.nomoreparties.site/",
                HomePageStellaburgers.class);

        homePageStellaburger.clickFirstTabBunSection();

        boolean isDisplayed =  homePageStellaburger.hasInformationAboutBun();
        Assert.assertTrue(isDisplayed);

    }

    @Test
    @DisplayName("Успешный выбор соуса")
    public void successfulClickOnSauce() {

        HomePageStellaburgers homePageStellaburger = open("https://stellarburgers.nomoreparties.site/",
                HomePageStellaburgers.class);

        homePageStellaburger.clickSauceButton();
        homePageStellaburger.clickFirstTabSauceSection();

        boolean isDisplayed =  homePageStellaburger.hasInformationAboutSauce();
        Assert.assertTrue(isDisplayed);


    }

    @Test
    @DisplayName("Успешный выбор ингредиента")
    public void successfulClickOnIngredients() {

        HomePageStellaburgers homePageStellaburger = open("https://stellarburgers.nomoreparties.site/",
                HomePageStellaburgers.class);

        homePageStellaburger.clickIngredientsButton();
        homePageStellaburger.clickFirstTabIngredientsSection();

        boolean isDisplayed =  homePageStellaburger.hasInformationAboutIngredient();
        Assert.assertTrue(isDisplayed);

    }

}
