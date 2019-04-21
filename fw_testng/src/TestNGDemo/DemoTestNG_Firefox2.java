package TestNGDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoTestNG_Firefox2 {
    @BeforeClass
    public void beforeDemoTestNG() {System.out.println("firefox - beforeDemoTestNG");}

    @Test
    public void gmailLogin() {System.out.println("firefox - gmailLogin");}

    @Test
    public void guru99Tests() {System.out.println("firefox - guru99Tests");}

    @AfterClass
    public void afterDemoTestNG() {
        System.out.println("firefox - afterDemoTestNG");
    }
}