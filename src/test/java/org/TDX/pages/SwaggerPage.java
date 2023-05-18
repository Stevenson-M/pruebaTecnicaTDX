package org.TDX.pages;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.json.JSONArray;
import org.json.JSONObject;

public class SwaggerPage extends BasePage {

    @FindBy(css = "button[aria-label='get \u200B/WeatherForecast']")
    private WebElement getButton;

    @FindBy(css = ".btn.try-out__btn")
    private WebElement tryItOutButton;

    @FindBy(css = ".btn.execute.opblock-control__btn")
    private WebElement executeButton;


    @FindBy(xpath = "//td[@class='response-col_status']")
    private WebElement responseCode200;

    @FindBy(css = "body > div:nth-child(1) > section:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > section:nth-child(1) > div:nth-child(1) > span:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(4) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1) > div:nth-child(2) > pre:nth-child(3)")
    private WebElement responseCodeBody;


    public void clickGetButton() {
        clickElement(getButton);
    }

    public void clickTryItOutButton() {
        clickElement(tryItOutButton);
    }

    public void clickExecuteButton() {
        clickElement(executeButton);
    }

    public String getResponseCode200() {
        return responseCode200.getText();
    }

    public boolean checkResponseCodeBody() {
        waitForClickable(responseCodeBody);
        String responseCodeBodyText = responseCodeBody.getText();
        try {
            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(responseCodeBodyText, JsonArray.class);
            JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();

            String date = jsonObject.get("date").getAsString();
            int temperatureC = jsonObject.get("temperatureC").getAsInt();
            int temperatureF = jsonObject.get("temperatureF").getAsInt();
            String summary = jsonObject.get("summary").getAsString();

            if (date != null && temperatureC != 0 && temperatureF != 0 && summary != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public SwaggerPage(WebDriver driver) {
        super(driver);
    }
}
