package com.monoova.basepage;

import com.monoova.driver.Helper;
import com.monoova.driver.Setup;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    protected Helper helper;

    public BasePage() {
        this.driver = Setup.driver;
        this.helper = new Helper(this.driver);
    }
}
