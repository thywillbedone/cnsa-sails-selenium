package test.ual.cnsa.delia.profile;

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

public class ProfileMailTest {
	private WebDriver driver;
	JavascriptExecutor js;
	private Map<String, Object> vars = new HashMap();

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
	public void profileMail() {
		driver.get("http://localhost:1337/login");
		driver.manage().window().setSize(new Dimension(1366, 741));
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".button-text")));
		}
		{
			WebElement element = driver.findElement(By.xpath("//input[@type=\'email\']"));
			Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
			assertTrue(isEditable);
		}
		driver.findElement(By.xpath("//input[@type=\'email\']")).click();
		driver.findElement(By.xpath("//input[@type=\'email\']")).sendKeys("user02@mail.com");
		driver.findElement(By.xpath("//input[@type=\'password\']")).click();
		driver.findElement(By.xpath("//input[@type=\'password\']")).sendKeys("123");
		driver.findElement(By.cssSelector(".ajax-button")).click();
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.urlContains("welcome"));
		}
		driver.findElement(By.xpath("//a[contains(text(),'Update my email')]")).click();
		{
			List<WebElement> elements = driver
					.findElements(By.xpath("//button[@type=\'submit\']//span[text()=\'Save changes\']"));
			assert (elements.size() > 0);
		}
		{
			WebElement element = driver.findElement(By.id("full-name"));
			Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
			assertTrue(isEditable);
		}
		{
			WebElement element = driver.findElement(By.id("email-address"));
			Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
			assertTrue(isEditable);
		}
		assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Update personal info"));
		assertThat(driver.findElement(By.cssSelector(".col-sm-6:nth-child(1) label")).getText(), is("Full name"));
		driver.findElement(By.id("email-address")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		driver.findElement(By.id("email-address")).sendKeys("usermail.com");
		driver.findElement(By.cssSelector(".button-text")).click();
		vars.put("message", js.executeScript("return document.getElementById(\"email-address\").validationMessage"));
		System.out.println(vars.get("message").toString());
//		String mensajeError = "Please include an \'@\' in the email address. \'usermail.com\' is missing an \'@\'.";
		String mensajeError = "Please enter an email address.";
		assertEquals(vars.get("message").toString(), mensajeError);
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".button-text"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("email-address")).click();
		driver.findElement(By.id("email-address")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		driver.findElement(By.id("email-address")).sendKeys("user02@mail.com");
		driver.findElement(By.cssSelector(".button-text")).click();
		{
			List<WebElement> elements = driver.findElements(By.linkText("Edit profile"));
			assert (elements.size() > 0);
		}
		assertThat(driver.findElement(By.cssSelector(".row:nth-child(5) strong")).getText(), is("user02@mail.com"));
		driver.findElement(By.id("header-account-menu-link")).click();
		driver.findElement(By.linkText("Sign out")).click();
	}
}
