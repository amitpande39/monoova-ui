package com.monoova.steps;

import com.monoova.pages.DashBoard;
import com.monoova.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MonoovaTestSteps {
    private DashBoard dashBoard;
    private RegisterPage registerPage;

    public MonoovaTestSteps() {
        this.registerPage = new RegisterPage();
        this.dashBoard = new DashBoard();
    }

    @Given("^I navigate to monoova registration page$")
    public void i_navigate_to_monoova_registration_page() {
        registerPage.goToRegistrationPage();
    }

    @And("^I enter my detail to register an account$")
    public void i_enter_registration_details_and_click_register() {
        registerPage.enterRegistrationDetails();
    }

    @And("^I verify email link$")
    public void i_verify_email_link_to_proceed_with_registration() {
        registerPage.verifyEmailLink();
    }

    @When("^I login to monoova with email, password$")
    public void i_login_to_monoova_with_email_password() throws Throwable {
        registerPage.loginToAccountAfterRegistration();
    }

    @And("^I create new automatcher account by entering accountName, clientUniqueId$")
    public void i_create_new_automatcher_account_by_entering_accountname_clientuniqueid() {
        dashBoard.createNewAutoMatherAccount();
    }

    @Then("^I validate a new automatcher account is created successfully$")
    public void i_validate_a_new_automatcher_account_is_created_successfully() {
        dashBoard.validateNewAutoMatcherAccountIsCreateSuccessfully();
    }
}
