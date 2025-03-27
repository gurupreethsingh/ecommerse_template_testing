package excel_automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import automation_scripts.AutomationConstants;

public class O2_FetchAllLinksRegisterPage implements AutomationConstants{

	public static void main(String[] args)
	{
		System.out.println("Fetch all links from Login page");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(urlOfRegister);
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		List <WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println("Total links in register page " + allLinks.size());
		
		for ( WebElement eachLink  :allLinks)
		{ 
			String text = eachLink.getText();
			
			 String linkAddress = eachLink.getAttribute("href");
			 
			 System.out.println(text +" " + linkAddress);
			
		}
	}
}
