package com.rs.playground.test.cucumber.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rs.playground.test.cucumber.common.Drivers;

import io.cucumber.java.en.Given;

public class CheckPageSteps {

	private static WebDriver driver;

	@Given("user named {string}")
	public void user_named(String name) {
		driver = Drivers.getDriver();
		// Wait for the page to load
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.className("tb-user-display-name"));
				return name.contentEquals(element.getText());
			}
		});
	}

	@Given("user move to home page")
	public void user_move_to_home_page() {
		driver = Drivers.getDriver();
		driver.get("https://demo.thingsboard.io");
	}

}
