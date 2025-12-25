package e2eautomation_book;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindingElements {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://practice.bpbonline.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement myAccountLink = driver.findElement(By.linkText("My Account"));
		myAccountLink.click();
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		for(WebElement link:allLinks)
		{
			System.out.println(link.getText());
		}
		
		driver.close();
				
	}
}
