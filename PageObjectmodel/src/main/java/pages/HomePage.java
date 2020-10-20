package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.PreAndPost;

public class HomePage extends PreAndPost {
	
	public HomePage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage clickLogOut() {	
		driver.findElement(By.className("decorativeSubmit")).sendKeys("demosalesmanager");
		return new LoginPage(driver);
	}

}
