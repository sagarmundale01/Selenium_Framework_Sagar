package e2eautomation_book;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoOfExplicitWait {

	
	public static void main(String[] args) {
		
		WebDriver driver;
		WebDriverWait wait;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://www.practice.bpbonline.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        WebElement myaccount = driver.findElement(By.linkText("My Account"));
		myaccount.click();
		
		WebElement email = driver.findElement(By.name("email_address"));
		email.sendKeys("bpb@bpb.com");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("bpb@123");
		
		driver.findElement(By.xpath("//*[@id=\"tdb5\"]/span[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//explicit wait

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log Off")));
		
		//Logout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.linkText("Log Off")).click();
		driver.findElement(By.linkText("Continue")).click();
        
        driver.close();
        
        
        
        
	}

}
