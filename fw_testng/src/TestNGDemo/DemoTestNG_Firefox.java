package TestNGDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import java.util.concurrent.TimeUnit;

public class DemoTestNG_Firefox {
    public WebDriver driver     = null;
    String baseURL                = "https://accounts.google.com";
    String path_gecodriver     = "G:\\_____Framework_____\\CoreJava_Selenium\\demo\\util_browser_driver\\geckodriver.exe";

    @BeforeClass
    public void beforeDemoTestNG() {
        System.setProperty("webdriver.gecko.driver", path_gecodriver);
        driver = new FirefoxDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(900,500));
    }

    @Test
    public void gmailLogin() {
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        String actualTitle     = driver.getTitle().trim();
        Assert.assertTrue(actualTitle.contains("Sign in"));
        Assert.assertFalse(actualTitle.contains("Google Accounts"));

        WebElement username = driver.findElement(By.id("identifierId"));
        username.clear();
        username.sendKeys("TestSelenium" + Keys.ENTER);
        try{Thread.sleep(3000);}catch(Exception e){;}

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("password123" + Keys.ENTER);
        try{Thread.sleep(3000);}catch(Exception e){;}

    }

    @AfterClass
    public void afterDemoTestNG() {
        driver.quit();
    }
}