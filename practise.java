package PAKAGE;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class practise {
	WebDriver d;
	@BeforeMethod
	public void setup() {
		d=new FirefoxDriver();
		d.manage().window().maximize();
d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
	}
	@Test
	public void launch() throws Exception {
		d.get("https://www.tistabene.com/");
		
      while(isElementPresent(d,By.xpath("//div[10]/div/div/a/div/div"))){
    	  
			((RemoteWebDriver)d).executeScript("window.scrollTo(0,100)");
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
	
		}
	public boolean isElementPresent(WebDriver driver ,By locator) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		try {
			driver.findElement(locator);
		return false;
		}
		catch(NoSuchElementException e){
		return true;
		}
	}
	@AfterMethod
	public void close() {
		d.quit();
	}
      
	}
	 
	
	
    
	  
	  
  

 