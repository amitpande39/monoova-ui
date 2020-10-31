package com.monoova.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Helper {
    private WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public String readConfigFile(String s)   {
        Properties properties = new Properties();
        try{
            InputStream in =new FileInputStream("./src/utility/config.property");
            properties.load(in);
        }
        catch (IOException e){
            System.out.println("FILE NOT FOUND");
            e.printStackTrace();
        }
        String value = properties.getProperty(s);
        return value;
    }

    private int getWaitTimeFromConfig(){
        return Integer.parseInt(readConfigFile("waitTime"));
    }

    private void waitUntilCondition(ExpectedCondition condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout );
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public void waitForElementToDisplay(WebElement webElement, String webElementName) {
        int timeout=getWaitTimeFromConfig();
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
        String timeoutMessage = webElementName + " wasn't displayed after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage,timeout);
    }
}
