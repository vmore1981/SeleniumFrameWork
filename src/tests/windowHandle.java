package tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import utils.BrowserUtils;
import pages.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DataReader;


public class windowHandle {

	
	public static void main(String[] args) throws InterruptedException {
		
		testCase2();
		
	}
	
	public static void testCase1() throws InterruptedException {
		
/*		
		TEST CASE 1

		1. go to http://practice.primetech-apps.com/practice/browser-windows
		2. Click on 'New Tab' button.
		3. Then get the window handles and print what are they.
*/		
		
		BrowserUtils utils = new BrowserUtils();
		
		page pageItems = new page();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		driver.get(DataReader.getProperty("url"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));
		
		String mainWindowID = driver.getWindowHandle();
		System.out.println("Main Window Handle_ID is: " + mainWindowID);

		driver.findElement(By.id("tabButton")).click();

		
		
		Set <String> mainWindowsID = driver.getWindowHandles();
		
		String newWindow = mainWindowID;
		
		for(String windowSingle : mainWindowsID) {
				
			if(!windowSingle.equals(mainWindowID)) {
				newWindow = windowSingle;				
				System.out.println("TAB window Handle_ID is:    " + newWindow);
			}
		}

		driver.close();
		
		driver.quit();
		
	}

	
	public static void testCase2() throws InterruptedException {

/*
		TEST CASE 2
		
		go to http://practice.primetech-apps.com/practice/browser-windows
		1. Get the main window ID and store it in a String called mainWindowId,
		2. Click on the 'New Tab' button
		3. Get window IDs and store it into a Set
		4. Get the first window ID from the Set and Verify it matches with the main window id
		in step 1. Then get the second window id and store it in variable called
		secondWindowId.
		5. Switch to the second window
		6. Verify that there is a button called 'New Tab'
		7. Close the window, Switch back to the main window, Verify you are on the main
		window.
*/
		
		BrowserUtils utils = new BrowserUtils();
		
		page pageItems = new page();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		driver.get(DataReader.getProperty("url"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));
		
		String mainWindowId = driver.getWindowHandle();
		
		System.out.println("Main Window ID is:      " + mainWindowId);
		
		driver.findElement(By.id("tabButton")).click();

		
		
		Set <String> mainWindowsId = driver.getWindowHandles();
		
		String firstWindowId = null;
		String secondWindowId = null;
		
		for(String windowSingle : mainWindowsId) {
				
			if(windowSingle.equals(mainWindowId)) {
			
				firstWindowId = windowSingle;				
				System.out.println("FIRST window Handle:    " + firstWindowId);
				
			} else {
				
				secondWindowId = windowSingle;				
				System.out.println("SECOND window Handle:   " + secondWindowId);
				
			}
		}

/*
		5. Switch to the second window.
		6. Verify that there is a button called 'New Tab'.
		7. Close the window, Switch back to the main window, Verify you are on the main window.
*/
		
	//	driver.close();
		
		driver.switchTo().window(secondWindowId);
		
		
		// SHIT HAPPENDS
		
		By locator = By.id("tabButton");
		
		if(driver.findElements(locator).size()>0) {
			
			System.out.println("TAB BUTTON IS PRESENT");
						
		} else {
			
			System.out.println("TAB BUTTON IS NOT HERE");
						
		}		
				
		driver.switchTo().window(mainWindowId);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));

		System.out.println("STEP almost DONE");
		driver.findElement(By.id("tabButton")).click();
		
		System.out.println("ALL IS DONE! FINAL");
		
		
		driver.quit();
		
	}

	
	
	
}
