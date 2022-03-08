package TestCases;

import ObjectFactory.Page;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class BaseTest {
    private static WebDriver driver;
    protected Page pageFactory;
    public static Properties prop;
    protected static ObjectFactory obj;

    @BeforeSuite
    public void launch_browser() throws Exception {
        Properties prop = new Properties();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekJoshi\\IdeaProjects\\Framework\\chromedriver.exe");
        driver = new ChromeDriver();
        pageFactory = new Page(driver);
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\VivekJoshi\\IdeaProjects\\Framework\\src\\main\\java\\Pages\\data.properties");
            prop = new Properties();
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
       // driver.get(prop.getProperty("URL"));
       driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }

//    @BeforeMethod()
//    public void loadBaseUrl() {
//        obj = new Page();
//        driver.get(prop.getProperty("URL"));
//        driver.manage().window().maximize();
//    }

    @AfterMethod
    public void screenshotAndDeleteCookies(ITestResult testResult) throws IOException {

        //Taking screenshot in case of failure
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + ".jpg"));
        }
        //Deleting cookies
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}



