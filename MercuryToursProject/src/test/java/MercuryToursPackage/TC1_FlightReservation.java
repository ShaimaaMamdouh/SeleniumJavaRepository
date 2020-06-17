package MercuryToursPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TC1_FlightReservation {
	//Extent report definition for TC1_FlightReservation
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void main(String[] args) throws Exception {
		//Extent report declaration for TC1_FlightReservation
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("TC1_Flightreservation", "Status report for TC1_Flightreservation");
		
		LaunchBrowser chromeBrowser=new LaunchBrowser();
		chromeBrowser.Lunch();
		chromeBrowser.TitleCheck();
		
		Login user =new Login();
		user.LoginCredentials("Mercury", "Mercury");
		user.CheckSucessLogin();
		
		FindFlight flight= new FindFlight();
		flight.ClickOnFlightsLinks();
		
		CloseBrowser browser=new CloseBrowser();
		browser.Close();
	}
}
