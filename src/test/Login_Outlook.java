package test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import framworkUtility.DriverSetup;
import utility.ExcelUtility;

public class Login_Outlook {
	
	
	private WebDriver driver; 
	private String file= "Credentials.xlsx";
	private String sheet = "Sheet1";
	
	@Test
	public void Login() throws InterruptedException {
		driver = DriverSetup.getDriver("chrome");
		driver.get("https://login.live.com");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		String email = ExcelUtility.getString(1,0,file,sheet);
		String pswd = ExcelUtility.getString(1, 1, file, sheet);
		
		WebElement email_txtBox = driver.findElement(By.xpath("//input[contains(@Placeholder,'Email')]"));
		email_txtBox.sendKeys(email);
		WebElement next_btn = driver.findElement(By.xpath("//button[contains(@id,'idSIButton')]"));
		next_btn.click();
		Thread.sleep(3000);
		WebElement pswd_txtBox = driver.findElement(By.xpath("//input[contains(@Placeholder,'Password')]"));
		wait.until(ExpectedConditions.elementToBeClickable(pswd_txtBox));
		pswd_txtBox.sendKeys(pswd);
		Thread.sleep(1000);
		WebElement next_btn2 = driver.findElement(By.xpath("//button[contains(@id,'idSIButton')]"));
		//wait.until(ExpectedConditions.visibilityOf(next_btn));
		next_btn2.click();
		Thread.sleep(500);
		WebElement yes_btn = driver.findElement(By.xpath("//button[text()='Yes']"));
		yes_btn.click();
		
		driver.navigate().to("https://www.bing.com/");
		
		WebElement serach = driver.findElement(By.xpath("//textarea[@id='sb_form_q']"));
		wait.until(ExpectedConditions.elementToBeClickable(serach));
		serach.sendKeys("Shivraj",Keys.ENTER);
		System.out.println("Login Completed");
		driver.navigate().refresh();
		int count = 1;
		/*do {
			String generatedString = generateRandomString(6);
			System.out.println(generatedString);
			WebElement txt = driver.findElement(By.xpath("//input[@class='b_searchbox ']"));
			txt.sendKeys(generatedString+Keys.ENTER);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@class='b_searchbox ']")).clear();
			count++;
		}
		while(count<10);*/
		
	System.out.println("Search Completed "+ count +"Times");

	}
	
	public static String generateRandomString(int length) {
        // Define the characters allowed in the string
        String charPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charPool.length()); // Get a random index
            randomString.append(charPool.charAt(index)); // Append the character at that index
        }

        return randomString.toString();
    }
	
	
	@Test
	public void rewardsClicker() {
		driver.navigate().to("https://rewards.bing.com/?ref=rewardspanel");
		List<WebElement> cards = driver.findElements(By.cssSelector("div.rewards-card-container"));
		String parentwindow = driver.getWindowHandle();
		for(int i =2; i<cards.size();i++) {
			cards.get(i).click();
			driver.switchTo().window(parentwindow);
			System.out.println("Window"+i);
		}
		
		System.out.println("All Windows Done");
	}
	
	/*@AfterSuite
	public void beforeSuite() {
		try {
            // Execute the taskkill command to close all Chrome processes
            String command = "taskkill /F /IM chrome.exe /T";
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            System.out.println("All Chrome processes have been closed.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
		
	}*/

}
