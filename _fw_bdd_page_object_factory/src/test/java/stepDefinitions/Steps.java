package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import java.util.concurrent.TimeUnit;

import managers.PageObjectManager;
import pageObjects.Page_Home;
import pageObjects.Page_AddCustomer;


public class Steps {

    WebDriver driver              = null;
    String baseURL1              = "http://demo.guru99.com/telecom/index.html";
    String path_chromedriver = "G:\\_____Framework_____\\CoreJava_Selenium\\demo\\util_browser_driver\\chromedriver.exe";

    PageObjectManager pageObjectManager = null;
    Page_Home pageHome                          = null;
    Page_AddCustomer pageAddCustomer     = null;

    @Given("^I open browser and launch website$")
    public void i_open_browser_and_launch_website()  {
        System.out.println("Debug::  Launching browser and navigating to website");

        System.setProperty("webdriver.chrome.driver",path_chromedriver);
        driver= new ChromeDriver();
        driver.manage().window().setPosition(new Point(20,30));
        driver.manage().window().setSize(new Dimension(1100,800));

        pageObjectManager = new PageObjectManager(driver);
        pageHome               = pageObjectManager.getPage_Home();
        pageAddCustomer    = pageObjectManager.getPage_AddCustomer();

        driver.get(baseURL1);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @When("^I click on add customer$")
    public void i_click_on_add_customer()  {
        System.out.println("Debug::  Clicking on adding a customer");

        pageHome.addCustomer();

//        WebElement username = driver.findElement(By.id("identifierId"));
//        username.clear();
//        username.sendKeys("TestSelenium" + Keys.ENTER);
//        try{Thread.sleep(3000);}catch(Exception e){;}
//
//        WebElement password = driver.findElement(By.name("password"));
//        password.clear();
//        password.sendKeys("password123" + Keys.ENTER);
//        try{Thread.sleep(3000);}catch(Exception e){;}
    }

    @When("^I fill customer details$")
    public void i_fill_customer_details()  {
        System.out.println("Debug::  Filling customer details");
        pageAddCustomer.fillCustomerForm();
    }


    @Then("^I validate customer details$")
    public void i_validate_customer_details()  {
        System.out.println("Debug::   Validating customer details");
        pageAddCustomer.validateCustomerDetails();
        driver.quit();
    }
}
