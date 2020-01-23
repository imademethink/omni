package stepDefinitions;

import allUtility.ConfigFileReader;
import allUtility.GeneralUtility;
import allUtility.GlobalObjects;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class SD_Search extends GlobalObjects {

    @Given("^I launch \"([^\"]*)\" browser and navigate to home page SearchTC$")
    public void i_launch_browser_and_navigate_to_home_page_searchtc(String browserTypeRequired) {
        System.out.println("I launch " + browserTypeRequired + " browser and navigate to home page");

        if(browserTypeRequired.contains("chrome")){
            realDriver    = new GeneralUtility().initChromeBrowser(false);
        }else if(browserTypeRequired.contains("firefox")){
            realDriver    = new GeneralUtility().initFireFoxBrowser(false);
        }

        configFileReader  = new ConfigFileReader();
        configFileReader.ReadConfigFile_General();
        baseURL           = configFileReader.getApplicationUrl();

        pageObjectManager = new PageObjectManager(realDriver);
        pageHome          = pageObjectManager.getPage_Home();
        pageSearchResult  = pageObjectManager.getPage_SearchResult();

        realDriver.get(baseURL);
        realDriver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
    }


    @When("^I attempt to search for valid item$")
    public void i_attempt_to_search_for_valid_item()  {
        System.out.println("I attempt to search for valid item");

        // index 0 th term is valid in csv file
        String strSearchTerm = new GeneralUtility().getSearchTerm(0);

        pageHome.attemptToSearchForFollowingItem(strSearchTerm);
    }

    @Then("^Valid search result should be shown$")
    public void valid_search_result_should_be_shown() throws Exception {
        System.out.println("Valid search result should be shown");

        int nSearchResultCount = pageSearchResult.getSearchResultCount();

        realDriver.quit();

        if(nSearchResultCount < 1){
            throw new Exception("Error: No search results are shown for valid search item");
        }
// tbd compare the corresponding search result from pdf file config//Search_results_expected_coount.pdf
    }

    @When("^I attempt to search for invalid item$")
    public void i_attempt_to_search_for_invalid_item()  {
        System.out.println("I attempt to search for invalid item");

        // index 1 st term is invalid in csv file
        String strSearchTerm = new GeneralUtility().getSearchTerm(1);

        pageHome.attemptToSearchForFollowingItem(strSearchTerm);
    }

    @Then("^Valid search result should not be shown$")
    public void valid_search_result_should_not_be_shown() throws Exception {
        System.out.println("Valid search result should not be shown");

        int nSearchResultCount = pageSearchResult.getSearchResultCount();

        realDriver.quit();

        if(nSearchResultCount > 0){
            throw new Exception("Error: Search results are shown for invalid search item");
        }
// tbd compare the corresponding search result from pdf file config//Search_results_expected_coount.pdf
    }

}
