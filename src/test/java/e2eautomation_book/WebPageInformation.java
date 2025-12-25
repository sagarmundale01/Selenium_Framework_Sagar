package e2eautomation_book;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebPageInformation {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://practice.bpbonline.com/");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		
		if(driver.getPageSource().contains("Welcome to BPB Online"))
		{
			System.out.println("Page is loaded successfully");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("http://www.selenium.dev");
		
		if(driver.getCurrentUrl().contains("selenium"))
		{
			System.out.println("Page is now changed to Selenium website");
			
		}
		
		driver.quit();
				
		
	}

}
