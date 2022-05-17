package com.rs.playground.test.cucumber.common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Drivers {

	private static WebDriver driver;

	@BeforeAll
	public static void initialize() {
		System.out.println("openBrowser");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/windows/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=en");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.manage().window().maximize();
	}

	@AfterAll
	public static void close() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
