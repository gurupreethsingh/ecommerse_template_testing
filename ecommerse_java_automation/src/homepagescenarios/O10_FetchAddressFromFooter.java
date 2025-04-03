package homepagescenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation_scripts.AutomationConstants;
import screenshots.TakeScreenshot;

public class O10_FetchAddressFromFooter implements AutomationConstants {
	public static void main(String[] args) throws Exception {
		WebDriver driver = null;
		try {
			// open browser.
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// open homepage
			driver.get(urlOfHomepage);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, document.body.scrollHeight)");
			Thread.sleep(1000);
			
			// find address.
			 WebElement addressText = driver.findElement(By.xpath("(//p)[2]/br"));
			 JavascriptExecutor js = (JavascriptExecutor) driver;
	          Thread.sleep(1000);
	          js.executeScript("arguments[0].scrollIntoView(true)",    addressText );
	          Thread.sleep(1000);
	          //find the shop link. 

	          int paranumber=1;
	          for(int i = 2; i<= 3; i++)
	          {
	        	 
	        	 String AddressectionTexts =  driver.findElement(By.xpath("(//p)["+i+"]")).getText();
	        	 System.out.println(paranumber +" :: " + AddressectionTexts);
	        	 paranumber++;
	        	 System.out.println("\n*******************************************************\n");
	        	 Thread.sleep(500);
	          }
		
			
		}
			catch (Exception ex) 
			{
				// Clean handling — no stack trace
				System.out.println("Test failed: Expected title did not match. Screenshot captured.");
				TakeScreenshot.getScreenshot(driver);
				System.out.println("Testcase failed screenshot stored.");
			} 
			finally 
			{
				driver.quit();
			}
		
	}
}

	

	
