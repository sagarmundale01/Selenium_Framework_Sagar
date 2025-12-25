package udemy.learning;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Miscelleanous {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("testuser");
		driver.findElement(By.id("pass")).sendKeys("testpass");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		System.out.println(driver.getTitle());
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    Files.copy(src, new File("C:\\Users\\sagar\\OneDrive\\Desktop\\Screenshot1.png"));
	    
		driver.manage().deleteCookieNamed("sessionKey");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		
		
		// click on any link
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// login page- verify login url
		driver.get("http://google.com");
		System.out.println(driver.getTitle());

	    File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    Files.copy(src1, new File("C:\\Users\\sagar\\OneDrive\\Desktop\\Screenshot2.png"));
	    		
		driver.quit();

	}

}
