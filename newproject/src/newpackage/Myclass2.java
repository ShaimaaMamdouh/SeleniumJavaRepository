package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class Myclass2 {
	public static void main(String[] args) throws Exception
	{
        // declaration and instantiation of objects/variables
    	//System.setProperty("webdriver.gecko.driver","C:\\Users\\shaimaa.mohammed\\eclipse-workspace\\newproject\\WebDrivers\\geckodriver.exe");
    	
    	//WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shaimaa.mohammed\\eclipse-workspace\\newproject\\WebDrivers\\chromedriver_83.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle))
        {
        	
            System.out.println("Test Passed!");
        } else 
        {
            System.out.println("Test Failed");
        }
        driver.findElement(By.name("userName")).sendKeys("Mercury");
        //Thread.sleep(4000);
        
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input")).sendKeys("Mercury");
       // Thread.sleep(4000);
        driver.findElement(By.name("submit")).click();
        Thread.sleep(4000);
       
        driver.findElement(By.linkText("Flights")).click();
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]")).click();
       
          
        //close Fire fox
        //driver.close();
       
    }

}
