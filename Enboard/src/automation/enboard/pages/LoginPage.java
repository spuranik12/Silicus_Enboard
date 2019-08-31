package automation.enboard.pages;

import org.apache.poi.poifs.property.Child;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import automation.enboard.common.AutoLogger;
import automation.enboard.common.BasePage;

public class LoginPage extends BasePage {
	
	@FindBy(css = "#Email")
	WebElement email;
	
	@FindBy(css = "#Password")
	WebElement password;
	
	@FindBy(css = "button[class='btn btn-lg btn-info waves-effect waves-light m-t-10']")
	WebElement loginBtn;
	
	@FindBy(id = "dropdownMenu1")
	WebElement loggedInUser;
	
	@FindBy(id = "UserName")
	WebElement wmUsernameField;
	
	@FindBy(id = "btnLogin")
	WebElement wmSignInBtn;
	
	@FindBy(id = "btnSubmit")
	WebElement wmLoginBtn;
	
	@FindBy(css = "strong")
	WebElement wmLoggedInUser;
	
	public LoginPage(WebDriver driver, AutoLogger handler){
		super(driver);
		PageFactory.initElements(driver, this);
		super.handler = handler;
		handler.setCurrentPageClass(this.getClass());
	}
	
	public void login(String username, String password,ExtentTest child) throws InterruptedException{
		actions.sendKeys(this.email, username);
		Thread.sleep(1000);
		Reporter.log("Step 1: UserName enterd:"+username);
		child.log(LogStatus.INFO,"Step 1: UserName enterd:"+username);
		actions.sendKeys(this.password, password);
		Thread.sleep(1000);
		Reporter.log("Step 1: Password enterd:"+password);
		child.log(LogStatus.INFO,"Step 2 : Password enterd:"+password);
		loginBtn.click();
		child.log(LogStatus.INFO,"Step 3 :clicked on Login Button ");
		Thread.sleep(2000);
	}
	
	public boolean isUserLoggedIn() throws InterruptedException{
		Thread.sleep(3000);
		return actions.isDisplayed(loggedInUser);
	}
	
	public void loginIntoWmSite(String wm_uname, String wm_pwd, ExtentTest child) throws InterruptedException{
		actions.sendKeys(this.wmUsernameField, wm_uname);
		Thread.sleep(1000);
		Reporter.log("Step 1: UserName entered: "+wm_uname);
		child.log(LogStatus.INFO, "Step 1: UserName entered: "+wm_uname);
		wmSignInBtn.click();
		child.log(LogStatus.INFO,"Step 2 :Clicked on SignIn Button ");
		Thread.sleep(2000);
		actions.sendKeys(this.password, wm_pwd);
		Thread.sleep(1000);
		Reporter.log("Step 1: Password enterd:"+wm_pwd);
		child.log(LogStatus.INFO,"Step 3 : Password enterd:"+wm_pwd);
		wmLoginBtn.click();
		child.log(LogStatus.INFO,"Step 4 :Clicked on SignIn Button ");
		Thread.sleep(2000);
	}
	
	public boolean isWmUserLoggedIn() throws InterruptedException{
		Thread.sleep(3000);
		return actions.isDisplayed(wmLoggedInUser);
	}
}
