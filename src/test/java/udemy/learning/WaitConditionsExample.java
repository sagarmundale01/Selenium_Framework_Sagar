package udemy.learning;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitConditionsExample {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait

		driver.findElement(By.id("Email")).sendKeys("sagar1@gmail.com");
		driver.findElement(By.id("Passwd")).sendKeys("Pswd1");
		driver.findElement(By.id("signIn")).click();

		// explicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));

		// FluentWait --provides extra flexibility and operations
		FluentWait<WebDriver> wait1 = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
				                                              .pollingEvery(Duration.ofSeconds(2))
				                                              .ignoring(NoSuchElementException.class);

		wait1.until(ExpectedConditions.elementToBeClickable(By.id("elementId")));

		Boolean element = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("elementId")));
		element.equals(true);

		driver.quit();

	}

}
