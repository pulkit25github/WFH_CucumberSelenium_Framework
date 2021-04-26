package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass 
{

	public WebDriver driver;
	
	public HelperClass (WebDriver rdriver)
	{
	
		this.driver =rdriver;
	}
	
	public void expWait (WebElement ele, long timeInSECONDS)
	{
		WebDriverWait wb = new WebDriverWait(driver, timeInSECONDS);
		wb.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void impWait (long timeInSECONDS)
	{
		driver.manage().timeouts().implicitlyWait(timeInSECONDS, TimeUnit.SECONDS);
	}
	
}
