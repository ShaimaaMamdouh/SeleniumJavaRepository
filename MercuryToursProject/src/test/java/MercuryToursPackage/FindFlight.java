package MercuryToursPackage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

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

		if(Noflights.contains("No Seats Avaialble")) {

			TC1_FlightReservation.test.pass("No flights found with the selected search critera");
		}
		else
		{
			TC1_FlightReservation.test.log(Status.INFO, "This step shows usage of log(status, details)");
		}
		// calling flush writes everything to the log file
		TC1_FlightReservation.extent.flush();
	}

}
