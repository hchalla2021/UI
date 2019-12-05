package DriverScripts;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ReportUtilities.ReportUtil;
import SPM_Keywords.Keywords;
import Utilities.Resources;
import Utilities.TestUtils;

public class MainDriverScript extends Resources{  
	
	@BeforeClass
	public void initBrowser() throws IOException {
		Initialize();
		
	     }

	@Test
	public void DriverScript() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		
		String startTime = TestUtils.now("dd.MMMM.yyyy hh.mm.ss aaa");
	
		//String RunBy = Repository.getProperty("RunBy");
		String ENVIRONMENT =Repository.getProperty("EnvName");
		String RELEASE = Repository.getProperty("RelName");
		ReportUtil.startTesting(System.getProperty("user.dir")+"//Reports//US_Detailed_Report.html", startTime, ENVIRONMENT, RELEASE);
		//ReportUtil.startTesting(System.getProperty("user.dir")+"//Reports//US_Detailed_Report.html", startTime);
		ReportUtil.startSuite("US");
		String TCStatus="Passed";
		
		
		// loop through the test cases
		for(int TC=2;TC<=SuiteData.getRowCount("TestCases");TC++) {
	
			String TestCaseID = SuiteData.getCellData("TestCases", "TCID", TC);
			String RunMode = SuiteData.getCellData("TestCases", "RunMode", TC);
			
			if(RunMode.equals("Y")) {
				
				String TSStatus="Passed";
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-infobars");
		        options.setExperimentalOption("prefs", prefs);
				dr = new ChromeDriver(options);
				driver = new EventFiringWebDriver(dr);
				//driver.get("");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				int rows = TestStepData.getRowCount(TestCaseID);
				if(rows<2) { 
					rows=2;
				}
				
				// loop through test data
				for(int TD=2;TD<=rows;TD++ ) {
				
					// loop through the test steps
					System.out.println("SuiteData.getRowCount(TestCaseID)"+SuiteData.getRowCount(TestCaseID));
					
					for(int TS=2;TS<=SuiteData.getRowCount(TestCaseID);TS++) {
						
						keyword = SuiteData.getCellData(TestCaseID, "Keyword", TS);
						webElement = SuiteData.getCellData(TestCaseID, "WebElement", TS);
						ProceedOnFail = SuiteData.getCellData(TestCaseID, "ProceedOnFail", TS);
						TSID = SuiteData.getCellData(TestCaseID, "TSID", TS);
						Description = SuiteData.getCellData(TestCaseID, "Description", TS);
						
						TestDataField = SuiteData.getCellData(TestCaseID, "TestDataField", TS);
						
						
						TestData = TestStepData.getCellData(TestCaseID, TestDataField, TD);	
					
						Method method = Keywords.class.getMethod(keyword);	
						TSStatus = (String) method.invoke(method);
						
						if(TSStatus.contains("Failed")) {
							// take the screenshot if failed
							String filename = "US_"+TestCaseID+"["+(TD-1)+"]"+TSID+"["+TestData+"]";
							TestUtils.getScreenShot(filename);
							
							TCStatus=TSStatus;
							// report error
							ReportUtil.addKeyword(Description, keyword, TSStatus, "Screenshot/"+filename+".jpg");

							if(ProceedOnFail.equals("N")) {
								break;
							}
						} else {                          
							ReportUtil.addKeyword(Description, keyword, TSStatus, null);
							
						}
						
						
					}                                                                      
				
					ReportUtil.addTestCase(TestCaseID, startTime, TestUtils.now("dd.MMMM.yyyy hh.mm.ss aaa"), TCStatus);
					driver.quit();
				}
			}else {
			
				ReportUtil.addTestCase(TestCaseID, startTime, TestUtils.now("dd.MMMM.yyyy hh.mm.ss aaa"), "Skipped");
				driver.quit();
			}
		}

		ReportUtil.endSuite();
		ReportUtil.updateEndTime(TestUtils.now("dd.MMMM.yyyy hh.mm.ss aaa"));
		
	}
	
	@AfterClass
	public void quitBrowser() throws InterruptedException {
		
		System.out.println("Closing the Browser---------------------------");
		  Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.quit();
	}
	
	
}
