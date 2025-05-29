package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LambdaTest {
	WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browserName", "browserVersion", "osName"})
	public void setup(String browserName, String browserVersion, String osName) throws MalformedURLException {
		String username = ""; // Put your username here
		String accessKey = ""; // Put your access key here
		
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", username);
		ltOptions.put("accessKey", accessKey);
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("network", true);
		ltOptions.put("console", true);
		ltOptions.put("project", "Untitled");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		
		MutableCapabilities browserOptions;
		
		if (browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setPlatformName(osName);
			options.setBrowserVersion(browserVersion);
			options.setCapability("LT:Options", ltOptions);
			browserOptions = options;
			System.out.println("Chrome");
		} else {
			EdgeOptions options = new EdgeOptions();
			options.setPlatformName(osName);
			options.setBrowserVersion(browserVersion);
			options.setCapability("LT:Options", ltOptions);
			browserOptions = options;
			System.out.println("Edge");
		}
		
		driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
	}
	
	@Test(timeOut = 20000)
	public void Test() throws InterruptedException {		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Navigating to the URL and maximize the window
		driver.get("https://www.lambdatest.com/");
		driver.manage().window().maximize();

		// Wait for loading all the DOM
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until((Function<WebDriver, Boolean>)webDriver -> (js)
			    .executeScript("return document.readyState").equals("complete"));
		
		// Scroll to the web element
		WebElement exploreAllIntegrations = driver.findElement(By.xpath("//a[contains(text(), 'Explore all Integrations')]"));
		(js).executeScript("arguments[0].scrollIntoView(true);", exploreAllIntegrations);
		
		// Open link in new tab
		String link = exploreAllIntegrations.getDomAttribute("href");
		(js).executeScript("window.open(arguments[0], '_blank');", link);
		
		// Saving and printing the window handles
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windowHandles);
		
		// Switching to the newly opened tab and asserting the URL
		driver.switchTo().window(windowHandles.get(1));
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.lambdatest.com/integrations");
		
		// Scroll to Codeless Automation web element
		WebElement codelessAutomation = driver.findElement(By.id("codeless_row"));
		(js).executeScript("arguments[0].scrollIntoView(true);", codelessAutomation);
		
		// Clicking the link in web element Testing Wiz
		driver.findElement(By.xpath("//a[contains(@href, 'testingwhiz-integration/')]")).click();
		
		// Asserting the page title
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(driver.getTitle(), "TestingWhiz Integration With LambdaTest"); // script continues if assert fails
		
		// Closing the current window and switching back to the first window
		driver.close(); // closing current window at index 1
		driver.switchTo().window(windowHandles.get(0));	// switching to Original tab
		
		// Printing the window count
		System.out.println(driver.getWindowHandles().size());
		
		// Setting the URL to given URL
		driver.navigate().to("https://www.lambdatest.com/blog/");
		
		// Clicking on Community link
		driver.findElement(By.linkText("Community")).click();
		
		// Verifying the current URL
		softAssert.assertEquals(driver.getCurrentUrl(), "https://community.lambdatest.com/");
		
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver!=null) {
			driver.quit();
		}
	}
}

