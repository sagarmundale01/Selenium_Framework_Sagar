package udemy.learning;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		String parentWindowId = it.next();
		String childWindowId = it.next();
		
		driver.switchTo().window(childWindowId);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentWindowId);
		
		driver.findElement(By.id("username")).sendKeys(emailId);
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();

		System.out.println(driver.getTitle());
		
		
		//just to clear and enter new value //practice purpose
		
		WebElement reenterusername = driver.findElement(By.id("username"));
		reenterusername.clear();
		reenterusername.sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.id("signInBtn")).click();
			
		
		
	}

}
