package PAKAGE;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class practise2 {
	
	WebDriver d;
	@BeforeMethod 
	public void setup() {
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void launch() throws Exception {
		try {
			d.get("https://jqueryui.com/droppable/");
			Actions a = new Actions(d);
			d.switchTo().frame(0);
			a.dragAndDrop(d.findElement(By.id("draggable")),d.findElement(By.id("droppable"))).perform();
			Thread.sleep(3000);
		}
		catch (Exception e) {
			DateFormat sdf = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
			   Date dt = new Date();
			   File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
				  FileUtils.copyFile(screenshotFile,new File("B:\\selenium_java\\java project\\screenshots\\"+sdf.format(dt)+".png"));
				  Assert.fail();
				  
		}
	}
@AfterMethod
public void close() {
	 d.quit();
}
	
}
