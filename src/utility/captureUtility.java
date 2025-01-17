package utility;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class captureUtility {
	WebDriver driver;
	String location ;
	
	public static void CaptureScrrenshot(WebDriver driver,String location) {
		TakesScreenshot scrshot = (TakesScreenshot)driver;
		File cap_shot = scrshot.getScreenshotAs(OutputType.FILE);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");
		String currentDateTime = LocalDateTime.now().format(formatter);
		String filename = "./resources/"+location+currentDateTime+".png";
		try {
			FileUtils.copyFile(cap_shot,new File(filename));
			System.out.println("<<<<< Screenshot Captured and saved >>>>>,"+filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
