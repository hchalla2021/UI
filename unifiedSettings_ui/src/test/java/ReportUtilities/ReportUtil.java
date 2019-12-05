package ReportUtilities;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import Utilities.TestUtils;

public class ReportUtil {
	
	public static int scriptNumber = 1;
	public static String indexResultFilename;
	public static String currentDir;
	public static String currentSuiteName;
	public static int tcid;
	public static Properties Repository = new Properties();
	public static Properties Config = new Properties();
	//public static String currentSuitePath;
	public static double passNumber;
	public static double failNumber;
	public static boolean newTest = true;
	public static ArrayList<String> description = new ArrayList<String>();;
	public static ArrayList<String> keyword = new ArrayList<String>();;
	public static ArrayList<String> teststatus = new ArrayList<String>();;
	public static ArrayList<String> screenShotPath = new ArrayList<String>();;

	public static void startTesting(String filename, String testStartTime, String ENVIRONMENT, String RELEASE) {
	//public static void startTesting(String filename, String testStartTime) {
		indexResultFilename = filename;
		
		currentDir = indexResultFilename.substring(0, indexResultFilename.lastIndexOf("//"));
		
		FileWriter fstream = null; 
		BufferedWriter out = null;
		try {
			// Create file

			fstream = new FileWriter(filename);
			out = new BufferedWriter(fstream);
			
			String RUN_DATE = TestUtils.now("dd.MMMMM.yyyy").toString();

			//String ENVIRONMENT = env;
			//String RELEASE = rel;
			/*String ENVIRONMENT =Repository.getProperty("EnvName");
			String RELEASE = Repository.getProperty("RelName");*/
			//String Rel =Repository.getProperty("RelName");
			//String Env =Repository.getProperty("EnvName");
			String RunBy = System.getProperty("user.name");
			out.newLine();
			out.write("<!DOCTYPE html>\n");
			out.write("<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\">\n");
			out.write(" <head><meta charset=\"utf-8\" /><title>Automation Results</title></head>\n");
			out.write("<body style=\"background-color:rgb(240, 240, 240)!important\">\n");
			out.write("<div>\n" + 
					"           <div style=\"text-align:center;color:#41a3f2!important\">\n" + 
					 //"            <h1 style=\"padding-left: 50%;\">\n" +
					 "               <h1>\n" +
					/*"                <img src=\"https://senior.prospects.realpage.com/Images/spm-icon-logo.png\" height=\"74\" style=\"text-align:center\" />\n" +*/
					"                <label style=\"vertical-align: top;display: inline-block;margin-top: 20px;\">Test Automation Results</label>\n" + 	
					"                <img src=\"https://senior.prospects.realpage.com/Images/REALPAGE-Outperform.png\" height=\"74\" style=\"/* text-align: right; */padding-left: 38%;\">\n" +
					"            </h1>\n" +
					"        </div>\n" + 
					"    </div>\n");
	/*		out.write("<div>\n" + 
					"        <div style=\"text-align:center;color:#41a3f2!important\">\n" + 
					"            <h1>\n" +
					"                <img src=\"https://senior.prospects.realpage.com/Images/spm-icon-logo.png\" height=\"74\" style=\"text-align:center\" />\n" +
					"                <label style=\"vertical-align: top;display: inline-block;margin-top: 20px;\">Test Automation Results</label>\n" + 	
					"                <img src=\"https://senior.prospects.realpage.com/Images/REALPAGE-Outperform.png\" height=\"54\" style=\"text-align:right\" />\n" +
					"            </h1>\n" +
					"        </div>\n" + 
					"    </div>\n");*/
			//<div style=\"text-align:center;color:#41a3f2!important\">\n" +
			//background-color: rgb(240, 240, 240);text-align:center;color:#41a3f2!important
			out.write("<table  border=1 cellspacing=1 cellpadding=1 align=center>\n");
			out.write("<tr>\n");
			//out.write("<h4> <FONT COLOR=#41a3f2 FACE=Arial SIZE=4.5 align=center> <u>Test Details :</u></h4>\n");
			out.write("<td width=150 align=left bgcolor=#427ea6><FONT COLOR=#ffffff FACE=Arial SIZE=2.75><b>Date and Time</b></td>\n");
			out.write("<td width=150 align=left><FONT COLOR=#153E7E FACE=Arial SIZE=2.75><b>" + RUN_DATE + "</b></td>\n");	

			out.write("</tr>\n");
			out.write("<tr>\n");

			out.write("<td width=150 align=left bgcolor=#427ea6><FONT COLOR=#ffffff FACE=Arial SIZE=2.75><b>StartTime</b></td>\n");

			out.write("<td width=150 align=left><FONT COLOR=#153E7E FACE=Arial SIZE=2.75><b>" + testStartTime + "</b></td>\n");
			out.write("</tr>\n");
			out.write("<tr>\n");
			// out.newLine();
			out.write("<td width=150 align= left  bgcolor=#427ea6><FONT COLOR=#ffffff FACE= Arial  SIZE=2.75><b>EndTime</b></td>\n");
			out.write("<td width=150 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>END_TIME</b></td>\n");
			out.write("</tr>\n");
			out.write("<tr>\n");
			// out.newLine();
			out.write("<td width=150 align= left  bgcolor=#427ea6><FONT COLOR=#ffffff FACE= Arial  SIZE=2.75><b>Environment</b></td>\n");
			out.write("<td width=150 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>" + ENVIRONMENT + "</b></td>\n");
			out.write("</tr>\n");
			out.write("<tr>\n");

			out.write("<td width=150 align= left  bgcolor=#427ea6><FONT COLOR=#ffffff FACE= Arial  SIZE=2.75><b>Release</b></td>\n");
			out.write("<td width=150 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>" + RELEASE + "</b></td>\n");
			out.write("</tr>\n");
			out.write("<td width=150 align= left  bgcolor=#427ea6><FONT COLOR=#ffffff FACE= Arial  SIZE=2.75><b>Run by</b></td>\n");
			out.write("<td width=150 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>"+RunBy + "</b></td>\n");
			out.write("</tr>\n");
			out.write("</table>\n");

			// Close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		} finally {

			fstream = null;
			out = null;
		}
	}

