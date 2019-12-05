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

public class ProspectDashboard extends Resources{ 
	
	SimpleDateFormat sdf = new SimpleDateFormat("MMddHms");
	SimpleDateFormat sdf1 = new SimpleDateFormat("MMddHms");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    //System.out.println(sdf.format(timestamp));
	 Random randomGenerator = new Random();  
    int PhoneNumner = randomGenerator.nextInt(1000);  
    int EmailID = randomGenerator.nextInt(1000);
  //System.out.println("FirstName_"+ sdf.format(timestamp));
	//System.out.println(sdf.format(timestamp));
	
	    public String GetPriorityProspectDB() throws Exception{
	     //tooltip fo priority
	    	try {
	    		
	  	String Priority = driver.findElement(By.xpath(".//*[@id='theProspect 1']/td[2]//i")).getAttribute("title");
	         	
	         	//assertEquals(Priority,"Warm");
	         	
	         	//String myString1 = "Warm";
	         	String myString2 = "Warm";
	         	
	         	if(Priority.equals(myString2)) {
	         		
	         		System.out.println("I cans see expected Priority as" + Priority);
	         	}
	         	
	         	else {
	         		
	         		System.out.println("Not expected but i can see Priority as "+ Priority);
	         		
	         	}
	         		
	         	
	    		Thread.sleep(1000);
	    		
	    	} catch (Exception e) {
	    		
	    		return "Failed - unable to find  priority in prospect dashboard";
	    	}
	    	return "Pass";
	       }

	    public String SelectdateRangeProspect() throws Exception{
	     
	       	try {
	       	    
	    	    //start date
	    			if(driver.findElement(By.xpath(".//*[@id='date-range']/div/span[1]/span/button")).isDisplayed())
	    			{
	    	            driver.findElement(By.xpath(".//*[@id='date-range']/div/span[1]/span/button")).click();
	    			    
	    			    //click on today button button
	    			    
	    			    //driver.findElement(By.xpath(".//*[@id='prospectlist']/div[12]/table[5]/tbody/tr/td[1]")).click();
	    	            
	    	            //select 8th janauary date
	    	            
	    			    driver.findElement(By.xpath(".//*[@id='prospectlist']/div[12]/table[2]/tbody/tr[3]/td[1]")).click();
	    			    
	    			    
	    		             //end date
	    		           	if(driver.findElement(By.xpath(".//*[@id='date-range']/div/span[3]/span/button")).isDisplayed())
	    		           	{
	    		                   driver.findElement(By.xpath(".//*[@id='date-range']/div/span[3]/span/button")).click();
	    		                   
	    		                   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    		                   
	    		                   //click next button  for calendar
	    		       		    driver.findElement(By.xpath(".//*[@id='prospectlist']/div[13]/table[1]/tbody/tr/td[3]")).click();
	    		       		    
	    		       		    //Next month date selection/// Feb 2019 28th date
	    		       		    driver.findElement(By.xpath(".//*[@id='prospectlist']/div[13]/table[2]/tbody/tr[6]/td[4]")).click();
	    		       		    
	    		       		    //Click Submit button
	    		       		    
	    		       		 driver.findElement(By.xpath(".//*[@id='btnSubmitProspectList']")).click();
	    		       		    
	    		                	}
	    		           	}
	    		
	       		Thread.sleep(1000);
	       		
	       	} catch (Exception e) {
	       		
	       		return "Failed - unable to find  select  daterange  in prospect dashboard";
	       	    }
	       	return "Pass";
	       	
	         	}

	    public String EnterDataSearchboxPros() throws Exception{
	        
	       	try {
	       	    
	       	  //Search box in prospect dashboard
			    driver.findElement(By.xpath(".//*[@id='unmanaged_filter']/label/input")).sendKeys("Test");
			    
			    String No_ofEnteries = driver.findElement(By.xpath(".//*[@id='unmanaged_info']")).getText();
			    
			    System.out.println("Number of entries are" +No_ofEnteries);
			    
			    //download excel
			    
			    driver.findElement(By.xpath(".//*[@id='unmanaged_wrapper']/div[2]/button[1]")).click();
			    		
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    
			    //download PDF
			    
			    driver.findElement(By.xpath(".//*[@id='unmanaged_wrapper']/div[2]/button[2]")).click();
			    
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    
			    //Print the datagrid data
			    
			    driver.findElement(By.xpath(".//*[@id='unmanaged_wrapper']/div[2]/button[3]")).click();
			    
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    
			 
			    
			    //Windows objects
			    String originalHandle = driver.getWindowHandle();

			    //Do something to open new tabs
			    
			    for(String handle : driver.getWindowHandles()) {
			        if (!handle.equals(originalHandle)) {
			            driver.switchTo().window(handle);
			            Thread.sleep(5);
			            driver.close();
			          }
			        
			        driver.switchTo().window(originalHandle);
			    }

			     
	       		Thread.sleep(1000);
	       		
	       	} catch (Exception e) {
	       		
	       		return "Failed - unable to find  search the date  in prospect dashboard grid";
	       	    }
	       	return "Pass";
	       	
	         	}
	    
	    public String PagingProspectDB() throws Exception{
	        
	       	try {
	       	
	       	 
			    for (int i = 1; i <100 ; i++) {
		    		
			    	if(driver.findElement(By.xpath(".//*[@id='unmanaged_paginate']")).isDisplayed()) {
			    		
			    		WebDriverWait wait = new WebDriverWait(driver, 10); 
				    	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath((".//*[@id='unmanaged_next']"))));
				    	element.click();
				
			    		}else {
			    			
			    			System.out.println("Opps ! No entries found ");
			    			break;
			    		  
			    		}
			    	}
	    		
	       		Thread.sleep(1000);
	       		
	       	} catch (Exception e) {
	       		
	       		return "Failed - unable to find entries found  in prospect dashboard grid";
	       	    }
	       	return "Pass";
	       	
	         	}

	    public String SelectShowentriesProsDB() throws Exception{
	        
	       	try {
	       		
	       	 driver.findElement(By.xpath(".//*[@id='leads']")).click();
	       	 
	     	// Locating drop down
				driver.findElement(By.xpath(".//*[@id='unmanaged_length']/label/select")).click();
				   Thread.sleep(1000);
					// Getting list of options
					List<WebElement> itemsInDropdown = driver
							.findElements(By.xpath(".//*[@id='unmanaged_length']/label/select//option"));

					// Getting size of options available
					int size = itemsInDropdown.size();
					System.out.println(size);

					// Generate a random number with in range
					int randnMumber = ThreadLocalRandom.current().nextInt(1, size);

					// Selecting random value
					itemsInDropdown.get(randnMumber).click();
					
					System.out.println(itemsInDropdown.get(randnMumber));
					
					driver.findElement(By.xpath(".//*[@id='unmanaged_length']/label")).click();
					
					String NoEtries = driver.findElement(By.xpath(".//*[@id='unmanaged_info']")).getText();
			
					System.out.println("Number of entries showing: "+ NoEtries);
	    		
	       		Thread.sleep(1000);
	       		
	       	} catch (Exception e) {
	       		
	       		return "Failed - unable to find entries found  in prospect dashboard grid";
	       	    }
	       	return "Pass";
	       	
	         	}

}