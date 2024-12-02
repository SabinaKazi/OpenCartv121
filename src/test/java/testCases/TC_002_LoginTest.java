package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginTest extends BaseClass{
	
	
	@Test(groups={"sanity","Master"})
	public void verify_login()
	{
		logger.info("******Starting TC_002_LoginTest*******");
		try {
			
		
		//Homepage
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.EnterEmailAddress(p.getProperty("email"));
		lp.EnterPassword(p.getProperty("password"));
		lp.ClickonLoginButton();
		
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage = macc.ismyAccountPageExists();
		
		//Assert.assertEquals(targetpage, true, "Login failed");
		Assert.assertTrue(targetpage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("******Finished TC_002_LoginTest*******");

	}
	

}
