package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import ExcelReader.excelReader;
import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

public class Resources {
	
	public static WebDriver dr;
	public static EventFiringWebDriver driver;
	public static Properties Repository = new Properties();
	public static Properties Config = new Properties();
	//public static Properties AppText = new Properties();
	public static ExcelReader.excelReader SuiteData;
	public static ExcelReader.excelReader TestStepData;
	public static String keyword;
	public static String webElement;
	public static String TestDataField;
	public static String TestData;
	public static String ProceedOnFail;
	public static String TSID;
	public static String Description;
	public static File file ;
	public static FileInputStream Finputstream;

	
	public static void Initialize() throws IOException {
		
		//******Test data and test case configuration*********
		TestStepData= new excelReader(System.getProperty("user.dir")+"//TestData//TestData.xlsx");
		SuiteData 	 = new excelReader(System.getProperty("user.dir")+"//TestData//TestCases.xlsx");
		System.out.println(System.getProperty("user.dir"));       
		
		//******Page Objects configuration*********
		file = new File(System.getProperty("user.dir")+"//src//main//java//PageObjects//USObjects.properties");
		Finputstream = new FileInputStream(file);
		Repository.load(Finputstream);
		
		//******Application  configuration*********
		file = new File(System.getProperty("user.dir")+"//src//main//java//Config//Config.properties");
		Finputstream = new FileInputStream(file);
		Repository.load(Finputstream);
	
		
	}
	public static void main(String[] args) throws IOException {
		Initialize();
		
	        }
	
}
