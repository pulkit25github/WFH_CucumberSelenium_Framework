package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	WebDriver driver;
	
	public LoginPage (WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id = "Email")
	@CacheLookup
	WebElement username;
	
	@FindBy (id = "Password")
	@CacheLookup
	WebElement password;
	
	@FindBy (xpath = "//button[contains(text(),'Log in')]")
	@CacheLookup
	WebElement login;
	
	@FindBy (xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement logout;
	
	
	//Action methods
	public void setUsername (String user)
	{
		username.clear();
		username.sendKeys(user);
	}
	
	public void setPassword (String pwd)
	{
	password.clear();
	password.sendKeys(pwd);
	}
	
	public void loginButton ()
	{
		login.click();
	}
	
	public void logoutButton()
	{
		logout.click();
	}
	
}
