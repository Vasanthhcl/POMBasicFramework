package utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CreateReport {
	
	@Test()
	public void name() throws IOException {
		
		//Report Path
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/result.html");
		//To Keep the History
		html.setAppendExisting(true);
		//Design Report
		ExtentReports extent = new ExtentReports();	
		//Connect ExtentReports to ExtentHtmlReporter
		extent.attachReporter(html);
		//Entry for each test cases in Report //ctrl+2 l(Release ctrl2 and press l)
		ExtentTest Login = extent.createTest("TC001Login", "Login to Leaftaps");
		Login.assignAuthor("Vasanth");
		Login.assignCategory("Smoke");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		File src = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./reports/output.png"));
		driver.findElementById("username").sendKeys("Vasanth");
		//Step Level report
		Login.pass(" Enter Username is Successful ",MediaEntityBuilder.createScreenCaptureFromPath("./output.png").build());
		Login.pass(" Enter Password is Successful ");
		Login.pass(" Log out is successful ");
		//Create Report
		extent.flush();
		
	}

}
