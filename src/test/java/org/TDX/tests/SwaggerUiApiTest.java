package org.TDX.tests;

import org.TDX.configuration.Driver;
import org.TDX.pages.SwaggerPage;
import org.TDX.reporting.Reporter;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static java.lang.String.format;

public class SwaggerUiApiTest extends BaseTest  {

    public Driver driver;


    @Test
    @Parameters({"browser", "swaggerUrl"})
    public void SwaggerUiApiTest(String browser, String swaggerUrl) {

        driver = new Driver(browser);
        Reporter.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();

        Reporter.info(format("Navigating to %s", swaggerUrl));
        driver.getDriver().get(swaggerUrl);
        driver.getDriver().manage().window().maximize();

        SwaggerPage swaggerPage = new SwaggerPage(driver.getDriver());
        swaggerPage.clickGetButton();
        swaggerPage.clickTryItOutButton();
        swaggerPage.clickExecuteButton();

        Assert.assertEquals(swaggerPage.getResponseCode200(), "200", "El código de respuesta no es 200.");
        Assert.assertTrue(swaggerPage.checkResponseCodeBody(), "El cuerpo de la respuesta no es correcto.");

        Reporter.info("Closing browser");
        driver.getDriver().quit();

    }
}
