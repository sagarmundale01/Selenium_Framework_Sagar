package udemy.learning;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitConditionsHitesh {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Navigate to Gmail
		driver.get("https://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// implicit wait
		driver.findElement(By.id("identifierId")).sendKeys("sagar1@gmail.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.id("password")).sendKeys("Pswd1");
		driver.findElement(By.id("signIn")).click();

		// explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));

		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("elementId")));
		driver.quit();

	}

}
