
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


public class SPMPage_Prospects extends Resources{ 
	
	SimpleDateFormat sdf = new SimpleDateFormat("MMddHms");
	SimpleDateFormat sdf1 = new SimpleDateFormat("MMddHms");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    //System.out.println(sdf.format(timestamp));
	 Random randomGenerator = new Random();  
    int PhoneNumner = randomGenerator.nextInt(1000);  
    int EmailID = randomGenerator.nextInt(1000);
 

    public String SelectActionstype() throws Exception{
		try {
			System.out.println("clicking on Actions type");
			
			Thread.sleep(1000);
		
			driver.findElement(By.xpath("//div/ul/li[5]/a[contains(text(),'emailed')]")).click();
		} catch (Exception e) {
			return "Failed - unable to select Actions type";
		}
		return "Pass";
	}
	
	public String SelectTagcontact() throws Exception{
		try {
			System.out.println("clicking on Tagcontact");
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(".//*[@id='multiTaggedContacts']/dl/dd/div/ul/li[1]/label")).click();
		} catch (Exception e) {
			return "Failed - unable to select Tagcontact";
		}
		return "Pass";
	}
	
	public String SelectAgent() throws Exception{
		try {
			System.out.println("clicking on Agent");
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(".//*[@id='dk_container_ActiveAgentId1']//a[contains(text(),'Prasanthi katam')]")).click();
		} catch (Exception e) {
			return "Failed - unable to select Agent";
		}
		return "Pass";
	}
	
	public String SelectCategory() throws Exception{
		try {
			System.out.println("clicking on Category");
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//div/ul/li[2]/a[contains(text(),'amenities2')]")).click();
		} catch (Exception e) {
			return "Failed - unable to select Category";
		}
		return "Pass";
	}
	
	public String Selectpolicy() throws Exception{
		try {
			System.out.println("clicking on policy");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(".//*[@id='dk_container_ActivePolicyName']/div/ul/li[2]/a")).click();
		} catch (Exception e) {
			return "Failed - unable to select policy";
		}
		return "Pass";
	}
	
	public String SelectAppAgentName() throws Exception{
		try {
			System.out.println("Select Appointment Agent name");
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(".//*[@id='dk_container_ActiveAgentId']//a[contains(text(),'Prasanthi katam')]")).click();
		} catch (Exception e) {
			return "Failed - unable to select Appt Agent Name";
		}
		return "Pass";
	}
	
	public String SelectAppUnitName() throws Exception{
		try {
			System.out.println("Select Appointment Unit name");
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(".//*[@id='dk_container_ActiveUnitId']//a[contains(text(),'Bldg: AL, Unit: 218B')]")).click();
		} catch (Exception e) {
			return "Failed - unable to selectAppt Unit Name";
		}
		return "Pass";
	}
	
	public String SelectreminderAgentname() throws Exception{
		try {
			System.out.println("Select reminder name");
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(".//*[@id='dk_container_ddlFollowUpAgent']//a[contains(text(),'Prasanthi katam')]")).click();
		} catch (Exception e) {
			return "Failed - unable to select reminder Agent name";
		}
		return "Pass";
	}
	
	public String SelectreminderTime() throws Exception{
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
	
	public String SelectContactGroup() throws Exception{
		try {
			System.out.println("Select Contact Group Name");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(".//*[@id='dk_container_ddlcontactgroup_assoc_referrer_0_0']//a[contains(text(),'Resident')]")).click();
			
			Thread.sleep(1000);
		} catch (Exception e) {
			return "Failed - unable to select ContactGroup";
		}
		return "Pass";
	}
	
	public String SelectContactType() throws Exception{
		
		try {
			
			System.out.println("Select Contact Type");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(".//*[@id='dk_container_ddlcontacttype_assoc_referrer']//a[contains(text(),'Resident')]")).click();
		} catch (Exception e) {
			return "Failed - unable to select ContactType ";
		}
		return "Pass";
	}
	
	public String SelectConcludeReason() throws Exception{
		try {
			
			System.out.println("Select Conclude reason from drop down");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//div/ul/li[3]//a[contains(text(),'Bedroom size')]")).click();
			
		} catch (Exception e) {
			
			return "Failed - unable to select Conclude Reason";
		}
		return "Pass";
	}
	
	public String SelectProspectdd() throws Exception{
		try {
			
			for(int i=2;i<3;i++) {
				
				driver.findElement(By.xpath(".//*[@id='dk_container_ProspectListTypeDDL']/a")).click();
				
				Thread.sleep(500);
				//driver.findElement(By.xpath("//*[@id='ProspectListTypeDDL']//option[contains(text(),'All Active Prospects')]")).click();
				
				driver.findElement(By.xpath(".//*[@id='dk_container_ProspectListTypeDDL']/div/ul/li["+i+"]/a")).click();
				
			}
			
		} catch (Exception e) {
			
			return "Failed - unable to select Prospect drop down";
		}
		return "Pass";
	}
	
	public String ListUnmanagedProspects() throws Exception{
		try {
			
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='unmanagedList']//tbody//tr"));
			int UnmanagedCount = rows.size();
			System.out.println("Number of Unmanaged Prospects in today Page is : "+UnmanagedCount);
			
		} catch (Exception e) {
			
			return "Failed - unable to get number of unmanaged prospects in today page";
		}
		return "Pass";
	}
	
	public String Logout() throws Exception{
		try {
			
			//driver.findElement(By.xpath(".//*[@id='global-header']/ul/li[6]/a/span")).click();
			driver.findElement(By.xpath(".//*[@id='global-header']/ul/li[3]/a")).click();
			
						
			Thread.sleep(1000);
			
			//Actions action = new Actions(driver);
			//action.sendKeys(Keys.ESCAPE);
			
			Thread.sleep(1000);
			
			if(driver.findElement(By.xpath("//*[@id='promptGuestModal']/div/div")).isDisplayed())                                                                                                         
			{         
			  /**Do this*/  
				Thread.sleep(500);
				driver.findElement(By.xpath("//*[@id='ModalIgnorePromptId']")).click();
			}    
			else    
			{     
			  /**Do this*/  
				Thread.sleep(500);
			 driver.findElement(By.xpath("//a[contains(text(),'log out')]")).click();
			}
			
			//driver.findElement(By.xpath("//a[contains(text(),'log out')]")).click();
			
		} catch (Exception e) {
			
			return "Failed - unable to Logout Application";
		}
		return "Pass";
	}
			
    public String SelectLeadType() throws Exception{
		
		try {
			
			// Locating drop down
			driver.findElement(By.xpath(".//*[@id='dk_container_ddlLeadType']/a")).click();

			// Waiting till options in drop down are visible
			/*WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//div[@class='visible']"))));*/
					
			   Thread.sleep(1000);
				// Getting list of options
				List<WebElement> itemsInDropdown = driver
						.findElements(By.xpath(".//*[@id='dk_container_ddlLeadType']/div/ul//li"));

				// Getting size of options available
				int size = itemsInDropdown.size();
				System.out.println(size);

				// Generate a random number with in range
				int randnMumber = ThreadLocalRandom.current().nextInt(2, size);

				
				// Selecting random value
				itemsInDropdown.get(randnMumber).click();
				
				System.out.println(itemsInDropdown.get(randnMumber));
			
			Thread.sleep(1000);
			
		} catch (Exception e) {
			
			return "Failed - unable to select LeadType";
		}
		return "Pass";
	}

    public String SelectPriority() throws Exception{
	
	try {
		
		// Locating drop down
		driver.findElement(By.xpath(".//*[@id='dk_container_ddlpriority']/a")).click();

		   Thread.sleep(1000);
			// Getting list of options
			List<WebElement> itemsInDropdown = driver
					.findElements(By.xpath(".//*[@id='dk_container_ddlpriority']/div/ul//li"));

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
		
		return "Failed - unable to select Priority ";
	}
	return "Pass";
}

    public String SelectSourceValues() throws Exception{

	try {
		
		     // Locating drop down
		    driver.findElement(By.xpath(".//*[@id='dk_container_ddlLeadSource']/a")).click();

		   //Thread.sleep(1000);
			// Getting list of options
			List<WebElement> itemsInDropdown = driver.findElements(By.xpath(".//*[@id='dk_container_ddlLeadSource']/div/ul//li"));
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
		
		return "Failed - unable to select Source Value";
	}
	return "Pass";
}

    public String CurrentTimeStamp() throws Exception{
	
	try {
		
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_d_H_m_s");
		//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(sdf.format(timestamp));
		
	} catch (Exception e) {
		
		return "Failed - unable to get current time stamp";
	}
	return "Pass";
    }
    
	public String EnterPrimaryFirstname() throws Exception{
		try {
			//Thread.sleep(3000);
			System.out.println("Entering the First Name");
			driver.findElement(By.xpath(".//*[@id='txtFirstName3']")).sendKeys("RealPageTest");
		} catch (Exception e) {
			return "Failed - unable to find first name object";
		}
		return "Pass";
	}
	
