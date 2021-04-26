package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;
import pageObjects.AddCustomerScreen;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass 
{

	public WebDriver driver;
	public SearchCustomerPage scp;
	public AddCustomerScreen ac;
	public LoginPage lp;
	public static Logger logger;
	public Properties prop;
	

// Method created for generating random email id
	public static String RandomString()
	{
		String emailGen = RandomStringUtils.randomAlphanumeric(8);
		return emailGen;
	}
	
}
