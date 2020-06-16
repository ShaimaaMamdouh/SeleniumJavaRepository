package MercuryToursPackage;
import org.junit.Test;
import org.openqa.selenium.By;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Login {

	@Test
	public void LoginCredentials(String userName, String Password) {
		try {
			LaunchBrowser.driver.findElement(By.name("userName")).sendKeys(userName);		  
			LaunchBrowser.driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input")).sendKeys(Password);
			LaunchBrowser.driver.findElement(By.name("submit")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void CheckSucessLogin() throws Exception {
		String sucessMsg=LaunchBrowser.driver.findElement(By.tagName("h3")).getText();
		
	    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("TC1_Flightreservation", "Status report for TC1_Flightreservation");

		if (sucessMsg.contentEquals("Login Successfully"))
		{
			test.pass("User Logged in successfully");
		}
		else
		{
			test.fail("User can't Logged in successfully");
			test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

			// test with snapshot
			test.addScreenCaptureFromPath("screenshot.png");
		}
		// calling flush writes everything to the log file
		//extent.flush();

	}
}
