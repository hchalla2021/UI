package US_Keywords;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import US_UIActions.USPage;
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
	
	public static String LaunchingApplication() throws Exception{
		USPage US = new USPage();
		return US.LaunchingApplication();
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
	
	public static String closeBrowser() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.quit();
		return Description;
	    }
	
    }  
