package com.rs.playground.test.cucumber.stepdefinitions;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rs.playground.test.cucumber.common.Drivers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private static WebDriver driver;

	@Given("user is on landing page")
	public void user_is_on_landing_page() {
		driver = Drivers.getDriver();
		driver.get("https://demo.thingsboard.io/");
	}

	@Given("Sign in button is present on screen")
	public void sign_in_button_is_present_on_screen() {
		Assertions.assertNotNull(driver.findElement(
				By.partialLinkText("Login")));
	}

	@When("user enters {string} in username field")
	public void user_enters_in_username_field(String username) {
		WebElement usernameInput = driver.findElement(By.id("username-input"));
		Assertions.assertNotNull(usernameInput);
		usernameInput.sendKeys(username);
	}

	@When("user enters {string} in password field")
	public void user_enters_in_password_field(String password) {
		WebElement passwordInput = driver.findElement(By.id("password-input"));
		Assertions.assertNotNull(passwordInput);
		passwordInput.sendKeys(password);
	}

	@When("user clicks Sign in button")
	public void user_clicks_sign_in_button() {
		List<WebElement> elements = driver.findElements(By.className("mat-button"));
		System.out.println("element:" + elements.size());
		Assertions.assertTrue(elements.size() == 2);
		elements.get(1).click();
	}

	@Then("title of page is {string}")
	public void title_of_page_is(String title) {

		// Wait for the page to load
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Title:" + driver.getTitle());
				return driver.getTitle().contentEquals(title);
			}
		});
	}
	
	@Given("user is logged")
	public void user_is_logged() {
	    WebElement element = driver.findElement(By.className("tb-user-display-name"));
	    Assertions.assertEquals("Resul Sahin", element.getText());	    
	}

	@When("user clicks Devices link")
	public void user_clicks_devices_link() {
		WebElement element = driver.findElement(By.partialLinkText("Devices"));
		element.click();
	}
	
	@Then("devices are listed")
	public void devices_are_listed() {
		WebElement element = driver.findElement(By.className("mat-table"));
		List<WebElement> elements = element.findElements(By.className("mat-row"));
		
		System.out.println("Size:" + elements.size());
		
		Assertions.assertTrue(elements.size() > 0);
	}
}
