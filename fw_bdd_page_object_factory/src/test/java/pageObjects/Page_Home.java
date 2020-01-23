package pageObjects;
import java.util.List;

import allUtility.GeneralUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_Home {
    WebDriver driverLocal               = null;
    GeneralUtility generalUtility       = null;
    WebDriverWait  waitLocal            = null;
    public Page_Home(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driverLocal    = driver;
        generalUtility = new GeneralUtility();
        waitLocal      = generalUtility.simpleWebDriverWait(driverLocal);
    }

    @FindBy(how = How.CSS, using = "a[class='login']")
    private WebElement lnk_SignIn;
    @FindBy(how = How.ID, using = "email")
    private WebElement txtbx_Email;
    @FindBy(how = How.ID, using = "passwd")
    private WebElement txtbx_Pwd;
    @FindBy(how = How.ID, using = "SubmitLogin")
    private WebElement btn_SignIn;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Authentication failed.')]")
    private List<WebElement> labl_AuthenticationFiled;

    @FindBy(how = How.ID, using = "search_query_top")
    private WebElement txtbx_Search;
    @FindBy(how = How.NAME, using = "submit_search")
    private WebElement btn_Search;

    public void clickOnSignIn() {
        lnk_SignIn.click();
        generalUtility.simpleThreadWait(5000);
    }

    public void attemptToSearchForFollowingItem(String strSearchTerm) {
        txtbx_Search.sendKeys(strSearchTerm);
        btn_Search.click();
        generalUtility.simpleThreadWait(5000);
    }

}
