package framworkUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
	
	public static WebDriver driver ;
	
	
	
	
	public static WebDriver getDriver(String Browser) {
		Browser = Browser.toLowerCase();
		
		switch(Browser) {
		case "chrome":{
		
		try {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("<<<<< Chrome Driver Started Successfully >>>>>");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		}
		case "edge":{
			
		}
		
		}
		return driver;
	}
	

}
