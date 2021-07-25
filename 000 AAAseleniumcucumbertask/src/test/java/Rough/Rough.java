package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Rough {
	WebDriver driver;

	@Given("Login page")
	public void login_page() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\08980D744\\Desktop\\JigSaw\\Driver\\chromedriver.exe");
		// i am trying to create a new instance of chrome driver
		driver = new ChromeDriver();
		// WedDriver driver - new ChromeDriver()
		// ChromeDriver driver = new ChromeDriver()
		// i want to be the login page //what should i do
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@When("Enter valid name {string}")
	public void enter_valid_name(String name) {
		driver.findElement(By.id("txtUsername")).sendKeys(name);
	}

	@When("Enter valid password {string}")
	public void enter_valid_password(String pwd) {
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	}

	@When("Click on Submit button")
	public void click_on_submit_button() {
		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("I shoud see the username as {string}")
	public void i_shoud_see_the_username_as(String text) throws InterruptedException {
		String Actual = driver.findElement(By.id("welcome")).getText();

		// String Expected = "Welcome Paul";
		Assert.assertEquals(text, Actual);

		// I will logout
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]")).click();
		System.out.println("I am Successfull Logout");

		driver.close();
		driver.quit();
	}

	// Second scenario

	@When("Enter invalid name {string}")
	public void enter_invalid_name(String invalidname) {
		driver.findElement(By.id("txtUsername")).sendKeys(invalidname);
	}

	@When("Enter invalid password {string}")
	public void enter_invalid_password(String invalidPwd) {
		driver.findElement(By.id("txtPassword")).sendKeys(invalidPwd);
	}

	@Then("I shoud see the pagetitle as {string}")
	public void i_shoud_see_the_pagetitle_as(String pageTitle) {

		String Actual = driver.getTitle();

		// String Expected = "Welcome Paul";
		Assert.assertEquals(pageTitle, Actual);

		driver.close();
		driver.quit();

	}

}