public String EnterPrimaryLastName() throws Exception{
		try {
			//Thread.sleep(3000);
			System.out.println("Entering the Last Name");
			
			//driver.findElement(By.xpath(".//*[@id='txtLastName']")).sendKeys(TestData+sd.format(timestamp));
			driver.findElement(By.xpath(".//*[@id='txtLastName3']")).sendKeys(sdf1.format(timestamp));
		} catch (Exception e) {
			return "Failed - unable to find Last name object";
		}
		return "Pass";
	}
	
public String EnterPrimaryPhone() throws Exception{
		try {
			
			System.out.println("Entering the Call Back Number");

			driver.findElement(By.xpath(".//*[@id='txtPhone 3']")).sendKeys("124-144"+"-"+ PhoneNumner +"x4414");
			
		} catch (Exception e) {
			return "Failed - unable to find Phone number object";
		}
		return "Pass";
	}

public String EnterOtherFirstName() throws Exception{
	try {
		//Thread.sleep(3000);
		System.out.println("Entering the First Name");
		driver.findElement(By.xpath(".//*[@id='txtFirstName4']")).sendKeys("RealPageTest");
	} catch (Exception e) {
		return "Failed - unable to find first name object";
	}
	return "Pass";
}

public String EnterOtherLastName() throws Exception{
	try {
		//Thread.sleep(3000);
		System.out.println("Entering the Last Name");
		
		//driver.findElement(By.xpath(".//*[@id='txtLastName']")).sendKeys(TestData+sd.format(timestamp));
		driver.findElement(By.xpath(".//*[@id='txtLastName4']")).sendKeys(sdf1.format(timestamp));
	} catch (Exception e) {
		return "Failed - unable to find Last name object";
	}
	return "Pass";
}

