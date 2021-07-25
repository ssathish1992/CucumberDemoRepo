package StepDefinition;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class SDefinition {

	WebDriver driver;

	int n = 18;

	String firstname = "Sample" + n;
	String lastname = "Test" + n;

	

	int length = firstname.length();
	// System.out.println(length);
	int length2 = lastname.length();
	// System.out.println(length2);

	String emailAddress = firstname + lastname + "@gmail.com";

	@Given("Login to Application")
	public void login_to_application() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\08980D744\\Desktop\\JigSaw\\Driver\\chromedriver.exe");
		// i am trying to create a new instance of chrome driver
		driver = new ChromeDriver();
		// WedDriver driver - new ChromeDriver()
		// ChromeDriver driver = new ChromeDriver()
		// i want to be the login page //what should i do
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Given("Register in Application")
	public void register_in_application() {

		driver.findElement(By.xpath("//*[contains(text(),'Sign up!')]")).click();
		driver.findElement(By.xpath("//*[contains(@name,'firstname')]")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[contains(@name,'lastname')]")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[contains(@name,'email')]")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//*[contains(@name,'username')]")).sendKeys(firstname + lastname);
		driver.findElement(By.xpath("//*[contains(@name,'pass1')]")).sendKeys("1qa2ws3ed4rf");
		driver.findElement(By.xpath("//*[contains(@name,'pass2')]")).sendKeys("1qa2ws3ed4rf");
		driver.findElement(By.xpath("//*[contains(@name,'phone')]")).sendKeys("9876543211");
		driver.findElement(By.xpath("//*[contains(@name,'submit')]")).submit();

		String elementText = driver.findElement(By.xpath("//p[contains(text(),'Dear')]")).getText();

		String actualFirstLine = elementText.substring(0, (firstname.length() + lastname.length() + 6));

		System.out.println(actualFirstLine);

		String expectedFirstLine = "Dear" + " " + firstname + " " + lastname;
		String expectedSecondLine = "Your personal settings have been registered.";

		String actualSecondLine = elementText.substring((firstname.length() + lastname.length() + 9),
				elementText.length());

		System.out.println(actualSecondLine);

		Assert.assertEquals(expectedFirstLine, actualFirstLine);
		Assert.assertEquals(expectedSecondLine, actualSecondLine);
		System.out.println("==========================================================");

	}

	@Given("Validating in Homepage")
	public void validating_in_homepage() {

		driver.findElement(By.xpath("//*[contains(@title,'Homepage')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Compose')]")).click();

		driver.findElement(By.xpath("//*[contains(@placeholder,'Please select an option')]")).sendKeys("sample");

		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//li[contains(text(),'sample sample (sample123)')]"))).click()
				.build().perform();

		String subject = "Hi for Testing";

		driver.findElement(By.xpath("//*[contains(@id,'compose_message_title')]")).sendKeys(subject);
		String message = "Hi Mr.Sathish,\r\n" + "This is for Testing.\r\n" + "\r\n" + "\r\n" + "Thanks&Regards,\r\n"
				+ "Sathish";

		driver.findElement(By.xpath("//span[contains(@class,'cke_button_icon cke_button__newpage_icon')]")).click();

		driver.switchTo().frame(0);

		driver.findElement(
				By.xpath("//*[contains(@class,'cke_editable cke_editable_themed cke_contents_ltr cke_show_borders')]"))
				.sendKeys(message);
		driver.switchTo().parentFrame();

		driver.findElement(By.xpath("//*[contains(@id,'compose_message_compose')]")).click();

		String text = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]")).getText();

		System.out.println(text);

		driver.close();

	}

}

/*
 * 
 * 
 * 
 * @Given("Login page") public void login_page() {
 * 
 * System.setProperty("webdriver.chrome.driver",
 * "C:\\Users\\08980D744\\Desktop\\JigSaw\\Driver\\chromedriver.exe"); // i am
 * trying to create a new instance of chrome driver driver = new ChromeDriver();
 * // WedDriver driver - new ChromeDriver() // ChromeDriver driver = new
 * ChromeDriver() // i want to be the login page //what should i do
 * driver.get("https://opensource-demo.orangehrmlive.com/");
 * 
 * }
 * 
 * @When("Enter valid name {string}") public void enter_valid_name(String name)
 * { driver.findElement(By.id("txtUsername")).sendKeys(name); }
 * 
 * @When("Enter valid password {string}") public void
 * enter_valid_password(String pwd) {
 * driver.findElement(By.id("txtPassword")).sendKeys(pwd); }
 * 
 * @When("Click on Submit button") public void click_on_submit_button() {
 * driver.findElement(By.id("btnLogin")).click(); }
 * 
 * @Then("I shoud see the username as {string}") public void
 * i_shoud_see_the_username_as(String text) throws InterruptedException { String
 * Actual = driver.findElement(By.id("welcome")).getText();
 * 
 * // String Expected = "Welcome Paul"; Assert.assertEquals(text, Actual);
 * 
 * // I will logout driver.findElement(By.id("welcome")).click();
 * Thread.sleep(3000);
 * driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]")).click();
 * System.out.println("I am Successfull Logout");
 * 
 * driver.close(); driver.quit(); }
 * 
 * // Second scenario
 * 
 * @When("Enter invalid name {string}") public void enter_invalid_name(String
 * invalidname) {
 * driver.findElement(By.id("txtUsername")).sendKeys(invalidname); }
 * 
 * @When("Enter invalid password {string}") public void
 * enter_invalid_password(String invalidPwd) {
 * driver.findElement(By.id("txtPassword")).sendKeys(invalidPwd); }
 * 
 * @Then("I shoud see the pagetitle as {string}") public void
 * i_shoud_see_the_pagetitle_as(String pageTitle) {
 * 
 * String Actual = driver.getTitle();
 * 
 * // String Expected = "Welcome Paul"; Assert.assertEquals(pageTitle, Actual);
 * 
 * driver.close(); driver.quit();
 * 
 * }
 * 
 * }
 * 
 * 
 */