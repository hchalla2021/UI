/*package SPM_UIActions;
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
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import SPM_Keywords.Keywords;
	import Utilities.Resources;

	public class TakeACall extends Resources{ 
		
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHms");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MMddHms");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    //System.out.println(sdf.format(timestamp));
		 Random randomGenerator = new Random();  
	    int PhoneNumner = randomGenerator.nextInt(1000);  
	    int EmailID = randomGenerator.nextInt(1000);
	  //System.out.println("FirstName_"+ sdf.format(timestamp));
		//System.out.println(sdf.format(timestamp));
		
		public String OpenGmailTab() throws Exception{
				try {
					//Thread.sleep(3000);
					System.out.println("Entering the First Name");
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
					driver.findElement(By.linkText("http://www.gmail.com")).sendKeys(selectLinkOpeninNewTab);
				} catch (Exception e) {
					return "Failed - unable to find first name object";
				}
				return "Pass";
			}
			
	}*/