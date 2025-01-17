package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framworkUtility.DriverSetup;
import utility.ExcelUtility;
import utility.captureUtility;

public class DummyPage_AT {
	private WebDriver driver;
	
	
@Test
public void Login() {
	/*
	 * String Filename = "/TestExcelSheet.xlsx"; String SheetName = "cred";
	 * System.out.println("Automation Test FrameWork ");
	 * System.out.println("Total Rows : "+ExcelUtility.getRowCount(Filename,
	 * SheetName)); String FetchedString = ExcelUtility.getString(1, 0, Filename,
	 * SheetName); System.out.println("TestCase ID : "+(int)ExcelUtility.getInt(1,
	 * 2, Filename, SheetName)); System.out.println("USername is : "+FetchedString);
	 * ExcelUtility.putString(1, 3, Filename, SheetName, "Completed");
	 */
	driver = DriverSetup.getDriver("chrome");
	driver.get("https://login.live.com");
	captureUtility.CaptureScrrenshot(driver,"TestPIC");

	driver.close();
}

@BeforeMethod
public void BeforMethod() {
	
}

}
