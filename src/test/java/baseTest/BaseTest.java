package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    protected void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    protected void getPage() {
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
//        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080");
    }
//
//    @AfterClass(alwaysRun = true)
//    public  void closeBrowser() {
//        driver.manage().deleteAllCookies();
//        driver.close();
//        driver.quit();
//    }
//
//    @AfterSuite(alwaysRun = true)
//    protected  void tearDown() {
//        driver.quit();
//    }
}
