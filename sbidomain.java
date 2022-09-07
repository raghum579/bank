package PAKAGE;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import dev.failsafe.internal.util.Assert;

public class sbidomain {
	WebDriver d;
	@BeforeMethod
	public void setup(){
		d = new ChromeDriver();
		d.manage().window().maximize();
			}
@Test
public void launch() throws Exception {

	d.get("https://retail.onlinesbi.com/retail/login.htm");
	System.out.println(d.getTitle());
	assertEquals(d.getTitle(),"State Bank of India - Personal Banking");
	assertTrue(d.findElement(By.xpath("//div[3]")).isDisplayed());
	Thread.sleep(3000);
	/*d.findElement(By.xpath("//a/img")).click();
	ArrayList<String> hs = new ArrayList<String>(d.getWindowHandles());
	System.out.println(hs);
	Thread.sleep(3000);
	d.switchTo().window(hs.get(0));
	Thread.sleep(3000);
	d.switchTo().window(hs.get(1));
	Thread.sleep(3000);
	d.close();
	Thread.sleep(3000);*/
	 d.findElement(By.linkText("CONTINUE TO LOGIN")).click();
	 
		Thread.sleep(2000);
	d.findElement(By.xpath("//div[3]/div/div/div[2]/ul/li/a")).click();
	Alert al = d.switchTo().alert();
	al.accept();
	ArrayList<String> hs = new ArrayList<String>(d.getWindowHandles());
	System.out.println(hs);
	Thread.sleep(3000);
	d.close();
	Select dd = new Select(d.findElement(By.name("issueCode")));
	dd.selectByVisibleText("Activation Of Username");
	Thread.sleep(5000);

	
}
@AfterMethod
public void close() {
	d.quit();
}

}
