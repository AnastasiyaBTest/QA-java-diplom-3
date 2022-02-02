package com.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordRecoveryPage {
    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj'][contains(text(),'Войти')]")
    private SelenideElement linkToSignIn;

    public void clickLinkToSignIn() {
        linkToSignIn.click();
    }
}