	public static void startSuite(String suiteName) {

		FileWriter fstream = null;
		BufferedWriter out = null;
		currentSuiteName = suiteName.replaceAll(" ", "_");
		tcid = 1;
		try {
			

			fstream = new FileWriter(indexResultFilename, true);
			out = new BufferedWriter(fstream);

			out.write("<h4> <FONT COLOR=#41a3f2 FACE= Arial  SIZE=4.5> <u>" + suiteName + " Test Case Details:</u></h4>\n");
			out.write("<table  border=1 cellspacing=1 cellpadding=1 width=100%>\n");
			out.write("<tr>\n");
			//out.write("<td width=10%  align= center  bgcolor=#306791><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2><b>S.No</b></td>\n");
			out.write("<td width=10%  align= center  bgcolor=#427ea6><FONT COLOR=#ffffff FACE= Arial  SIZE=2><b>S.No</b></td>\n");
			out.write("<td width=40% align= center  bgcolor=#427ea6><FONT COLOR=#ffffff FACE= Arial  SIZE=2><b>Test Case Name</b></td>\n");
			out.write("<td width=10% align= center  bgcolor=#427ea6><FONT COLOR=#ffffff FACE= Arial  SIZE=2><b>Status</b></td>\n");
			out.write("<td width=20% align= center  bgcolor=#427ea6><FONT COLOR=#ffffff FACE= Arial  SIZE=2><b>Start Time</b></td>\n");
			out.write("<td width=20% align= center  bgcolor=#427ea6><FONT COLOR=#ffffff FACE= Arial  SIZE=2><b>End Time</b></td>\n");

			out.write("</tr>\n");
			out.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {

			fstream = null;
			out = null;
		}
	}

	public static void endSuite() {
		FileWriter fstream = null;
		BufferedWriter out = null;

		try {
			fstream = new FileWriter(indexResultFilename, true);
			out = new BufferedWriter(fstream);
			out.write("</table>\n");
			out.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {

			fstream = null;
			out = null;
		}

	}

	public static void addTestCase(String testCaseName, String testCaseStartTime, String testCaseEndTime, String status) {
		newTest = true;
		FileWriter fstream = null;
		BufferedWriter out = null;
		

		try {
			newTest = true;
			// build the keywords page
			if (status.equalsIgnoreCase("Skipped") || status.equalsIgnoreCase("Skip")) {

			} else {
				File f = new File(currentDir + "//" + currentSuiteName + "_TC" + tcid + "_" + testCaseName.replaceAll(" ", "_") + ".html");
				f.createNewFile();
				fstream = new FileWriter(currentDir + "//" + currentSuiteName + "_TC" + tcid + "_" + testCaseName.replaceAll(" ", "_") + ".html");
				out = new BufferedWriter(fstream);
				out.write("<html>");
				out.write("<head>");
				out.write("<title>");
				out.write(testCaseName + " Detailed Reports");
				out.write("</title>");
				out.write("</head>");
				out.write("<body style=\"background-color:rgb(240, 240, 240)!important\">");

				//out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZE=4.5> Detailed Report : UnifiedSettings</h4>");
				out.write("<h4> <FONT COLOR=#41a3f2 FACE=Arial SIZE=4.5> <u> Detailed Report : UnifiedSettings</h4>");
				out.write("<table  border=1 cellspacing=1    cellpadding=1 width=100%>");
				out.write("<tr> ");	
				out.write("<td align=center width=10%  align=center bgcolor=#427ea6><FONT COLOR=#ffffff FACE=Arial SIZE=2.75><b>Step/Row No</b></td>");
				out.write("<td align=center width=50% align=center bgcolor=#427ea6><FONT COLOR=#ffffff FACE=Arial SIZE=2.75><b>Description</b></td>");
				out.write("<td align=center width=10% align=center bgcolor=#427ea6><FONT COLOR=#ffffff FACE=Arial SIZE=2.75><b>Keyword</b></td>");
				out.write("<td align=center width=15% align=center bgcolor=#427ea6><FONT COLOR=#ffffff FACE=Arial SIZE=2.75><b>Result</b></td>");
				out.write("<td align=center width=15% align=center bgcolor=#427ea6><FONT COLOR=#ffffff FACE=Arial SIZE=2.75><b>Screen Shot</b></td>");
	
				out.write("</tr>");
				if (description != null) {
					for (int i = 0; i < description.size(); i++) {
						out.write("<tr> ");

						out.write("<td align=Left width=10%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>TS" + (i + 1) + "</b></td>");
						out.write("<td align=left width=50%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>" + description.get(i) + "</b></td>");
						out.write("<td align=Left width=10%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>" + keyword.get(i) + "</b></td>");
						if (teststatus.get(i).startsWith("Pass"))
							out.write("<td width=20% align= center  bgcolor=#BCE954><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>" + teststatus.get(i) + "</b></td>\n");
						else if (teststatus.get(i).startsWith("Fail"))
							out.write("<td width=20% align= center  bgcolor=Red><FONT COLOR=#153E7E FACE= Arial  SIZE=2><b>" + teststatus.get(i) + "</b></td>\n");

						
						if (screenShotPath.get(i) != null)
							{
							out.write("<td align=center width=20%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b><a href=" + screenShotPath.get(i) + " target=_blank>Screen Shot</a></b></td>");
							
							}
						    
						else
							out.write("<td align=left width=20%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>&nbsp;</b></td>");
						out.write("</tr>");
					}
				}

				out.close();

			  }

			fstream = new FileWriter(indexResultFilename, true);
			out = new BufferedWriter(fstream);

			fstream = new FileWriter(indexResultFilename, true);
			out = new BufferedWriter(fstream);
			// out.newLine();

			out.write("<tr>\n");
			// System.out.println(currentSuitePath);
			out.write("<td width=10% align= center ><FONT COLOR=#153E7E FACE= Arial  SIZE=2><b>" + scriptNumber + "</b></td>\n");
			if (status.equalsIgnoreCase("Skipped") || status.equalsIgnoreCase("Skip"))
				out.write("<td width=40% align= center ><FONT COLOR=#153E7E FACE= Arial  SIZE=2><b>" + testCaseName + "</b></td>\n");
			else
				out.write("<td width=40% align= center ><FONT COLOR=#153E7E FACE= Arial  SIZE=2><b><a href=file:///" + currentDir + "//" + currentSuiteName + "_TC" + tcid + "_" + testCaseName.replaceAll(" ", "_") + ".html>" + testCaseName + "</a></b></td>\n");

			tcid++;
			if (status.startsWith("Pass"))
				out.write("<td width=10% align= center  bgcolor=#BCE954><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>" + status + "</b></td>\n");
			else if (status.startsWith("Fail"))
				out.write("<td width=10% align= center  bgcolor=Red><FONT COLOR=#153E7E FACE= Arial  SIZE=2><b>" + status + "</b></td>\n");
			else if (status.equalsIgnoreCase("Skipped") || status.equalsIgnoreCase("Skip"))
				out.write("<td width=10% align= center  bgcolor=yellow><FONT COLOR=153E7E FACE=Arial SIZE=2><b>" + status + "</b></td>\n");

			out.write("<td width=20% align= center ><FONT COLOR=#153E7E FACE= Arial  SIZE=2><b>" + testCaseStartTime + "</b></td>\n");
			out.write("<td width=20% align= center ><FONT COLOR=#153E7E FACE= Arial  SIZE=2><b>" + testCaseEndTime + "</b></td>\n");

			out.write("</tr>\n");

			scriptNumber++;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		description = new ArrayList<String>();
		keyword = new ArrayList<String>();
		teststatus = new ArrayList<String>();
		screenShotPath = new ArrayList<String>();
		newTest = false;
	}

	public static void addKeyword(String desc, String key, String stat, String path) {
	

		description.add(desc);
		keyword.add(key);
		teststatus.add(stat);
		screenShotPath.add(path);
	}

	public static void updateEndTime(String endTime) {
		StringBuffer buf = new StringBuffer();
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(indexResultFilename);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			// Read File Line By Line

			while ((strLine = br.readLine()) != null) {

				if (strLine.indexOf("END_TIME") != -1) {
					strLine = strLine.replace("END_TIME", endTime);
				}
				buf.append(strLine);

			}
			// Close the input stream
			in.close();
			System.out.println(buf);
			FileOutputStream fos = new FileOutputStream(indexResultFilename);
			DataOutputStream output = new DataOutputStream(fos);
			output.writeBytes(buf.toString());
			fos.close();

		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

	}

}
