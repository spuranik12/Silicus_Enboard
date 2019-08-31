package automation.enboard.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



//import testlink.api.java.client.TestLinkAPIResults;
import automation.enboard.common.BaseTest;
import automation.enboard.pages.LoginPage;

public class LoginPageTest extends BaseTest{
	LoginPage loginPage;
	@BeforeClass
	public void LoginPage(){
		parent = report.startTest("Login Page","Login Page Test");
	}
	/*@Test
	public void loginTest() throws InterruptedException{
		//Arrangement
		//testCaseName = "Validate login credentials";
		child = report.startTest("Verify Login functaionlity with valid credentials");
		parent.appendChild(child);
		loginPage = new LoginPage(eventDriver, handler);
		//Act
		loginPage.login(properties.getProperty("username"), properties.getProperty("password"),child);
		
		//Assert
		Assert.assertTrue(loginPage.isUserLoggedIn());
		//testlink.setResult(TestLinkAPIResults.TEST_PASSED);
	}*/
	
	@Test
	public void loginTest() throws InterruptedException{
		
		child = report.startTest("Verify Login functionality with valid credentials for WM Application");
		parent.appendChild(child);
		
		loginPage = new LoginPage(eventDriver, handler);
		
		loginPage.loginIntoWmSite(properties.getProperty("wm_username"), properties.getProperty("wm_password"), child);
		
		Assert.assertTrue(loginPage.isWmUserLoggedIn(), properties.getProperty("wm_login_user"));
	}
}
