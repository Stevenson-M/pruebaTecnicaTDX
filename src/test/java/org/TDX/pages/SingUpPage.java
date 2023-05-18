package org.TDX.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingUpPage extends BasePage {

    @FindBy(css = "input[placeholder='Username']")
    private WebElement usernameInput;

    @FindBy(css = "input[placeholder='Email']")
    private WebElement emailInput;

    @FindBy(css = "input[placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(css = "body > app-root:nth-child(1) > app-layout-header:nth-child(1) > nav:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1)")
    private WebElement userSettingsRegisterName;



    public String emailRandom() {
        String email = "test.stevenson.prueba" + (int) (Math.random() * 1000000) + "@TDX.com";

        return email;
    }


    public void registerUser( String username, String password) {
        typeOnInput(usernameInput,username );
        typeOnInput(emailInput, emailRandom());
        typeOnInput(passwordInput, password);
        clickElement(submitButton);
    }



    public String getUserSettingsRegisterName() {
        return userSettingsRegisterName.getText();
    }



    public SingUpPage(WebDriver driver) {
        super(driver);
    }


}
