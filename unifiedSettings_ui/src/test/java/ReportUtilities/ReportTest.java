package ReportUtilities;
import Utilities.TestUtils;
public class ReportTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String startTime = TestUtils.now("dd.MMMM.yyyy hh.mm.ss aaa");
		
		//ReportUtil.startTesting(System.getProperty("user.dir")+"//Reports//US_Detailed_Report.html", startTime, "Bake", "2018.11");
		ReportUtil.startTesting(System.getProperty("user.dir")+"//Reports//US_Detailed_Report.html", startTime, "Null","Null");

		ReportUtil.startSuite("US");

		ReportUtil.addKeyword("Navigate to page", "Navigate", "Passed", null);
	
		ReportUtil.addTestCase("TopNavigation", startTime, TestUtils.now("dd.MMMM.yyyy hh.mm.ss aaa"), "Pass");

		ReportUtil.endSuite();
		ReportUtil.updateEndTime(TestUtils.now("dd.MMMM.yyyy hh.mm.ss aaa"));

	}
}
