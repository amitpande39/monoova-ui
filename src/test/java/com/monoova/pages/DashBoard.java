package com.monoova.pages;

import com.monoova.basepage.BasePage;
import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashBoard extends BasePage {

    @FindBy(css = "[role='button'] p")
    private List<WebElement> menuList;

    @FindBy(css = "p.MuiTypography-subtitle1")
    private List<WebElement> accountList;

    @FindBy(css = ".h1")
    private WebElement accountHeading;

    @FindBy(id = "bankAcctName")
    private WebElement bankAccountName;

    @FindBy(id = "clientID")
    private WebElement clientUniqueId;

    @FindBy(css = "[type='checkbox']")
    private WebElement activeCheckBox;

    @FindBy(css = ".MuiButton-label")
    private List<WebElement> button;

    @FindBy(css = "h3")
    private WebElement successfulMessage;

    public DashBoard() {
        PageFactory.initElements(driver, this);
    }

    public void createNewAutoMatherAccount() {
        selectFromMenuList("RECEIVE");
        selectAutoMatcherAccount("Create Automatcher Account");
        bankAccountName.sendKeys("MyTestAccount" + RandomString.make(5));
        clientUniqueId.sendKeys(RandomString.make(15));
        activeCheckBox.click();
        clickButton("CREATE");
    }

    public void validateNewAutoMatcherAccountIsCreateSuccessfully() {
        helper.waitForElementToDisplay(successfulMessage, "wait for successful element");
        Assert.assertEquals(successfulMessage.getText(), "Account Added Successfully");
    }

    private void selectFromMenuList(String area) {
        for (WebElement webElement : menuList) {
            if (webElement.getText().equals(area)) {
                webElement.click();
                break;
            }
        }
    }

    private void selectAutoMatcherAccount(String account) {
        for (WebElement webElement : accountList) {
            if (webElement.getText().equals(account)) {
                webElement.click();
                break;
            }
        }
    }

    private void clickButton(String action) {
        for (WebElement webElement : button ) {
            if (webElement.getText().equals(action)) {
                webElement.click();
                break;
            }
        }
    }
}
