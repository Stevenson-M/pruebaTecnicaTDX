package org.TDX.configuration;

import  io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import  org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import  org.openqa.selenium.firefox.FirefoxDriver;
import  org.openqa.selenium.edge.EdgeDriver;
import  org.openqa.selenium.safari.SafariDriver;


public class Driver {

    private WebDriver driver;

    public Driver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
