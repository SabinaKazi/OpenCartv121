package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
// organize import..unnecesaary imports will remove
public class TC_001_AccountRegistrationTest extends BaseClass {

	
	@Test(groups={"regression","Master"})
	public void Verify_Account_Registration()
	{
		
		logger.info("***** starting TC001 AccountRegistrationTest *****");
		
		try {
		HomePage hp= new HomePage(driver);
		
		hp.ClickMyAccount();
		logger.info(" Clicked on My Account Link");
		
		hp.ClickRegister();
		logger.info(" Clicked Register Link");
		
		hp.ClickLogin();
		logger.info(" Clicked Login Link");
		
		AccountRegistrationPage accreg=new AccountRegistrationPage(driver);
		/*
		accreg.EnterFirstName("ruzina");
		accreg.EnterLastName("shaikh");
		accreg.EnterEmailId("zxcv123@gmail.com");
		accreg.EnterPassword("zxcv@123");
		accreg.PrivacyPolicyButton();
		accreg.ClickContinueButton();
		*/
		
		logger.info(" Providing Customer Details");
		accreg.EnterFirstName(randomString().toUpperCase());
		accreg.EnterLastName(randomString().toUpperCase());
		accreg.EnterEmailId(randomString()+"@gmail.com");
		accreg.EnterTelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		accreg.EnterPassword(password);
		accreg.EnterConfrimPassword(password);
		accreg.PrivacyPolicyButton();
		accreg.ClickContinueButton();
		
		logger.info(" Validating Expected message");
		String confmsg = accreg.getconfirmationmsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test failed....");
			logger.debug("Debug logs.....");
			Assert.fail();
		}
		
		logger.info("***** Finishing TC001 AccountRegistrationTest *****");
	}
	
	
	
	

}
