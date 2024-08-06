package greenmouse.ExtentReports;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemo {

	ExtentReports extent;

	@BeforeTest
	public void config() {

		// Note this two classes in building report : ExtentReports ,
		// ExtentSparkReporter

		String path = System.getProperty("user.dir") + "//reports//index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Automation Results");

		reporter.config().setDocumentTitle("Test Results");

		// main class ExtentReports to drive all report execution

		// ExtentReports extent = new ExtentReports();

		// Declare the class variable global to be called/access in another method

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Daniel");
	}

	@Test
	public void initialDemo() {

		// extent.createTest("testName");

		extent.createTest("initial Demo"); // this is used for all the test to monitor

//		System.setProperty("WebDriver.chrome.driver", "/Users/user/Desktop/Selenium/chromedriver");

//		WebDriver driver = new ChromeDriver();

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable notifications");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com");

		System.out.println(driver.getTitle());

		extent.flush(); // stop listening mood and generate report each time the test is run

		// To Explicitly fail (not to be applied in real time) the result replace line 51 with ExtentTest test =
		// event.creatTest("initialDemo")
		// before extent.fluch() write: 
		//driver.close();
		//test.fail("result do not match");
		

	}

}
