package test.ual.cnsa.delia.register;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class RegisterOKTestTest {
	private WebDriver driver;
	private Map<String, Object> vars = new HashMap();
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setHeadless(false);
		driver = new FirefoxDriver(firefoxOptions);
		js = (JavascriptExecutor) driver;
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void registerOKTest() {
		driver.get("http://localhost:1337/login");
		driver.manage().window().setSize(new Dimension(1366, 741));
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".logo"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.cssSelector(".logo")).click();
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".position-absolute:nth-child(4)"));
			assert (elements.size() > 0);
		}
		assertThat(driver.findElement(By.cssSelector(".display-4 > strong")).getText(), is("Sails"));
		{
			List<WebElement> elements = driver.findElements(By.linkText("Sign up"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.linkText("Sign up")).click();
		assertThat(driver.findElement(By.cssSelector(".container-fluid > .text-center")).getText(),
				is("Create an account"));
		assertThat(driver.findElement(By.cssSelector(".mx-auto > .text-center:nth-child(1)")).getText(),
				is("Let\'s get started! Becoming a member is free and only takes a few minutes."));
		assertThat(driver.findElement(By.cssSelector(".form-group:nth-child(1) > label")).getText(), is("Full name"));
		{
			WebElement element = driver.findElement(By.id("full-name"));
			Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
			assertTrue(isEditable);
		}
		driver.findElement(By.id("full-name")).sendKeys("usuariorandom");
		driver.findElement(By.id("email-address")).click();
		{
			WebElement element = driver.findElement(By.id("email-address"));
			Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
			assertTrue(isEditable);
		}
		vars.put("randomuser", js.executeScript("return \"ual-\" + Math.floor(Math.random()*1500000)+\"@ual.es\""));
		System.out.println(vars.get("randomuser").toString());
		driver.findElement(By.id("email-address")).sendKeys(vars.get("randomuser").toString());
		driver.findElement(By.id("password")).click();
		{
			WebElement element = driver.findElement(By.id("password"));
			Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
			assertTrue(isEditable);
		}
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.id("confirm-password")).click();
		{
			WebElement element = driver.findElement(By.id("confirm-password"));
			Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
			assertTrue(isEditable);
		}
		driver.findElement(By.id("confirm-password")).sendKeys("12345");
		assertThat(driver.findElement(By.cssSelector(".form-check-label")).getText(),
				is("I have read & agree to the terms of service."));
		assertFalse(driver.findElement(By.id("terms-agreement")).isSelected());
		driver.findElement(By.id("terms-agreement")).click();
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".ajax-button"));
			assert (elements.size() > 0);
		}
		assertThat(driver.findElement(By.cssSelector(".ajax-button")).getText(), is("Create account"));
		assertThat(driver.findElement(By.cssSelector(".text-center:nth-child(4)")).getText(),
				is("Have an account? Sign in"));
		{
			List<WebElement> elements = driver.findElements(By.linkText("Sign in"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.cssSelector(".ajax-button")).click();
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.urlContains("welcome"));
		}
		{
			List<WebElement> elements = driver.findElements(By.id("header-account-menu-link"));
			assert (elements.size() > 0);
		}
		assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Welcome!"));
		{
			List<WebElement> elements = driver.findElements(By.linkText("Update my email"));
			assert (elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".btn-outline-info"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("header-account-menu-link")).click();
		driver.findElement(By.linkText("Sign out")).click();
		assertThat(driver.findElement(By.cssSelector(".text-center:nth-child(1)")).getText(),
				is("Sign in to your account"));
	}
}
