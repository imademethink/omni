package TestNGDemo;

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


public class DemoTestNG_Chrome2 {

    @DataProvider(name="ProviderEmpDataFromExcel")
    public Object[][] getDataFromDataproviderFromExcel() {
        Object[][] arrayObject = getExcelData("G:\\_____Framework_____\\CoreJava_Selenium\\demo\\util_excel\\sample.xlsx");
        return arrayObject;
    }

    @DataProvider(name="EmpDataProvider")
    public Object[][] getDataFromDataprovider(){
        return new Object[][]{
                        // name age salary location
                        { "Neil", 33, 33000, "India" },
                        { "Lucy", 35, 20000, "UK" },
                        { "John", 40, 15000, "USA" }
                };
    }



    @BeforeClass
    public void beforeDemoTestNG() {System.out.println("chrome - beforeDemoTestNG");}

    @BeforeMethod
    public void beforeDemoTestNGClassMethod() {System.out.println("chrome - beforeDemoTestNGClassMethod");}

    @AfterMethod
    public void afterDemoTestNGClassMethod() {System.out.println("chrome - afterDemoTestNGClassMethod");}

    @AfterClass
    public void afterDemoTestNG() {System.out.println("chrome - afterDemoTestNG"); }



    @Test
    @Parameters({"myusername","myuserpwd"})
    public void gmailLogin(String myusername,String myuserpwd) {
        System.out.println("  received myusername : " + myusername);
        System.out.println("  received myuserpwd   : " + myuserpwd);
        System.out.println("chrome - gmailLogin");
    }

    @Test(dataProvider="EmpDataProvider")
    public void guru99Tests(String name, int age, int salary, String location) {
        System.out.println("  received name     : " + name);
        System.out.println("  received age        : " + age);
        System.out.println("  received salary    : " + salary);
        System.out.println("  received location : " + location);
        System.out.println("chrome - guru99Tests");
    }

    @Test(dataProvider="ProviderEmpDataFromExcel", alwaysRun=true)
    public void guru99Tests2(String name, String age, String salary) {
        System.out.println("  received name     : " + name);
        System.out.println("  received age        : " + age);
        System.out.println("  received salary    : " + salary);
        System.out.println("chrome - guru99Tests2");
    }





    public String[][] getExcelData(String fileName) {
        try {
            FileInputStream excelFile = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet datatypeSheet  = workbook.getSheetAt(0);
            int totalNoOfRows = datatypeSheet.getLastRowNum();
            int totalNoOfCols  = datatypeSheet.getRow(0).getLastCellNum();
            String[][] arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
            for (int i= 1 ; i < totalNoOfRows; i++) {
                XSSFRow row = datatypeSheet.getRow(i);
                for (int j=0; j < totalNoOfCols; j++) {
                    arrayExcelData[i-1][j] = row.getCell(j).toString();
                }
            }
            workbook.close();
            return arrayExcelData;
        }catch(Exception g){g.printStackTrace(); }
        return new String[1][3]; // return empty
    }
}
