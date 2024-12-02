package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	

@FindBy(xpath="//h2[normalize-space()='My Account']") 
WebElement msgHeading;

@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") 
WebElement Link_logout; // added in step 6
	

public boolean ismyAccountPageExists()
{
	try
	{
	return (msgHeading.isDisplayed());
	}
	catch(Exception e)
	{
		return false;
	}
}

public void CLickOnLogout() {
	Link_logout.click();
}



	

}
