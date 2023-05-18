package org.TDX.tests;

import org.TDX.pages.MainPage;
import org.TDX.pages.SingUpPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SingUpTest extends BaseTest {

    @Test
    @Parameters({"username", "password","url"})
    public void SingUpTest(String username, String password, String url) {
        MainPage mainPage = new MainPage(driver.getDriver());
        mainPage.goToSingUpPage();
        SingUpPage singUpPage = new SingUpPage(driver.getDriver());
        singUpPage.registerUser(username,password);
        MainPage mainPage2 = new MainPage(driver.getDriver());
        Assert.assertTrue(mainPage2.isRedirectedToMainPage(url), "No se redirigió a la página principal.");
        Assert.assertEquals(singUpPage.getUserSettingsRegisterName(), username, "El nombre de usuario no coincide.");
    }
}