package e2eautomation_book;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {

	public static void main(String[] args) throws Exception {
		
		//setup chromedriver with WebDriverManager
		
		WebDriver driver;
		//WebDriverManager.chromedriver().setup();
			
		//setup firefoxdriver [geckdriver] with WebDriverManager
		//WebDriverManager.firefoxdriver().setup();
		
		//create instance of chrome
		driver = new ChromeDriver();
		
		//create instance of fireforx
		//WebDriver driver1 = new FirefoxDriver();
		
		
		driver.get("http://www.Selementslearning.dev/demosite");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
        driver.close();
	}

}
