package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDTest extends BaseClass {
	
	@Test(Dataprovider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven") //getting data provider from different class
	public void verify_LoginDDT(String email, String pwd, String exp)
	{
		
		logger.info("******Starting TC_003_LoginDDTest*******");
		try {
		       //Homepage
				HomePage hp=new HomePage(driver);
				hp.ClickMyAccount();
				hp.ClickLogin();
				
				//LoginPage
				LoginPage lp=new LoginPage(driver);
				lp.EnterEmailAddress();
				lp.EnterPassword();
				lp.ClickonLoginButton();
				
				//MyAccount
				MyAccountPage macc=new MyAccountPage(driver);
				boolean targetpage = macc.ismyAccountPageExists();
				
				//validation
				if(exp.equalsIgnoreCase("Valid"))
				{
					if(targetpage==true)
					{
						macc.CLickOnLogout();
						Assert.assertTrue(true);
						
					}
					else
					{
							Assert.assertTrue(false);
					}
					
				}
				
				if(exp.equalsIgnoreCase("invalid"))
				{
					if(targetpage==true)
					{
						macc.CLickOnLogout();
						Assert.assertTrue(false);
						
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
				
				catch(Exception e)
				{
					Assert.fail();
				}
				logger.info("******Finished TC_003_LoginDDTest*******");
				
	}

}
