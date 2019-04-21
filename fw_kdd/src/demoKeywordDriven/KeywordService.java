package demoKeywordDriven;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class KeywordService {

    WebDriver         driver       =null;
    WebDriverWait   wait         =null;
    Properties          properties=null;

    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "G:\\_____Framework_____\\CoreJava_Selenium\\demo\\util_browser_driver\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    public void openUrl(String url) {
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    private By locatorValue(String locatorType, String value) {
        By by = null;
        switch (locatorType) {
            case "id":
                by = By.id(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "css":
                by = By.cssSelector(value);
                break;
            case "linkText":
                by = By.linkText(value);
                break;
            case "partialLinkText":
                by = By.partialLinkText(value);
                break;
            default:
                by = null;
                break;
        }
        return by;
    }

    public void enterText(String locatorType, String value, String text) {
        By locator = locatorValue(locatorType, value);
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
        wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.urlMatches("facebook"));
    }

    public void clickOnLocator(String locatorType, String value) {
        By locator = locatorValue(locatorType, value);
        WebElement element = driver.findElement(locator);
        element.click();
        wait.until(ExpectedConditions.urlMatches("facebook"));
    }

    public void closeBrowser() {
        driver.close();
    }

    public boolean verify(String locatorType, String value,String attribute,String valueToCheck){
        By locator                 = locatorValue(locatorType, value);
        WebElement element = driver.findElement(locator);
        String elementValue   = element.getAttribute(attribute);
        if(valueToCheck != null){return valueToCheck.equalsIgnoreCase(elementValue); }
        return element != null;
    }
}
