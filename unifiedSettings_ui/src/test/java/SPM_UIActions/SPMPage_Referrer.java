
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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Resources;


public class SPMPage_Referrer extends Resources{ 
	
	SimpleDateFormat sdf = new SimpleDateFormat("MMddHms");
	SimpleDateFormat sdf1 = new SimpleDateFormat("MMddHms");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    //System.out.println(sdf.format(timestamp));
	 Random randomGenerator = new Random();  
    int PhoneNumner = randomGenerator.nextInt(1000);  
    int EmailID = randomGenerator.nextInt(1000);
  //System.out.println("FirstName_"+ sdf.format(timestamp));
	//System.out.println(sdf.format(timestamp));
    

    public String EnterRefFirstName() throws Exception{
		try {
			//Thread.sleep(3000);
			System.out.println("Entering the First Name");
			driver.findElement(By.xpath(".//*[@id='txtFirstName0']")).sendKeys("RealPageTest");
		} catch (Exception e) {
			return "Failed - unable to find first name object";
		}
		return "Pass";
	}
	public String EnterRefLasttName() throws Exception{
		try {
			//Thread.sleep(3000);
			System.out.println("Entering the Last Name");
			
			//driver.findElement(By.xpath(".//*[@id='txtLastName']")).sendKeys(TestData+sd.format(timestamp));
			driver.findElement(By.xpath(".//*[@id='txtlastName0']")).sendKeys(sdf1.format(timestamp));
		} catch (Exception e) {
			return "Failed - unable to find Last name object";
		}
		return "Pass";
	}
	public String EnterRefCallBackNumber() throws Exception{
		try {
			
			System.out.println("Entering the Call Back Number");

			driver.findElement(By.xpath(".//*[@id='txtPhone 0']")).sendKeys("124-144"+"-"+ PhoneNumner +"x4414");
			
		} catch (Exception e) {
			return "Failed - unable to find Phone number object";
		}
		return "Pass";
	}
	
	public String EnterRefEmailID() throws Exception{
		try {
			//Thread.sleep(3000);
			System.out.println("Entering the Email ID");

			driver.findElement(By.xpath(".//*[@id='txtEmail']")).sendKeys("Email"+ EmailID +"@ReaTest.com");
			
		} catch (Exception e) {
			return "Failed - unable to find Last name object";
		}
		return "Pass";
	}
    
	public String RefUploadDocument() throws Exception{
	try {
			System.out.println("clicking on attachment icon");
			driver.findElement(By.xpath(".//*[@id='email-module-set']/div[2]/div[6]/a")).click();
			Thread.sleep(1000);
			StringSelection stringSelection = new StringSelection("D:\\SPM_Test_Automation_Framework\\TestData\\UploaDocument.xlsx");
			//StringSelection stringSelection = new StringSelection("D:/UploaDocument.xlsx");
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        clipboard.setContents(stringSelection, null);
	        Thread.sleep(1000);
	        Robot robot = null;
	 
	        
	        try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	   
	        robot = new Robot();
	        robot.delay(500);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.delay(500);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(500);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        
	        
	} catch (Exception e) {
		return "Failed - unable to select Document";
	}
	return "Pass";
}
	
	public String RefSelectActionstype() throws Exception{
		try {
			System.out.println("clicking on Actions type");
			
			Thread.sleep(1000);
		
			driver.findElement(By.xpath("//div/ul/li[5]/a[contains(text(),'emailed')]")).click();
		} catch (Exception e) {
			return "Failed - unable to select Actions type";
		}
		return "Pass";
	}
	
		
	public String RefSelectAgent() throws Exception{
		try {
			System.out.println("clicking on Agent");
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(".//*[@id='dk_container_ActiveAgentId1']//a[contains(text(),'Prasanthi katam')]")).click();
		} catch (Exception e) {
			return "Failed - unable to select Agent";
		}
		return "Pass";
	}
	
	public String RefSelectCategory() throws Exception{
		try {
			System.out.println("clicking on Category");
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(".//*[@id='dk_container_ActiveCategory']/div/ul/li[2]/a")).click();
		} catch (Exception e) {
			return "Failed - unable to select Category";
		}
		return "Pass";
	}
	
	public String RefSelectpolicy() throws Exception{
		try {
			System.out.println("clicking on policy");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(".//*[@id='dk_container_ActivePolicyName']/div/ul/li[2]/a")).click();
		} catch (Exception e) {
			return "Failed - unable to select policy";
		}
		return "Pass";
	}
	
	
	public String RefSelectAppAgentname() throws Exception{
		try {
			System.out.println("Select Appointment Agent name");
			
			//Thread.sleep(1000);
			
			driver.findElement(By.xpath(".//*[@id='dk_container_ActiveAgentId']//a[contains(text(),'Prasanthi katam')]")).click();
		} catch (Exception e) {
			return "Failed - unable to select Appt Agent Name";
		}
		return "Pass";
	}
	
	
	public String RefSelectreminderAgentname() throws Exception{
		try {
			System.out.println("Select reminder name");
			
			//Thread.sleep(1000);
			
			driver.findElement(By.xpath(".//*[@id='dk_container_ddlFollowUpAgent']//a[contains(text(),'Prasanthi katam')]")).click();
		} catch (Exception e) {
			return "Failed - unable to select reminder Agent name";
		}
		return "Pass";
	}
	
	
	public String RefSelectreminderTime() throws Exception{
		try {
			System.out.println("Select reminder time");
			
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='ui-active-item']")).click();
			//driver.findElement(By.xpath(".//*[@id='txtFollowUpTime']")).click();
		} catch (Exception e) {
			return "Failed - unable to select reminder Time";
		}
		return "Pass";
	}
	
}
	
	


