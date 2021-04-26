package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.*;




public class Steps extends BaseClass
{
    @Before 
	public void setup () throws Exception 
	{
    	prop = new Properties();
    	FileInputStream propFile = new FileInputStream("config.properties");     // File location
    	prop.load(propFile);
    	
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
    	String br = prop.getProperty("browser");
    	
    	if (br.equals("chrome"))
    	{
    	System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
        driver= new ChromeDriver();
    	}
    	else if (br.equals("firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxpath"));
            driver= new FirefoxDriver();
    	}
    	else if (br.equals("ie"))
    	{
    		System.setProperty("webdriver.ie.driver", prop.getProperty("iepath"));
            driver= new InternetExplorerDriver();
    	}
    	else
    	{
    	
    		logger.info("Check your browser");
    	}
 
    	
    	
		logger = Logger.getLogger("nopCommerce");          // Added logger
		PropertyConfigurator.configure("log4j.properties");
		
	}
	
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() 
	{ 
        logger.info("*****Launching the browser*****");   
      	
		lp= new LoginPage(driver);
		  
	}

	@When("user open url {string}")
	public void user_open_url(String url) 
	{
		logger.info("*****Opening the URL*****");
		
        driver.get(url);
        driver.manage().window().maximize();
    
	}

	@When("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws Exception
	{
		logger.info("*****Entering email and password*****");
		
		Thread.sleep(5000);
		lp.setUsername(email);
        lp.setPassword(password);
       
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() 
	{
		logger.info("*****Clicking on login*****");
          lp.loginButton();

	}

	@Then("user will land on nopcommerce homescreen and title should be {string}")
	public void user_will_land_on_nopcommerce_homescreen_and_title_should_be(String homeTitle)
	{
         if(driver.getPageSource().contains("Unsuccesful"))
         {
        	 Assert.assertTrue(false);
        	 logger.info("*****Login Failed*****");
         }
         else
         {
        	Assert.assertEquals(homeTitle, driver.getTitle());
        	logger.info("*****Login Successful*****");
         }
       
     WebDriverWait wait = new WebDriverWait(driver, 30);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Logout')]")));
     
      
	}

	@When("user clicks on logout button")
	public void user_clicks_on_logout_button() throws Exception 
	{
		logger.info("*****Clicking on logout*****");
		lp.logoutButton();
		Thread.sleep(8000);
	}

	@Then("title should be {string}")
	public void title_should_be(String loginTitle) 
	{
		if(driver.getPageSource().contains("Your store. Login"))
        {
			Assert.assertEquals(loginTitle, driver.getTitle());

        }
        else
        {
        	System.out.println("Unable to Logout");
        	 Assert.assertTrue(false);
        }

	}

	@Then("close the browser")
	public void close_the_browser()
	{
	 driver.close();
	}
	
	//Add customer feature stepDefinitions
	
		@Then("user click on customer link")
		public void user_click_on_customer_link() throws Exception
		{
			
			ac= new AddCustomerScreen(driver);
			
			Thread.sleep(8000);
			ac.verifyCustMenu();
			
		}


		@Then("user will see customers link as sub menu option and user click on customers sub menu link")
		public void user_will_see_customers_link_as_sub_menu_option() throws Exception
		{
		    ac.verifyCustSubMenu();
		    Thread.sleep(8000);
		}

		

		@Then("user land on Customers Screen and page title should be {string}")
		public void user_land_on_customers_screen_and_page_title_should_be(String pageTit)
		{
		    ac.verifyAddCustPageTitle(pageTit);
			
			
		}

		@Then("user able to see Add button on customers screen and user clicks on Add button")
		public void user_able_to_see_add_button_on_customers_screen() throws Exception 
		{
		    	
			ac.verifyAddCustAddButton();
			Thread.sleep(8000);
		}

		

		@Then("user will land on Add customer screen and title should be {string}")
		public void user_will_land_on_add_customer_screen_and_title_should_be(String newCustTit)
		{
		   ac.verifyAddNewCustPageTitle(newCustTit);
		}
		
		@When("user enter details and information")
		public void user_enter_details_and_information() throws Exception
		{
			logger.info("*****Adding new customer details*****");
			
			String email = RandomString()+ "@gmail.com";
			ac.addNewEmail(email);
			ac.addNewPwd("123456");
			ac.addFname("Pulkit");
			ac.addLname("Rudra");
			ac.addGender("Male");
			ac.addNewDob("10/25/1990");
			ac.addNewCompany("Tech Mahindra");
			ac.addNewsLet("Your store name");
			ac.addRoles("Registered");
		//	ac.addMgrVendor("Vendor 1");
			ac.addComments("Testing purpose");
			
			
		}
		
		@When ("Click on save")
		public void Click_on_save() throws Exception
		{
			logger.info("*****Saving customer data*****");
			
			ac.addSaveButtonClick();
			Thread.sleep(5000);
			
		}
		
		@Then("user will get the messsage {string}")
		public void user_will_get_the_messsage(String succMsg) throws Exception
		{
			
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
			
		logger.info("*****Saved customer data*****");
		   
		}	
	

// Steps for searching customer with Email Id
		
		@Then("enter customer email")
		public void enter_customer_email() 
		{
		    
			scp = new SearchCustomerPage(driver);
			
			scp.setEmail("victoria_victoria@nopCommerce.com");		
			
			logger.info("*****Searching results with email*****");
		}

		@When("click on search button")
		public void click_on_search_button() throws Exception 
		{
			 scp.ClickSearch();
			 Thread.sleep(5000);
		}
		
		@Then("user able to get details of customer from email")
		public void user_able_to_get_details_of_customer_from_email()
        {
		   scp.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		    
		}
		
// Steps for search customer with first and last name 

		@Then("enter customer firstname")
		public void enter_customer_firstname() throws Exception 
		{
			scp = new SearchCustomerPage(driver);
			Thread.sleep(4000);
			scp.setFirstName("Pulkit");
		}


			@Then("enter customer lastname")
		public void enter_customer_lastname() 
		{
			scp.setLastName("Rudra");
		}
			
		@Then("user able to get details of customer from first and last name.")
		public void user_able_to_get_details_of_customer_from_first_and_last_name()
		{
			scp.searchCustomerByName("Pulkit Rudra");
			
			logger.info("*****Searching results with Name*****");
		}



		
}
