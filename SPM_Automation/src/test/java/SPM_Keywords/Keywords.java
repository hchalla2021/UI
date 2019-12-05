package SPM_Keywords;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.google.common.base.Function;

import SPM_UIActions.AdvanceSearchFunctionalities;
import SPM_UIActions.ProspectDashboard;
import SPM_UIActions.ReferrerDashboard;
import SPM_UIActions.USPage;
import SPM_UIActions.SPMPage_Prospects;
import SPM_UIActions.SPMPage_Referrer;
import SPM_UIActions.TodayDashboard;
import Utilities.Resources;

public class Keywords extends Resources{
	
	public static String InputText() {
		System.out.println("Data  is Entered ");
		try {
			getWebElement(webElement).sendKeys(TestData);
		}catch (Throwable t) {
			t.printStackTrace();
			return "Failed - Element not found "+webElement;
		}
		return "Pass";
	}
			
	public static String Login() {
		
		System.out.println("Enter the username and password");
		
		try {
			
			getWebElement("login.username").sendKeys(Repository.getProperty("UserName"));
			
			getWebElement("login.password").sendKeys(Repository.getProperty("Password"));
			
			getWebElement("login.LogIn").click();
			
		}catch (Throwable t) {
			t.printStackTrace();
			return "Failed - Elements not are found "+webElement;
		}
		return "Pass";
	}
	
	public static String ClickOnLink() {
		
		System.out.println("Click on link");
		
		String url = driver.getCurrentUrl();
        System.out.println(url);
		try {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			Thread.sleep(100);
			getWebElement(webElement).click();
			Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}catch (Throwable t) {
			t.printStackTrace();
			return "Failed - Element not found "+webElement;
		}
		return "Pass";
	}

	public static String VerifyText() {
		System.out.println("VerifyText is called");
		try {
			String ActualText= getWebElement(webElement).getText();
			System.out.println(ActualText);
			if(!ActualText.equals(TestData)) {
				return "Failed - Actual text "+ActualText+" is not equal to to expected text "+TestData;
			}
		}catch (Throwable t) {
			return "Failed - Element not found "+webElement;
		}
		return "Pass";
	}
	
   /**
    * This Method will return web element.
    * @param locator
    * @return
    * @throws Exception
    */
	public static WebElement getLocator(String locator) throws Exception {
        String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}
	
