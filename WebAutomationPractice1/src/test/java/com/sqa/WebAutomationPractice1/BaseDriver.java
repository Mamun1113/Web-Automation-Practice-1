package com.sqa.WebAutomationPractice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {

	static WebDriver driver;

	String browserName = System.getProperty("browser", "chrome");

	// runs at first
	@BeforeSuite
	public void start() {
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else {
			System.out.println("Chrome driver error!");
		}
	}

	// runs at last
	@AfterSuite
	public void close() {
		driver.close();
	}
}
