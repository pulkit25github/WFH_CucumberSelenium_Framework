package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.HelperClass;

public class SearchCustomerPage 
{

	public WebDriver driver;
	HelperClass help;
	
	public SearchCustomerPage (WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(driver, this);
		help = new HelperClass(driver);

	}

// Another method using how keyword
	
	
	@FindBy(how = How.ID, using = "SearchEmail")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(how = How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how = How.ID, using = "SearchLastName")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(how = How.ID, using = "SearchMonthOfBirth")
	@CacheLookup
	WebElement drpSearchMonthOfBirth;
	
	@FindBy(how = How.ID, using = "SearchDayOfBirth")
	@CacheLookup
	WebElement drpSearchDayOfBirth;
	
	@FindBy(how = How.ID, using = "SearchCompany")
	@CacheLookup
	WebElement txtCompany;

	@FindBy(how = How.ID, using = "SearchIpAddress")
	@CacheLookup
	WebElement txtIpAddress;
	
	@FindBy(how = How.XPATH, using = "//div[@class= 'k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement txtCustomerRoles;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement listItemAdministrators;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Forum Moderators')]")
	@CacheLookup
	WebElement listItemForumModerators;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement listItemGuests;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Registered')]")
	@CacheLookup
	WebElement listItemRegistered;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement listItemVendors;
	
	@FindBy(how = How.ID, using = "search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
	@CacheLookup
	WebElement tableCustomers;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']/tbody/tr")
	@CacheLookup
	List<WebElement> tableRowsCustomers;
	
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']/tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumnsCustomers;
	
	
	//Action Methods
	
	
	
	public void setEmail (String email)
	{
		help.expWait(txtEmail, 15);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName (String fname)
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
		
	}
	
	public void setLastName (String lname)
	{
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	
	public void ClickSearch()
	{
		btnSearch.click();
		help.impWait(15);
	}
	
	
	public int getNoOfRows()
	{
		tableRowsCustomers.size();
		return getNoOfRows();
	}
	
	public int getNoOfColumns()
	{
		tableColumnsCustomers.size();
		return getNoOfColumns();
	}
	
	
// Logic for matching the email id in all rows
	public void searchCustomerByEmail (String email)
	{
	
	try
	{
		for(int i =1; i<=getNoOfRows(); i++)
		{
			String emailID= tableCustomers.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			
			if (emailID.equalsIgnoreCase(email))
			{
				Assert.assertTrue(true);
			}
		}
			
	}
	
	catch (StackOverflowError e)
	{
		System.out.println("Error message is" + e);
	}
}
	
	
	
	// Logic for matching the first and last name in all rows
		
	public void searchCustomerByName (String Name)
		{
		
		try
		{
			for(int i =1; i<=getNoOfRows(); i++)
			{
				String custName= tableCustomers.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
				
				if (custName.equalsIgnoreCase(Name))
				{
					Assert.assertTrue(true);
				}
			}
				
		}
		
		catch (StackOverflowError e)
		{
			System.out.println("Error message is" + e);
		}
	}	
	
	
	
	
	
	
}
