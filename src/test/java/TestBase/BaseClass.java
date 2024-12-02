package TestBase;

import java.io.FileReader;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import org.apache.logging.log4j.LogManager;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger; //log4j
	
	@BeforeClass(groups= {"sanity","Regression","Master"})//datadriven
	@Parameters({"os","browser"}) 
	public void Setup(String os, String br) 
	{
		
		//Loading config.properties file
		FileReader file=new FileReader(".src//test//resources//config.properties");
		p.new Properties();
		p.load(file);
		
		logger= LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) {
		case "Chrome": driver=new ChromeDriver();
		break;
		
		case "edge": driver=new EdgeDriver();
		break;
		
		case "Firefox": driver=new FirefoxDriver();
		break;
		
		default : System.out.println("Invalid browser name..."); return; // reutnr means totally exit from execution 
				// i
		
		
		}
		
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL2"));//reading url from properties file
		driver.manage().window().maximize();
		
		
	
		
	}
	
	
	@AfterClass(groups= {"sanity","Regression","Master"})
	public void Teardown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomAlphaNumeric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return (generatedstring+"@"+generatednumber);
	}

}
