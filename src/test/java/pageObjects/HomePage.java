package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class HomePage extends BasePage {
	
	
	//Constructor
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
//Locator

	
@FindBy(xpath="//span[normalize-space()='My Account']") 
WebElement click_myAccount;

@FindBy(xpath="//a[normalize-space()='Register']") 
WebElement btn_register;

@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") 
WebElement Linklogin;


//Action Method


public void ClickMyAccount()
{
	click_myAccount.click();
}

public void ClickRegister()
{
	btn_register.click();
}

public void ClickLogin()
{
	Linklogin.click();
}



}
