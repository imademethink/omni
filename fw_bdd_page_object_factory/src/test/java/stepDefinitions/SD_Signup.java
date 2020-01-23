package stepDefinitions;

import allUtility.ConfigFileReader;
import allUtility.GeneralUtility;
import allUtility.GlobalObjects;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;

import java.util.concurrent.TimeUnit;


public class SD_Signup extends GlobalObjects {

    @Given("^I launch \"([^\"]*)\" browser and navigate to home page SignupTC$")
    public void i_launch_browser_and_navigate_to_home_page_searchtc(String browserTypeRequired) {
        System.out.println("I launch " + browserTypeRequired + " browser and navigate to home page");
        // fill me
    }


    @When("^I attempt to signup with mandatory parameters$")
    public void i_attempt_to_signup_with_mandatory_parameters()  {
        System.out.println("I attempt to signup with mandatory parameters");
        // fill me
    }

    @Then("^Signup should be successful$")
    public void signup_should_be_successful() throws Exception {
        System.out.println("Signup should be successful");
        // fill me
    }

    @When("^I attempt to signup without mandatory parameters$")
    public void i_attempt_to_signup_without_mandatory_parameters()  {
        System.out.println("I attempt to signup without mandatory parameters");
        // fill me
    }

    @Then("^Signup should not be successful$")
    public void signup_should_not_be_successful() throws Exception {
        System.out.println("Signup should not be successful");
        // fill me
    }

}
