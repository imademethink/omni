package pageObjects;

import allUtility.GeneralUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Page_SearchResult {
    WebDriver driverLocal               = null;
    GeneralUtility generalUtility       = null;
    WebDriverWait  waitLocal            = null;
    public Page_SearchResult(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driverLocal    = driver;
        generalUtility = new GeneralUtility();
        waitLocal      = generalUtility.simpleWebDriverWait(driverLocal);
    }

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'results have been found.')]")
    private List<WebElement> labl_SearchResultCount;

    @FindBy(how = How.CSS, using = "")
    private List<WebElement> lst_lbl_ErrorBookingCanNotBeCompleted;

    public int getSearchResultCount(){
        if(labl_SearchResultCount.size() > 0){
            String strResultCount = labl_SearchResultCount
                    .get(0).getText()
                    .replace("results have been found.","");
            return Integer.valueOf(strResultCount.replace(" ",""));
        }
        return 0;
    }

}
