package pageObjects;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Page_Home {
    public Page_Home(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "a[href='addcustomer.php']")
    private WebElement lnk_AddCustomer;

    public void addCustomer() {
        lnk_AddCustomer.click();
        try{ Thread.sleep(5000);}catch(Exception t){}
    }

}
