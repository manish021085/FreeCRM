package testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pagefactory.LoginPage;

public class LoginPageTest extends Base {
	LoginPage lp;
	
	@BeforeMethod
	public void launchURL() throws IOException {
		initializationDriver();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		/*String title = driver.getTitle();
		System.out.println("Title of the page :--> "+title);*/
		lp=new LoginPage();
		String title = lp.validateLoginPageTitle();
		System.out.println("Title of the page :--> "+title);
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		lp=new LoginPage();
		boolean flag = lp.validateCRMLogoImage();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	

}
