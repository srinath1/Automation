package Academy;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;  // ADD THIS IMPORT

public class BrowserTest {

	
	@Test
	public void getData()
	{
		System.out.println("Hello Guys");
		
		// REPLACE this line: System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		// WITH these two lines:
		WebDriverManager.chromedriver().setup();  // Automatically downloads correct ChromeDriver
		
		// Optional but RECOMMENDED for Azure DevOps (headless mode)
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");        // Runs Chrome without UI
		options.addArguments("--no-sandbox");      // Required for Azure DevOps
		options.addArguments("--disable-dev-shm-usage"); // Prevents crashes
		
		WebDriver driver = new ChromeDriver(options);  // Use options here
		driver.get("https://rahylshettyacademy.azurewebsites.net/webapp/");
		String text = driver.findElement(By.cssSelector("h1")).getText();
		System.out.println(text);
		Assert.assertTrue(text.equalsIgnoreCase("AzureFPO"));
		driver.close();
	}
}
