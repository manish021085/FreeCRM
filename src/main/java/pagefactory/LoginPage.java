package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import helper.Helpers;

public class LoginPage extends Base {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// page factory : @FindBy() annotation
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(text),'Sign Up']")
	WebElement signupbtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmlogo;
	
	// action of verify the features
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}

		public boolean validateCRMLogoImage() {
			return crmlogo.isDisplayed();
		}
		public WebElement userName(){
			return username;
			
		}
		public WebElement passWord(){
			return password;
		}
		public WebElement logInBtn(){
			return loginbtn;
		}
		
		
		
		public void login(String un, String pwd) {
			username.sendKeys(un);
			password.sendKeys(pwd);
			Helpers.clickByJS(loginbtn);
			
			// after login return new homepage
			//return new HomePage();
	    }

 }
	