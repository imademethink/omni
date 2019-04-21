package testngDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
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

public class DataDriven_Facebook {
    public WebDriver driver     = null;
    String fbURL                    = null;
    String path_chromedriver = "G:\\_____Framework_____\\CoreJava_Selenium\\demo\\util_browser_driver\\chromedriver.exe";


    @DataProvider(name="ProviderEmpDataFromExcel")
    public Object[][] getDataFromDataproviderFromExcel() {
        Object[][] arrayObject = getExcelData("G:\\_____Framework_____\\CoreJava_Selenium\\demo\\util_excel\\facebook_register.xlsx");
        return arrayObject;
    }

    @BeforeClass
    public void beforeDemoTestNG() {
        System.setProperty("webdriver.chrome.driver",path_chromedriver);
        driver= new ChromeDriver();
        driver.manage().window().setPosition(new Point(20,25));
        driver.manage().window().setSize(new Dimension(1200,750));
        try {
            Properties prop = new Properties();
            InputStream input = new FileInputStream("config.properties");
            prop.load(input);
            fbURL = prop.getProperty("fbRegistrationUrl");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @BeforeMethod
    public void beforeDataDrivenMethod() {
        driver.get(fbURL);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @AfterClass
    public void afterDemoTestNG() {
        driver.quit();
    }

    @Test(dataProvider="ProviderEmpDataFromExcel", alwaysRun=true)
    public void methodTest_DataDriven_Facebook_Register(
            String name_first, String name_last, String mobile, String password) {

        System.out.println("Facebook registration begin");

        System.out.println("  received name_first     : " + name_first);
        System.out.println("  received name_last      : " + name_last);
        System.out.println("  received mobile             : " + mobile);
        System.out.println("  received password       : " + password);

        WebElement username = driver.findElement(By.name("firstname"));
        username.clear();
        username.sendKeys(name_first);
        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.clear();
        lastname.sendKeys(name_last);
        WebElement mobilenum = driver.findElement(By.cssSelector("input[aria-label='Mobile number or email address']"));
        mobilenum.clear();
        mobilenum.sendKeys(mobile+Keys.TAB);
        //WebElement pwd = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement pwd = driver.findElement(By.xpath("//*[@id=\"u_0_w\"]"));
        pwd.clear();
        pwd.sendKeys(password);
        WebElement submit = driver.findElement(By.name("websubmit"));
        submit.click();
        System.out.println("Facebook registration enf");
    }





    public Object[][] getExcelData(String fileName) {
        Object[][] arrayExcelData = new Object[1][4];
        try {
            FileInputStream excelFile = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet datatypeSheet  = workbook.getSheetAt(0);
            int totalNoOfRows = datatypeSheet.getLastRowNum();
            int totalNoOfCols  = datatypeSheet.getRow(0).getLastCellNum();
            arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
            for (int i= 1 ; i < totalNoOfRows; i++) {
                XSSFRow row = datatypeSheet.getRow(i);
                for (int j=0; j < totalNoOfCols; j++) {
                    arrayExcelData[i-1][j] = row.getCell(j).toString();
                }
            }
            workbook.close();
        }catch(Exception g){g.printStackTrace(); }
        return arrayExcelData;
    }
}
