package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage extends BasePage{
	
	//Constructor
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
//Locator
	
//Firstname
@FindBy(xpath="//input[@id='input-lastname']") 
WebElement firstName_txt;

// Lastname
@FindBy(xpath="//input[@id='input-firstname']")
 WebElement lastName_txt;

// emailid
@FindBy(xpath="//input[@id='input-email']") 
WebElement eMail_txt;

//telephone
@FindBy(xpath="//input[@id='input-telephone']") 
 WebElement txt_telephone;

//password
@FindBy(xpath="//input[@id='input-password']")
WebElement password_txt;

//confrimpassword
@FindBy(xpath="//input[@id='input-confirm']") 
 WebElement passwordConfirm;

//policybtn
@FindBy(xpath="//input[@name='agree']")
WebElement privacypolicy_btn;

//continue
@FindBy(xpath="//input[@value='Continue']") 
WebElement btn_continue;

//messageconfirmation
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") 
WebElement msgConfirmation;


//Action Methods


public void EnterFirstName(String fname)
{
	 firstName_txt.sendKeys(fname);
}

public void EnterLastName(String lname)
{
	lastName_txt.sendKeys(lname);
}

public void EnterEmailId(String email)
{
	eMail_txt.sendKeys(email);
}

public void EnterTelephone(String number)
{
	txt_telephone.sendKeys(number);
}

public void EnterPassword(String pwd)
{
	password_txt.sendKeys(pwd);
}

public void EnterConfrimPassword(String confpwd)
{
	passwordConfirm.sendKeys(confpwd);
}

public void ClickContinueButton()
{
	btn_continue.click();
}

public void PrivacyPolicyButton()
{
	privacypolicy_btn.click();
}

public String getconfirmationmsg()
{
	try {
		return (msgConfirmation.getText());
	}catch (Exception e) {
		return(e.getMessage());
	}
	
}
	
	

}
