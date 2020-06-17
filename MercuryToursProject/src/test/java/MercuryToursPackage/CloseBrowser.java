package MercuryToursPackage;
import org.testng.annotations.AfterTest;

public class CloseBrowser {

	@AfterTest
	public void Close()
	{
		LaunchBrowser.driver.close();
	}
}
