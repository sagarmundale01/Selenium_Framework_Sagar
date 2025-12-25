package e2eautomation_book;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionOnWebElement {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://practice.bpbonline.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		WebElement searchField = driver.findElement(By.name("keywords"));
	
		//clear action
		searchField.clear();
		//type action
		searchField.sendKeys("mouse");
		WebElement quickFind = driver.findElement(By.xpath("//input[@title=' Quick Find ']"));
		//click action
		quickFind.click();
		//driver.close();
		
	}
}
