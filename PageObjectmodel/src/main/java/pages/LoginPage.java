package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindAll;

import base.PreAndPost;

public class LoginPage extends PreAndPost {

	public LoginPage(ChromeDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement eleUserName;
	public LoginPage typeUserName(String usrName) {
		eleUserName.sendKeys(usrName);
		return this;
	}
	
	@FindAll({@FindBy(id="password"),@FindBy(name = "PASSWORD")})
	private WebElement elePassword;
	public LoginPage typePassword(String pswd) {
		elePassword.sendKeys(pswd);
		return this;
	}
	
	@FindBy(className = "decorativeSubmit")
	private WebElement eleSubmit;
	public HomePage clickLogin() throws InterruptedException {
		eleSubmit.click();
		Thread.sleep(1000);
		return new HomePage(driver);
	}
}
