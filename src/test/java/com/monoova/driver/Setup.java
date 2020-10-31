package com.monoova.driver;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Setup {
    public static WebDriver driver;

    @Before
    public void setWebDriver() throws Exception {
        Properties properties;
        try (InputStream input = new FileInputStream("./src/utility/config.property")) {
            properties = new Properties();
            properties.load(input);
        }
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome":
                System.setProperty(properties.getProperty("chromeDriver"), properties.getProperty("chromeDriverPath"));
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("['start-maximized']");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }
}
