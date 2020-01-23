package pageObjects;

import allUtility.GeneralUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Page_Login {
    WebDriver driverLocal               = null;
    GeneralUtility generalUtility       = null;
    WebDriverWait  waitLocal            = null;
    public Page_Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driverLocal    = driver;
        generalUtility = new GeneralUtility();
        waitLocal      = generalUtility.simpleWebDriverWait(driverLocal);
    }

    @FindBy(how = How.ID, using = "email")
    private WebElement txtbx_Email;
    @FindBy(how = How.ID, using = "passwd")
    private WebElement txtbx_Pwd;
    @FindBy(how = How.ID, using = "SubmitLogin")
    private WebElement btn_SignIn;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Authentication failed.')]")
    private List<WebElement> labl_AuthenticationFiled;

    public void attemptToSignIn(String strUser, String strPwd) {
        txtbx_Email.sendKeys(strUser);
        txtbx_Pwd.sendKeys(strPwd);
        btn_SignIn.click();
        generalUtility.simpleThreadWait(5000);
    }

    public boolean checkIfLoginSuccess() {
        if(labl_AuthenticationFiled.size() > 0){
            System.out.println("Error::  Login failed due to authentication issue");
            return false;
        }
        return true;
    }
}
