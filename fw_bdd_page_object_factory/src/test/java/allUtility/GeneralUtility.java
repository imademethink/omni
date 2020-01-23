package allUtility;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.File;
import java.text.*;
import java.util.*;

public class GeneralUtility extends GlobalObjects{

    public void simpleThreadWait(long milliSec){
        try{Thread.sleep(milliSec);}catch(Exception w){}
    }

    public void simpleScrollTo(WebDriver driver, String strPixelCount){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String strJsCommand = "window.scrollTo(0, __actualpixelcount__)";
        strJsCommand = strJsCommand.replace("__actualpixelcount__", strPixelCount);
        js.executeScript(strJsCommand);
    }

    public void simpleScrollToPageHeight(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public WebDriver initChromeBrowser(boolean bLoadImages){
        if(null!=realDriver) return realDriver;

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        if(!bLoadImages) {
            prefs.put("profile.managed_default_content_settings.images", 2);
        }
        ChromeOptions objChromeOptions = new ChromeOptions();
        objChromeOptions.setExperimentalOption("prefs", prefs);
        //objChromeOptions.addArguments("start-maximized");
        //objChromeOptions.addArguments("--disable-infobars");
        objChromeOptions.addArguments("--incognito");
        objChromeOptions.addArguments("--disable-popup-blocking");
        objChromeOptions.addArguments("--no-sandbox");
        objChromeOptions.addArguments("--disable-dev-shm-usage");
        DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
        chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, objChromeOptions);
        System.setProperty("webdriver.chrome.driver",path_chromedriver);

        WebDriver driverLocal= new ChromeDriver(chromeCapabilities);
        driverLocal.manage().window().setPosition(new Point(2,2));
        driverLocal.manage().window().setSize(new Dimension(1400,800));
        driverLocal.manage().deleteAllCookies();
        return driverLocal;
    }

    public WebDriver initFireFoxBrowser(boolean bLoadImages){
        if(!bLoadImages) {
//            prefs.put("profile.managed_default_content_settings.images", 2);
        }

        System.setProperty("webdriver.gecko.driver",path_gecodriver);
        WebDriver driverLocal= new FirefoxDriver();
        driverLocal.manage().window().setPosition(new Point(2,2));
        driverLocal.manage().window().setSize(new Dimension(1500,840));
        driverLocal.manage().deleteAllCookies();
        return driverLocal;
    }

    public WebDriverWait simpleWebDriverWait(WebDriver driver){
        return new WebDriverWait(driver, 20);
    }

    public String getSearchTerm(int nIndex) {

        String strCsvFilePAth   = "configs\\search_params.csv";
        String strEachLine      = "";
        String strCvsSplitBy    = ",";
        String strSearchTerm    = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(strCsvFilePAth))) {
            while ((strEachLine = br.readLine()) != null) {
                strSearchTerm = strSearchTerm + "__" + strEachLine.split(strCvsSplitBy)[0];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strSearchTerm.split("__")[nIndex+1];
    }

}
