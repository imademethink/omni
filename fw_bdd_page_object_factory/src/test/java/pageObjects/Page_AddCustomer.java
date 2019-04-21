package pageObjects;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Page_AddCustomer {
    public Page_AddCustomer(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "label[for='pending']")
    private WebElement tickbx_VerificationPending;

    @FindBy(how = How.NAME, using = "fname")
    private WebElement txtbx_CustName;

    @FindBy(how = How.NAME, using = "lname")
    private WebElement txtbx_CustNameLast;

    public void fillCustomerForm() {
        tickbx_VerificationPending.click();
        txtbx_CustName.sendKeys("Maya");
        try{ Thread.sleep(5000);}catch(Exception t){}
    }

    public void  validateCustomerDetails(){
        if(!txtbx_CustNameLast.isDisplayed()){ Assert.fail();}
    }

    
}
