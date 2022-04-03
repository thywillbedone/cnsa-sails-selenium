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

public class RegisterKOMailTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		//System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setHeadless(true);
		driver = new FirefoxDriver(firefoxOptions);
		js = (JavascriptExecutor) driver;
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void registerKOMail() {
		driver.get("https://damp-tor-38829.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1366, 741));
		driver.findElement(By.linkText("Sign up")).click();
		driver.findElement(By.id("full-name")).sendKeys("user02");
		driver.findElement(By.id("email-address")).sendKeys("user02.mail");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.id("confirm-password")).sendKeys("12345");
		driver.findElement(By.id("terms-agreement")).click();
		driver.findElement(By.cssSelector(".button-text")).click();
		vars.put("message", js.executeScript("return document.getElementById(\"email-address\").validationMessage"));
		System.out.println(vars.get("message").toString());
		assertEquals(vars.get("message").toString(),
				"Please include an \'@\' in the email address. \'user02.mail\' is missing an \'@\'.");
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".button-text"));
			assert (elements.size() > 0);
		}
	}
}