	public static List<WebElement> getLocators(String locator) throws Exception {
        String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElements(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElements(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return driver.findElements(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElements(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return driver.findElements(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElements(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'"); 
	}
	
	public static WebElement getWebElement(String locator) throws Exception{
		System.out.println("locator data:-"+locator+"is---"+Repository.getProperty(locator));
		return getLocator(Repository.getProperty(locator));
	}
	
	public static WebElement getWebElement1(String locator) throws Exception{
		System.out.println("locator data:-"+locator+"is---"+Repository.getProperty(locator));
		return getLocator(Config.getProperty(locator));
	}
	
	public static List<WebElement> getWebElements(String locator) throws Exception{
		return getLocators(Repository.getProperty(locator));
	}
	
	public static String expliciteWait() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 60); 
		wait.until(ExpectedConditions.visibilityOf(getWebElement(webElement)));
		return "Pass";
	}
	
	/*
	public static String expliciteWait(){
     try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		return "Failed - unable to load the page";
	}
     return "Pass";
	}
	*/
	
	public static String clickWhenReady(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		return "Pass";

	}
	
	public static String waitFor() throws InterruptedException {
		Thread.sleep(1500);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return "Pass";
	}
	
	public static String Loader() throws InterruptedException {
		
		 //Wait until report section displayed
        WebDriverWait wait = new WebDriverWait(driver, 360);
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'loading...')]")));
		return "Pass";
		
		/*WebDriverWait wait = new WebDriverWait(driver, 60); 
		wait.until(ExpectedConditions.visibilityOf(getWebElement(webElement)));
		return "Pass";*/	
		
	}
	
	public static String selectProspectName() throws Exception{
		USPage reg = new USPage();
		return reg.selectProspectName();
	}
	
	public static String SelectAgent() throws Exception{
		USPage reg = new USPage();
		return reg.SelectAgent();
	}	
		
	public static String SelectCategory() throws Exception{
		USPage reg = new USPage();
		return reg.SelectCategory();
	}	
	
	public static String SelectTagcontact() throws Exception{
		USPage reg = new USPage();
		return reg.SelectTagcontact();
	}	
	
	public static String Selectpolicy() throws Exception{
		USPage reg = new USPage();
		return reg.Selectpolicy();
	}	
	
	public static String SelectActionstype() throws Exception{
		USPage reg = new USPage();
		return reg.SelectActionstype();
	}	
	
	public static String UploadDocument() throws Exception{
		USPage reg = new USPage();
		return reg.UploadDocument();
	}	
	
	public static String SelectAppAgentName() throws Exception{
		USPage reg = new USPage();
		return reg.SelectAppAgentName();
	}
	
	public static String SelectAppUnitName() throws Exception{
		USPage reg = new USPage();
		return reg.SelectAppUnitName();
	}
		
	public static String SelectRemainderAgentname() throws Exception{
		USPage reg = new USPage();
		return reg.SelectRemainderAgentname();
	}
	
	public static String SelectRemainderTime() throws Exception{
		USPage reg = new USPage();
		return reg.SelectRemainderTime();
	}
	
	public static String SelectContactGroup() throws Exception{
		USPage reg = new USPage();
		return reg.SelectContactGroup();
	}
	
	public static String SelectContactType() throws Exception{
		USPage reg = new USPage();
		return reg.SelectContactType();
	}
	
	public static String SelectConcludeReason() throws Exception{
		USPage reg = new USPage();
		return reg.SelectConcludeReason();
	}
	
	public static String SelectProspectdd() throws Exception{
		USPage reg = new USPage();
		return reg.SelectProspectdd();
	}
	
	public static String ListUnmanagedProspects() throws Exception{
		USPage reg = new USPage();
		return reg.ListUnmanagedProspects();
	}
	
	public static String SelectPriority() throws Exception{
		USPage reg = new USPage();
		return reg.SelectPriority();
	}
	
	public static String SelectSourceValues() throws Exception{
		USPage reg = new USPage();
		return reg.SelectSourceValues();
	}
	public static String EnterFirstName() throws Exception{
		USPage reg = new USPage();
		return reg.EnterFirstName();
	}
	
	public static String EnterLasttName() throws Exception{
		USPage reg = new USPage();
		return reg.EnterLasttName();
	}
	
	public static String EnterEmailID() throws Exception{
		USPage reg = new USPage();
		return reg.EnterEmailID();
	}
	
	public static String SelectLeadType() throws Exception{
		USPage reg = new USPage();
		return reg.SelectLeadType();
	}
	
	public static String EnterCallBackNumber() throws Exception{
		USPage reg = new USPage();
		return reg.EnterCallBackNumber();
	}
	
	//####Harikrishna Challa####//
	
	public static String SelectdateRangeProspect() throws Exception{
		ProspectDashboard reg = new ProspectDashboard();
		return reg.SelectdateRangeProspect();
	}
	
	public static String EnterDataSearchboxPros() throws Exception{
		ProspectDashboard reg = new ProspectDashboard();
		return reg.EnterDataSearchboxPros();
	}
	
	public static String PagingProspectDB() throws Exception{
		ProspectDashboard reg = new ProspectDashboard();
		return reg.PagingProspectDB();
	}
	
	public static String SelectShowentriesProsDB() throws Exception{
		ProspectDashboard reg = new ProspectDashboard();
		return reg.SelectShowentriesProsDB();
	}
		
	public static String SelectReferrertdd() throws Exception{
		ReferrerDashboard reg = new ReferrerDashboard();
		return reg.SelectReferrertdd();
	}
	
	public static String SelectdateRangeRef() throws Exception{
		ReferrerDashboard reg = new ReferrerDashboard();
		return reg.SelectdateRangeRef();
	}
	
	public static String EnterDataSearchboxRef() throws Exception{
		ReferrerDashboard reg = new ReferrerDashboard();
		return reg.EnterDataSearchboxRef();
	}
	
	public static String PagingRefDB() throws Exception{
		ReferrerDashboard reg = new ReferrerDashboard();
		return reg.PagingRefDB();
	}
	
	public static String SelectShowentriesRefDB() throws Exception{
		ReferrerDashboard reg = new ReferrerDashboard();
		return reg.SelectShowentriesRefDB();
	}
	
	public static String TodaypgMatchedEnqCount() throws Exception{
		TodayDashboard reg = new TodayDashboard();
		return reg.TodaypgMatchedEnqCount();
	}
	
	public static String TodaypgAppointmentsCount() throws Exception{
		TodayDashboard reg = new TodayDashboard();
		return reg.TodaypgAppointmentsCount();
	}
	
	public static String TodaypgRemindersCount() throws Exception{
		TodayDashboard reg = new TodayDashboard();
		return reg.TodaypgRemindersCount();
	}
	
	public static String ChangeOwnerAgent() throws Exception{
		TodayDashboard reg = new TodayDashboard();
		return reg.ChangeOwnerAgent();
	}
	
	public static String AdvancedSearchEnterName() throws Exception{
		AdvanceSearchFunctionalities reg = new AdvanceSearchFunctionalities();
		return reg.AdvancedSearchEnterName();
	}
	
	public static String ClickLogactionBtn() throws Exception{
		AdvanceSearchFunctionalities reg = new AdvanceSearchFunctionalities();
		return reg.ClickLogactionBtn();
	}
	
	public static String ClickOnAnActionYouWishToLog() throws Exception{
		AdvanceSearchFunctionalities reg = new AdvanceSearchFunctionalities();
		return reg.ClickOnAnActionYouWishToLog();
	}
	public static String SelectAgentName() throws Exception{
		AdvanceSearchFunctionalities reg = new AdvanceSearchFunctionalities();
		return reg.SelectAgentName();
	}
	
	public static String ClicKExporToPDF() throws Exception{
		AdvanceSearchFunctionalities reg = new AdvanceSearchFunctionalities();
		return reg.ClicKExporToPDF();
	}
	
	public static String ClickAgentDD() throws Exception{
		AdvanceSearchFunctionalities reg = new AdvanceSearchFunctionalities();
		return reg.ClickAgentDD();
	}
	
	public static String SelectActiontype() throws Exception{
		AdvanceSearchFunctionalities reg = new AdvanceSearchFunctionalities();
		return reg.SelectActiontype();
	}
	public static String ClickOnShowResults() throws Exception{
		AdvanceSearchFunctionalities reg = new AdvanceSearchFunctionalities();
		return reg.ClickOnShowResults();
	}

	public static String LaunchingApplication() throws Exception{
		USPage reg = new USPage();
		return reg.LaunchingApplication();
	}
	
	public static String Logout() throws Exception{
		USPage reg = new USPage();
		return reg.Logout();
	}
	  public static String EnterRefFirstName() throws Exception{
      	SPMPage_Referrer reg = new SPMPage_Referrer();
          return reg.EnterRefFirstName();
      }

      public static String EnterRefLasttName() throws Exception{
      	SPMPage_Referrer reg = new SPMPage_Referrer();
          return reg.EnterRefLasttName();
      }
      
public static String EnterRefCallBackNumber() throws Exception{
	SPMPage_Referrer reg = new SPMPage_Referrer();
    return reg.EnterRefCallBackNumber();
}

public static String EnterRefEmailID() throws Exception{
	SPMPage_Referrer reg = new SPMPage_Referrer();
    return reg.EnterRefEmailID();
}

public static String RefSelectActionstype() throws Exception{
	SPMPage_Referrer reg = new SPMPage_Referrer();
                return reg.RefSelectActionstype();
} 

public static String RefSelectAgent() throws Exception{
	SPMPage_Referrer reg = new SPMPage_Referrer();
    return reg.RefSelectAgent();
}
	
public static String RefSelectCategory() throws Exception{
	SPMPage_Referrer reg = new SPMPage_Referrer();
    return reg.RefSelectCategory();
}              

   
public static String RefSelectpolicy() throws Exception{
	SPMPage_Referrer reg = new SPMPage_Referrer();
    return reg.RefSelectpolicy();
}              

  
public static String RefUploadDocument() throws Exception{
	SPMPage_Referrer reg = new SPMPage_Referrer();
    return reg.RefUploadDocument();
}              

public static String RefSelectAppAgentname() throws Exception{
	SPMPage_Referrer reg = new SPMPage_Referrer();
    return reg.RefSelectAppAgentname();
}

        
public static String RefSelectreminderAgentname() throws Exception{
	SPMPage_Referrer reg = new SPMPage_Referrer();
    return reg.RefSelectreminderAgentname();
}

public static String RefSelectreminderTime() throws Exception{
	SPMPage_Referrer reg = new SPMPage_Referrer();
    return reg.RefSelectreminderTime();
  }

public static String SelectreminderTime() throws Exception{
	USPage reg = new USPage();
    return reg.SelectreminderTime();
  }


public static String EnterPrimaryFirstname() throws Exception{
	SPMPage_Prospects reg = new SPMPage_Prospects();
return reg.EnterPrimaryFirstname();

}

public static String EnterPrimaryLastName() throws Exception{
	SPMPage_Prospects reg = new SPMPage_Prospects();
return reg.EnterPrimaryLastName();
}



public static String EnterPrimaryPhone() throws Exception{
	SPMPage_Prospects reg = new SPMPage_Prospects();
return reg.EnterPrimaryPhone();
}

public static String EnterOtherFirstName() throws Exception{
	SPMPage_Prospects reg = new SPMPage_Prospects();
return reg.EnterOtherFirstName();
}

public static String EnterOtherLastName() throws Exception{
	SPMPage_Prospects reg = new SPMPage_Prospects();
return reg.EnterOtherLastName();
   }

public static String EnterOtherPhone() throws Exception{
	SPMPage_Prospects reg = new SPMPage_Prospects();
return reg.EnterOtherPhone();
}

public static String SelectEditPriority() throws Exception{
	SPMPage_Prospects reg = new SPMPage_Prospects();
return reg.SelectEditPriority();
}

public static String SelectAbleToPay() throws Exception{
	SPMPage_Prospects reg = new SPMPage_Prospects();
return reg.SelectAbleToPay();
}  

public static String SelectWillingToShare() throws Exception{
	SPMPage_Prospects reg = new SPMPage_Prospects();
return reg.SelectWillingToShare();
} 

public static String SelectMaritalStatus() throws Exception{
	SPMPage_Prospects reg = new SPMPage_Prospects();
return reg.SelectMaritalStatus();
} 



	public static String closeBrowser() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.quit();
		return Description;
	    }
	
    }  
