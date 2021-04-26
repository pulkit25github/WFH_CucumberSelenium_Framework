package pageObjects;

import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerScreen 
{

	WebDriver driver;
	public AddCustomerScreen (WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(driver, this);
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
	
	
	@FindBy(xpath = "//a[@href= '#']//p[contains(text(), 'Customers')]")
	@CacheLookup
	WebElement custMenu;
	
	@FindBy(xpath = "(//p[contains(text(), 'Customers')])[2]")
	@CacheLookup
	WebElement custSubMenu;
	
	@FindBy(xpath = "//h1[contains(text(),'Customers')]")
	@CacheLookup
	WebElement custPageTitle;
	
	@FindBy(xpath = "//a[@class= 'btn btn-primary']")
	@CacheLookup
	WebElement custAddButton;
	
	@FindBy(xpath = "//h1[contains(text(), 'Add a new customer')]")
	@CacheLookup
	WebElement AddNewCustPageTitle;
	
// Another method for locators	
	
	By addEmail = By.id("Email");
	
	By addPassword = By.id("Password");
	
	By addFirstName = By.id("FirstName");
	
	By addLastName = By.id("LastName");
	
	By addGenderMale = By.id("Gender_Male");
	
	By addGenderFemale = By.id("Gender_Female");
	
	By addDob = By.id("DateOfBirth");
	
	By addCompany = By.id("Company");
	
	By addNewsLetter = By.xpath("(//*[@class = 'k-multiselect-wrap k-floatwrap'])[1]");
	
	By addYourStoreNewsLetter = By.xpath("//li[contains(text(), 'Your store name')]");

	By addTestStoreNewsLetter = By.xpath("//li[contains(text(), 'Test store 2')]");

	By addCustomerRoles = By.xpath("(//*[@class = 'k-multiselect-wrap k-floatwrap'])[2]");
	
	By addAdminRoles = By.xpath("//li[contains(text(),'Administrators')]");
	By addModeratorRoles = By.xpath("//li[contains(text(),'Forum Moderators')]");
	By addGuestRoles = By.xpath("//li[contains(text(),'Guests')]");
	By addRegisteredRoles = By.xpath("//li[contains(text(),'Registered')]");
	By addVendorsRoles = By.xpath("//li[contains(text(),'Vendors')]");
	
	
	By addVendor = By.xpath("//select[@id='VendorId']");
	
	By addAdminComment = By.id("AdminComment");
	
	By addSaveButton = By.name("save");
	
//	By addSuccessMsg = By.xpath("//div[@class= 'alert alert-success alert-dismissable']");
	
	
	
//++++++++++++++Action Methods+++++++++++++++++

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
	
	
	
	public void verifyCustMenu()
	{
		if (custMenu.isDisplayed())
		{
			custMenu.click();
			Assert.assertTrue(true);	
		}
		else
		{
			System.out.println("Customers menu option is not available");
			Assert.assertTrue(false);
		}  
			
	}
	
	
	
	public void verifyCustSubMenu()
	{
		if (custSubMenu.isDisplayed())
		{
			custSubMenu.click();
			Assert.assertTrue(true);	
		}
		else
		{
			System.out.println("Customers Sub menu option is not available");
			Assert.assertTrue(false);
		}
		
	}
	
	
	public void verifyAddCustPageTitle(String pageTitle)
	{
		if (custPageTitle.isDisplayed())
		{
			Assert.assertTrue(true);	
		}
		else
		{
			System.out.println("Customers Page Title is not available");
			Assert.assertTrue(false);
		}
		
	}
	
	
	public void verifyAddCustAddButton()
	{
		if (custAddButton.isDisplayed() && custAddButton.isEnabled())
		{
			custAddButton.click();
			Assert.assertTrue(true);	
		}
		else
		{
			System.out.println("Add button on Customers Page is not available");
			Assert.assertTrue(false);
		}
		
	}
	
	
	
	public void verifyAddNewCustPageTitle(String newCustTitle)
	{
		if (AddNewCustPageTitle.isDisplayed())
		{
			Assert.assertTrue(true);	
		}
		else
		{
			System.out.println("Add a new Customer Title is not available");
			Assert.assertTrue(false);
		}
	}
	
// By class methods
	public void addNewEmail(String addNewEmail)
	{
		driver.findElement(addEmail).sendKeys(addNewEmail);
	}
	
	public void addNewPwd(String addNewPwd)
	{
		driver.findElement(addPassword).sendKeys(addNewPwd);
	}
	
	public void addFname(String addFname)
	{
		driver.findElement(addFirstName).sendKeys(addFname);
	}
	
	public void addLname(String addLname)
	{
		driver.findElement(addLastName).sendKeys(addLname);
	}
	
	public void addGender(String gender)
	{
		if(gender.equals("Male"))
		{
		driver.findElement(addGenderMale).click();
		}
		else if  (gender.equals("Female"))
		{
			driver.findElement(addGenderFemale).click();
		}
		else
		{
			driver.findElement(addGenderMale).click();  // default
		}
	}		
	
	public void addNewDob(String addNewDob)
	{
		driver.findElement(addDob).sendKeys(addNewDob);
	}
	
	public void addNewCompany(String addNewCompany)
	{
		driver.findElement(addCompany).sendKeys(addNewCompany);
	}
	
	public void addNewsLet(String letter) throws Exception
	{
	//	Select nl = new Select(driver.findElement(addNewsLetter));
	//	nl.selectByVisibleText(value);
		
	driver.findElement(addNewsLetter).click();
	Thread.sleep(3000);
	if(letter.contains("Your store name"))
	{
	driver.findElement(addYourStoreNewsLetter).click();
	}
	else
	{
		driver.findElement(addTestStoreNewsLetter).click();
	}	
}
	
	public void addRoles(String role) throws Exception
	{
		// Deleting the existing value
		driver.findElement(By.xpath("(//span[@aria-label = 'delete'])[2]")).click();
		
		driver.findElement(addCustomerRoles).click();
		Thread.sleep(3000);
		
		if (role.contains("Administrators"))
		{
		driver.findElement(addAdminRoles).click();
		} 
		else if (role.contains("Forum Moderators"))
		{
			driver.findElement(addModeratorRoles).click();
		}
		else if (role.contains("Guests"))
		{
			driver.findElement(addGuestRoles).click();
		}
		else if (role.contains("Registered"))
		{
			driver.findElement(addRegisteredRoles).click();
		}
		else if (role.contains("Vendors"))
		{
			driver.findElement(addVendorsRoles).click();
		}
		else
		{
			System.out.println("Invalid role- Please check");
		}
		
	}
	
	public void addMgrVendor(String value)
	{
	
		Select ven = new Select(driver.findElement(addVendor));
		ven.selectByVisibleText(value);
	}
	
	public void addComments(String comments)
	{
		driver.findElement(addAdminComment).sendKeys(comments);
	}
	
	public void addSaveButtonClick() throws Exception
	{
		driver.findElement(addSaveButton).click();
		Thread.sleep(5000);
	}
	
	
	
}
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	

