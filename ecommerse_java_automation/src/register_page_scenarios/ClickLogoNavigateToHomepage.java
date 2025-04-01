package register_page_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import automation_scripts.AutomationConstants;

public class ClickLogoNavigateToHomepage implements AutomationConstants
{

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null; 
		try
		{
			System.out.println("Go to login click on logo");
			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			
			driver.get(urlOfRegister);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			System.out.println(driver.getTitle());
			
			System.out.println(driver.getCurrentUrl());
			
			WebElement logo = driver.findElement(By.xpath("//a[text()='LOGO']"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			logo.click();
			
			System.out.println("Actual title :" + driver.getTitle());
			System.out.println("Actual url :" + driver.getCurrentUrl());
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			Thread.sleep(3000);
			driver.quit();
		}

	}

}
