package testcases;

import org.testng.annotations.Test;

import base.PreAndPost;
import pages.LoginPage;

public class TC001Login extends PreAndPost {

	@Test(dataProvider="setData")
	public void login(String usrName, String pswd) throws InterruptedException {	
		new LoginPage(driver)
		.typeUserName(usrName)
		.typePassword(pswd)
		.clickLogin();
	}
}
