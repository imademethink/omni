package allUtility;

import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import pageObjects.Page_Home;
import pageObjects.Page_Login;

import pageObjects.Page_SearchResult;

public class GlobalObjects {

    public WebDriver realDriver                = null;
    public PageObjectManager pageObjectManager = null;
    public Page_Home pageHome                  = null;
    public Page_Login pageLogin                = null;
    public Page_SearchResult pageSearchResult  = null;

    public ConfigFileReader configFileReader   = null;
    public GeneralUtility generalUtility       = null;

    public String baseURL           = null;
    public String path_chromedriver = "browserDriver//chromedriver.exe";
    public String path_gecodriver   = "browserDriver//geckodriver.exe";

}
