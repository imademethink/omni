package runners;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:functionalTests"},
        plugin = {
                    "pretty",
                    "html:out/cucumber-html-report","json:out/cucumber-report.json",
                    "usage:target/cucumber-usage.json",
                    "junit:target/cucumber-results.xml",
                    "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"
                  },
        glue = {"stepDefinitions"},
        tags = {"@login_all"},
        monochrome = true
    )

    public class RunCukesTest{
       @BeforeClass
       public static void setup() {
           LocalDateTime date = LocalDateTime.now();;
           String fileName    = "target/report_";
           fileName           = fileName+date.toString()
                                      .replace("-","_")
                                      .replace(":","_")
                                      + ".html";
           ExtentProperties extentProperties = ExtentProperties.INSTANCE;
           extentProperties.setReportPath(fileName);
       }

        @AfterClass
        public static void teardown() {
            Reporter.setSystemInfo("user", System.getProperty("user.name"));
            Reporter.setTestRunnerOutput("Sample test runner output message");
        }
    }
