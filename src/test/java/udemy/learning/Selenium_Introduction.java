package udemy.learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_Introduction {

	public static void main(String[] args) {

		// Invoking Browser
		// Chrome - ChromeDriver exten->Methods close get
		// Firefox- FirefoxDriver ->methods close get
		// WebDriver close get
		// WebDriver methods + class methods
		// Chrome

		ChromeOptions options = new ChromeOptions();

		// options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());

		driver.close();

		/*
		 * // //Firefox
		 * 
		 * System.setProperty("webdriver.gecko.driver",
		 * "/Users/Lenovo/Documents/geckodriver"); WebDriver driver1 = new
		 * FirefoxDriver();
		 * 
		 * 
		 * //Microsoft Edge System.setProperty("webdriver.edge.driver",
		 * "/Users/lenovo/Documents/msedgedriver");
		 * 
		 * WebDriver driver2 = new EdgeDriver();
		 * 
		 * driver.get("https://rahulshettyacademy.com");
		 * 
		 * System.out.println(driver.getTitle());
		 * 
		 * System.out.println(driver.getCurrentUrl());
		 * 
		 * driver.close();
		 * 
		 * //driver.quit();
		 * 
		 */

	}

}
