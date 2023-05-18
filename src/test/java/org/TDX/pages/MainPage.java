package org.TDX.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(css = ".nav-link[routerlink='/register']")
    private WebElement singUpButton;

    @FindBy(css = ".nav-link.active[routerlink='/']")
    private WebElement homeButton;


    public SingUpPage goToSingUpPage() {
        clickElement(singUpButton);
        return new SingUpPage(getDriver());
    }

    public boolean isRedirectedToMainPage(String url) {
        waitForClickable(homeButton);
        return getDriver().getCurrentUrl().equals(url);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
}