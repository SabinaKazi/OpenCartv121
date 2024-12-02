package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	
	}
	
	//Locator
	

@FindBy(xpath="//input[@id='input-email']")
WebElement txt_eMailAddress;

@FindBy(xpath="//input[@id='input-password']") 
WebElement txt_password;

@FindBy(xpath="//input[@value='Login']") 
WebElement btn_login;

//ActionMethod

public void EnterEmailAddress(String email) 
{
	txt_eMailAddress.sendKeys(email);
}

public void EnterPassword(String pwd)
{
	txt_password.sendKeys(pwd);
}

public void ClickonLoginButton()
{
	btn_login.click();
}


	
	

}
