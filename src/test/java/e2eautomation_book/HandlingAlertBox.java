package e2eautomation_book;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlertBox {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Alert alertBox = driver.switchTo().alert(); // accept the alert
		alertBox.accept();

		if (driver.findElement(By.xpath("//p[@id='result']")).getText().contains("You successfully clicked an alert")) {
			System.out.println("Alert was handled");
		} else {
			System.out.println("Alert was not handled");
		}

		driver.close();
	}
}
