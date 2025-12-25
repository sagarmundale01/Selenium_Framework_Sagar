package e2eautomation_book;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlert_PromptBox {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Alert alertBox = driver.switchTo().alert(); // accept the alert

		String textOnAlert = alertBox.getText(); // fetch text from alert
		System.out.println(textOnAlert);
		alertBox.sendKeys("Hello How are you? Sagar this side");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		alertBox.accept();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		if (driver.findElement(By.xpath("//p[@id='result']")).getText().contains("are you")) {
			System.out.println("Alert was Handled");
		} else {
			System.out.println("Alert was not handled");
		}

		// driver.close();

	}

}
