package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;

import java.util.concurrent.TimeUnit;

public class DemoTestNG_Chrome {
    public WebDriver driver     = null;
    String baseURL1               = "https://accounts.google.com";
    String baseURL2               = "http://www.demo.guru99.com/v4/";
    String path_chromedriver = "G:\\_____Framework_____\\CoreJava_Selenium\\demo\\util_browser_driver\\chromedriver.exe";

    @BeforeClass
    public void beforeDemoTestNG() {
        System.setProperty("webdriver.chrome.driver",path_chromedriver);
        driver= new ChromeDriver();
        driver.manage().window().setPosition(new Point(300,300));
        driver.manage().window().setSize(new Dimension(900,500));
    }

    @Test
    public void gmailLogin() {
        driver.get(baseURL1);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        String actualTitle     = driver.getTitle().trim();
        Assert.assertFalse(actualTitle.contains("Sign in"));
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

    @Test
    public void guru99Tests() {
        driver.get(baseURL2);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        driver.findElement(By.name("uid")).sendKeys("Username1");
        driver.findElement(By.name("password")).sendKeys("Password123");

        try{Thread.sleep(3000);}catch(Exception e){;}
        driver.findElement(By.name("btnReset")).click();
    }

    @AfterClass
    public void afterDemoTestNG() {
        driver.quit();
    }
}