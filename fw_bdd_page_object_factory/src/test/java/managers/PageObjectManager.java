package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.Page_Home;
import pageObjects.Page_AddCustomer;


public class PageObjectManager {
    private WebDriver driver                               = null;
    private Page_Home pageHome                      = null;
    private Page_AddCustomer pageAddCustomer = null;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }
    public Page_Home getPage_Home(){
        return (pageHome == null) ? pageHome = new Page_Home(driver) : pageHome;
    }
    public Page_AddCustomer getPage_AddCustomer(){
        return (pageAddCustomer == null) ? pageAddCustomer = new Page_AddCustomer(driver) : pageAddCustomer;
    }

}
