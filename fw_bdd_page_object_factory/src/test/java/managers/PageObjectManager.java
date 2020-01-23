package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.Page_Home;
import pageObjects.Page_Login;
import pageObjects.Page_SearchResult;


public class PageObjectManager {
    private WebDriver localDriver            = null;
    private Page_Home pageHome               = null;
    private Page_Login pageLogin             = null;
    private Page_SearchResult pageSearchResult=null;

    public PageObjectManager(WebDriver driver) {
        localDriver = driver;
    }

    public Page_Home getPage_Home(){
        if(pageHome == null) pageHome = new Page_Home(localDriver);
        return pageHome;
    }

    public Page_Login getPage_Login(){
        if(pageLogin == null) pageLogin = new Page_Login(localDriver);
        return pageLogin;
    }

    public Page_SearchResult getPage_SearchResult(){
        return (pageSearchResult == null) ?    pageSearchResult = new Page_SearchResult(localDriver) : pageSearchResult;
    }
}
