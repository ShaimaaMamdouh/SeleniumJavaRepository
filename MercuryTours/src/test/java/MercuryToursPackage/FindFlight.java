package MercuryToursPackage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.Test;

public class FindFlight {

	@Test
	public void ClickOnFlightsLinks() {
		LaunchBrowser.driver.findElement(By.linkText("Flights")).click();
		//selecting "one way" option
		LaunchBrowser.driver.findElement(By.xpath("//body//b//input[2]")).click();
		//Selecting August from "On" drop down list
		LaunchBrowser.driver.findElement(By.xpath("//select[@name='fromMonth']//option[contains(text(),'August')]")).click();
		LaunchBrowser.driver.findElement(By.name("findFlights")).click();
		String Noflights= LaunchBrowser.driver.findElement(By.xpath("/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/p[1]/font[1]/b[1]/font[1]")).getText();

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("Check flights availability ", "Check flights availability");
		if(Noflights.contains("No Seats Avaialble")) {

			test.pass("No flights found with the selected search critera");
		}
		else
		{
			test.log(Status.INFO, "This step shows usage of log(status, details)");
		}

	}

}
