package com.monoova.pages;

import com.monoova.basepage.BasePage;
import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class RegisterPage extends BasePage {
    @FindBy(css = ".MuiButtonBase-root")
    private WebElement registerButton;

    @FindBy(css = ".jss294 .MuiButton-label")
    private WebElement register;

    @FindBy(id = "fullname")
    private WebElement fullName;

    @FindBy(id = "companyname")
    private WebElement groupName;

    @FindBy(id = "email")
    private WebElement enterEmail;

    @FindBy(id = "passwd")
    private WebElement passWord;

    @FindBy(id = "confpasswd")
    private WebElement confirmPassword;

    @FindBy(css = ".MuiTypography-h6")
    private WebElement successfulMessage;

    //FAKER
    @FindBy(id = "userName")
    private WebElement userText;

    @FindBy(id = "domainName2")
    private WebElement domainName;

    @FindBy(id = "copbtn")
    private WebElement copyButton;

    @FindBy(id = "email_ch_text")
    private WebElement email;

    @FindBy(css = "p [target='_blank']")
    private WebElement verifyEmailBody;

    @FindBy(css = "[name='email']")
    private WebElement loginEmail;

    @FindBy(css = "img.auth0-lock-header-logo")
    private WebElement image;

    @FindBy(css = "[name='password']")
    private WebElement loginPassword;

    @FindBy(css = ".auth0-label-submit")
    private WebElement loginButton;

    @FindBy(css = "h1.MuiTypography-noWrap")
    private WebElement dashBoardHeading;

    String customerEmail = getEmail();

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    public void goToRegistrationPage() {
        driver.get(helper.readConfigFile("baseURL"));
        helper.waitForElementToDisplay(registerButton, "registration button on login page");
        this.registerButton.click();
    }

    public void enterRegistrationDetails() {
        fullName.sendKeys("amitpande");
        groupName.sendKeys("Lotus" + RandomString.make(6));
        enterEmail.sendKeys(customerEmail);
        passWord.sendKeys("Test1234");
        confirmPassword.sendKeys("Test1234");
        this.register.click();
        helper.waitForElementToDisplay(successfulMessage, "registration success");
        Assert.assertEquals(this.successfulMessage.getText(), "Registration successful.");
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
    }

    public void verifyEmailLink() {
        driver.get(helper.readConfigFile("fakeEmailURL"));
        helper.waitForElementToDisplay(this.userText, "user text");
        this.userText.clear();
        this.userText.sendKeys(customerEmail.substring(0, 14));
        helper.waitForElementToDisplay(this.domainName, "domain name");
        this.domainName.sendKeys(Keys.chord(Keys.COMMAND, "a"), "sceenic.com");
        this.domainName.sendKeys(Keys.TAB);
        driver.navigate().refresh();
        helper.waitForElementToDisplay(this.verifyEmailBody, "email body verification link");
        this.verifyEmailBody.click();
    }

    public void loginToAccountAfterRegistration() {
        driver.get(helper.readConfigFile("baseURL"));
        String mainWindow = driver.getWindowHandle();
        driver.switchTo().window(mainWindow);
        helper.waitForElementToDisplay(image, "wait for image on login window");
        helper.waitForElementToDisplay(loginEmail, "wait login email ");
        loginEmail.sendKeys(customerEmail);
        loginPassword.sendKeys("Test1234");
        loginButton.click();
        helper.waitForElementToDisplay(dashBoardHeading, "dashboard");
    }

    private String getEmail() {
        String email = "amitpande" + RandomString.make(5) + "@sceenic.com";
        return email;
    }

}
