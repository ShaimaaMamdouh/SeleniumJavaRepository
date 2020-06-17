package MercuryToursPackage;
import org.junit.Test;
import org.openqa.selenium.By;

import com.aventstack.extentreports.MediaEntityBuilder;

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
	
	public void CheckSucessLogin() throws Exception {
		String sucessMsg=LaunchBrowser.driver.findElement(By.tagName("h3")).getText();



		if (sucessMsg.contentEquals("Login Successfully"))
		{
			TC1_FlightReservation.test.pass("User Logged in successfully");
		}
		else
		{
			TC1_FlightReservation.test.fail("User can't Logged in successfully");
			TC1_FlightReservation.test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			// test with snapshot
			TC1_FlightReservation.test.addScreenCaptureFromPath("screenshot.png");
		}
	}
}
