package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.ReadExcel;

public class PreAndPost {
	
	public ChromeDriver driver;
	public static String fileName;
	
	@BeforeMethod()

	public void startApp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();		
	}
	
	@AfterMethod()
	public void closeApp() {
		driver.close();
	}
	
	@BeforeTest()
	public void getFileName() {
		fileName = "TC001";
	}
	
	@DataProvider(name="setData", parallel=true)
	public Object[][] setData() throws IOException {
		
		/*Object[][] data = new Object[2][2];
		data[0][0] = "DemoSalesManager";
		data[0][1] = "crmsfa";
		
		data[1][0] = "DemoCSR";
		data[1][1] = "crmsfa";*/
		
		ReadExcel readExcel = new ReadExcel();
		return readExcel.readExcel(fileName);
	}

}
