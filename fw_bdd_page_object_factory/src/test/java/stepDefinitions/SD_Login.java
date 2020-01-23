package stepDefinitions;

import allUtility.ConfigFileReader;
import allUtility.GeneralUtility;
import allUtility.GlobalObjects;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import managers.PageObjectManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class SD_Login extends GlobalObjects {

    @Given("^Login TC I create chrome browser instance and navigate to home page$")
    public void login_tc_i_create_chrome_browser_instance_and_navigate_to_home_page() {
        System.out.println("I create chrome browser instance and navigate to home page");

        realDriver        = new GeneralUtility().initChromeBrowser(true);

        configFileReader  = new ConfigFileReader();
        configFileReader.ReadConfigFile_General();
        baseURL           = configFileReader.getApplicationUrl();
        pageObjectManager = new PageObjectManager(realDriver);
        pageHome          = pageObjectManager.getPage_Home();
        pageLogin         = pageObjectManager.getPage_Login();

        realDriver.get(baseURL);
        realDriver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
    }

    @When("^I attempt to login with valid credential$")
    public void i_attempt_to_login_with_valid_credential()  {
        System.out.println("I attempt to login with valid credential");

        pageHome.clickOnSignIn();

        pageLogin.attemptToSignIn(
                configFileReader.getUserName(),
                configFileReader.getPassword());
    }

    @Then("^Login should be successful$")
    public void login_should_be_successful() throws Exception {
        System.out.println("Login should be successful");

        boolean bLoginSuccess = pageLogin.checkIfLoginSuccess();

        realDriver.quit();

        if(false == bLoginSuccess){
            throw new Exception();
        }
    }

    @Given("^Login TC I launch \"([^\"]*)\" browser and navigate to home page$")
    public void lLogin_tc_i_launch_browser_and_navigate_to_home_page(String browserTypeRequired) {
        System.out.println("I launch " + browserTypeRequired + " browser and navigate to home page");

        if(browserTypeRequired.contains("chrome")){
            realDriver    = new GeneralUtility().initChromeBrowser(true);
        }else if(browserTypeRequired.contains("firefox")){
            realDriver    = new GeneralUtility().initFireFoxBrowser(false);
        }

        configFileReader  = new ConfigFileReader();
        configFileReader.ReadConfigFile_General();
        baseURL           = configFileReader.getApplicationUrl();

        pageObjectManager = new PageObjectManager(realDriver);
        pageHome          = pageObjectManager.getPage_Home();
        pageLogin         = pageObjectManager.getPage_Login();
        realDriver.get(baseURL);
        realDriver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
    }

    @When("^I attempt to login with invalid credential$")
    public void i_attempt_to_login_with_invalid_credential() {
        System.out.println("I attempt to login with invalid credential");

        pageHome.clickOnSignIn();

        pageLogin.attemptToSignIn(
                configFileReader.getUserName().replace("@","_@"),  // making it invalid/ unregistered email
                configFileReader.getPassword());
    }

    @Then("^Login should not be successful$")
    public void login_should_not_be_successful() throws Exception {
        System.out.println("Login should not be successful");

        boolean bLoginSuccess = pageLogin.checkIfLoginSuccess();

        realDriver.quit();

        if(true == bLoginSuccess){
            throw new Exception();
        }
    }

}
