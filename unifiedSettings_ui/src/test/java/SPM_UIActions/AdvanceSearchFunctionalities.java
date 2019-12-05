package SPM_UIActions;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SPM_Keywords.Keywords;
import Utilities.Resources;


public class AdvanceSearchFunctionalities extends Resources {


	SimpleDateFormat sdf = new SimpleDateFormat("MMddHms");
	SimpleDateFormat sdf1 = new SimpleDateFormat("MMddHms");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    //System.out.println(sdf.format(timestamp));
	 Random randomGenerator = new Random();  
    int PhoneNumner = randomGenerator.nextInt(1000);  
    int EmailID = randomGenerator.nextInt(1000);
    
    public String AdvancedSearchEnterName() throws Exception{
		try {
			Thread.sleep(3000);
			System.out.println("Entering the Name in Advanced Search for prospect");
			driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("RealPageTest");
		} catch (Exception e) {
			return "Failed - unable to find name object";
		}
		return "Pass";
	}
    public String ClickOnShowResults() throws Exception{
		try {
			
			System.out.println("Select Action type");
			driver.findElement(By.xpath(".//*[@id='btnShowResults']")).click();
			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//Thread.sleep(10000);
		} catch (Exception e) {
			
			return "Failed - unable to find Wishtolog object";
		}
		return "Pass";
    }
	
    public String ClicKExporToPDF() throws Exception{
		try {
			//Thread.sleep(3000);
			System.out.println("Entering the Name in Advanced Search for prospect");
			//driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("RealPageTest");
			WebElement element = driver.findElement(By.xpath(".//*[@id='settings-menu']/li[6]/a"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			return "Failed - unable to find name object";
		}
		return "Pass";
	}
    
    public String ClickLogactionBtn() throws Exception{
		try {
			//Thread.sleep(3000);
			System.out.println("Click On Log action Button");
			//driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("RealPageTest");
			WebElement element = driver.findElement(By.xpath(".//*[@id='settings-menu']/li[3]/a"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			return "Failed - unable to find name object";
		}
		return "Pass";
	}
	
    public String ClickOnAnActionYouWishToLog() throws Exception{
		try {
			//Thread.sleep(3000);
			System.out.println("Click On An Action You WishToLog");
			//driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("RealPageTest");
			WebElement element = driver.findElement(By.xpath(".//*[@id='dk_container_select-action']/a"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			return "Failed - unable to find Wishtolog object";
		}
		return "Pass";

    }
    
    public String SelectActiontype() throws Exception{
		try {
			//Thread.sleep(3000);
			System.out.println("Select Action type");
			//driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("RealPageTest");
			WebElement element = driver.findElement(By.xpath(".//*[@id='dk_container_select-action']/div/ul/li[4]/a"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			return "Failed - unable to find Wishtolog object";
		}
		return "Pass";
    }
    public String ClickAgentDD() throws Exception{
  		try {
  			//Thread.sleep(3000);
  			System.out.println("Select Action type");
  			//driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("RealPageTest");
  			WebElement element = driver.findElement(By.xpath(".//*[@id='dk_container_ActiveAgentId1']/a"));
  			JavascriptExecutor executor = (JavascriptExecutor)driver;
  			executor.executeScript("arguments[0].click();", element);
  		} catch (Exception e) {
  			return "Failed - unable to find Wishtolog object";
  		}
  		return "Pass";
      }
    public String SelectAgentName() throws Exception{
  		try {
  			//Thread.sleep(3000);
  			System.out.println("Select Action type");
  			//driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("RealPageTest");
  			WebElement element = driver.findElement(By.xpath(".//*[@id='dk_container_ActiveAgentId1']/div/ul/li[4]/a"));
  			JavascriptExecutor executor = (JavascriptExecutor)driver;
  			executor.executeScript("arguments[0].click();", element);
  		} catch (Exception e) {
  			return "Failed - unable to find Wishtolog object";
  		}
  		return "Pass";
      }
   
}

