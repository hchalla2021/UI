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

public class TodayDashboard extends Resources{ 
	
	SimpleDateFormat sdf = new SimpleDateFormat("MMddHms");
	SimpleDateFormat sdf1 = new SimpleDateFormat("MMddHms");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    //System.out.println(sdf.format(timestamp));
	 Random randomGenerator = new Random();  
    int PhoneNumner = randomGenerator.nextInt(1000);  
    int EmailID = randomGenerator.nextInt(1000);
  //System.out.println("FirstName_"+ sdf.format(timestamp));
	//System.out.println(sdf.format(timestamp));
    

  public String ChangeOwnerAgent() throws Exception{
        
    	try {
    		
    		// Locating drop down
    		//driver.findElement(By.xpath(".//*[@id='dk_container_agent-dropdown']/a")).click();
    		Keywords.getWebElement("TodayPage.Clickagent").click();
    		   Thread.sleep(1000);
    			// Getting list of options
    			List<WebElement> itemsInDropdown = driver
    					.findElements(By.xpath(".//*[@id='dk_container_agent-dropdown']/div/ul/li//a"));

    			// Getting size of drop downs values available
    			int size = itemsInDropdown.size();
    			System.out.println(size);

    			// Generate a random number with in range
    			int randnMumber = ThreadLocalRandom.current().nextInt(2, size);

    			
    			// Selecting random value
    			itemsInDropdown.get(randnMumber).click();
    			
    			System.out.println(itemsInDropdown.get(randnMumber));
    		
    		Thread.sleep(1000);
    		
    	} catch (Exception e) {
    		
    		return "Failed - unable to do Change Owner Agent ";
    	}
    	return "Pass";
    }
    
 public String TodaypgMatchedEnqCount() throws Exception{
        
    	try {
    		
    		//Matched enquiry
    		
    		 String No_MatchedEnquiry =	driver.findElement(By.xpath(".//*[@class='appointments-container'][5]//*[@id='followup-summary']/strong")).getText();

    		System.out.println("Number of Mathched enquires  are" + No_MatchedEnquiry);
    		
    	} catch (Exception e) {
    		
    		return "Failed - unable to get the Mathched enquiry counts in Today page";
    	}
    	return "Pass";
    }
 
 public String TodaypgAppointmentsCount() throws Exception{
     
 	try {
 		
 		//Appointments
 		
 		 String AppointmentCount =	driver.findElement(By.xpath("//*[@class='appointments-container'][1]//*[@id='appointments-summary']/strong")).getText();

 		System.out.println("Number of Appointment counts  are: "+ AppointmentCount);
 		
  	} catch (Exception e) {
  		
  		return "Failed - unable to get the Appointment counts in Today page";
  	}
  	return "Pass";
    }
 
 public String TodaypgRemindersCount() throws Exception{
     
 	try {
 		
 		//Reminders
 		 String RemainderCount =	driver.findElement(By.xpath("//*[@class='appointments-container'][2]//*[@id='followup-summary']/strong")).getText();

 		System.out.println("Number of remainder counts  are:  "+ RemainderCount);
 		
 	} catch (Exception e) {
 		
 		return "Failed - unable to get the remainders counts in Today page";
 	}
 	return "Pass";
   }
  
}