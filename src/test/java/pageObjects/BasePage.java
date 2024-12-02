package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
     public WebDriver driver;
	
	//Constructor
	
	BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}

}