public String EnterOtherPhone() throws Exception{
	try {
		
		System.out.println("Entering the Call Back Number");

		driver.findElement(By.xpath(".//*[@id='txtPhone 4']")).sendKeys("124-144"+"-"+ PhoneNumner +"x4414");
		
	} catch (Exception e) {
		return "Failed - unable to find Phone number object";
	}
	return "Pass";
}


public String SelectEditPriority() throws Exception{
	try {
		System.out.println("clicking on Priority to Edit");
	
		WebElement element = driver.findElement(By.xpath(".//*[@id='dk_container_PriorityId']/div/ul/li[4]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

	} catch (Exception e) {
		return "Failed - unable to edit prirotiy";
	}
	return "Pass";
}

public String SelectAbleToPay() throws Exception{
	try {
		System.out.println("clicking on AbleToPay");
	
		WebElement element = driver.findElement(By.xpath(".//*[@id='chkAbleToPay']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

	} catch (Exception e) {
		return "Failed - unable to select Able to Pay check box";
	}
	return "Pass";
}

public String SelectWillingToShare() throws Exception{
	try {
		System.out.println("clicking on AbleToPay");
	
		WebElement element = driver.findElement(By.xpath(".//*[@id='chkWillingToShare']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

	} catch (Exception e) {
		return "Failed - unable to select willing to share check box";
	}
	return "Pass";
}

public String SelectMaritalStatus() throws Exception{
	 try {
		System.out.println("clicking on MaritalStatus");
	
		WebElement element = driver.findElement(By.xpath(".//*[@id='dk_container_ddlMarital0']/div/ul/li[6]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

	} catch (Exception e) {
		return "Failed - unable to select marital status";
	}
	return "Pass";
}

}
	
	


