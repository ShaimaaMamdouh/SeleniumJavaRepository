package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.ExtentReports



public class ExtentReports {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shaimaa.mohammed\\eclipse-workspace\\newproject\\WebDrivers\\chromedriver_83.exe");
		WebDriver driver = new ChromeDriver();
    	
        String GoogleURL = "https://www.google.com//";
   
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // launch Fire fox and direct it to the Base URL
        driver.get(GoogleURL);
        driver.findElement(By.name("q")).sendKeys("ExtentReports");
        driver.findElement(By.name("btnK")).click();
        
        
        
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

        // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
        
        // calling flush writes everything to the log file
        extent.flush();
       
	}

}
