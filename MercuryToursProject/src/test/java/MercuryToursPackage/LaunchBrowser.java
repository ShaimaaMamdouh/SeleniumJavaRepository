package MercuryToursPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class LaunchBrowser {
	public static WebDriver driver; 
	@BeforeTest
	public void Lunch()
	{
		String driverPath="C:\\Users\\shaimaa.mohammed\\eclipse-workspace\\MercuryTours\\WebDrivers\\chromedriver_83.exe";
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver = new ChromeDriver();
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// launch Chrome and direct it to the Base URL
		driver.get(baseUrl);
	}

	@BeforeTest
	public void TitleCheck() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";
		actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(expectedTitle))
		{
			TC1_FlightReservation.test.pass("Browser launched successfully!");
		} else 
		{
			TC1_FlightReservation.test.fail("Browser wasn't launched successfully :(");
		}
	}

	
}
