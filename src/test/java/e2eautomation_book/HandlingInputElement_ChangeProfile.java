package e2eautomation_book;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingInputElement_ChangeProfile {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.practice.bpbonline.com/");

		driver.manage().window().maximize();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.name("email_address")).sendKeys("bpb@bpb.com");
		driver.findElement(By.name("password")).sendKeys("bpb@123");
		driver.findElement(By.id("tdb1")).click();

		// change profile
		driver.findElement(By.linkText("View or change my account information.")).click();

		// change gender if male is selected, select female else select male

		if (driver.findElement(By.xpath("//input[@value='m']")).isSelected()) {
			driver.findElement(By.xpath("//input[@value='f']")).click();
		} else {
			driver.findElement(By.xpath("//input[@value='m']")).click();
		}

		// change phone
		driver.findElement(By.name("telephone")).clear();
		driver.findElement(By.name("telephone")).sendKeys("9876543210");
		driver.findElement(By.id("tdb5")).click(); // continue button

		if (driver.getPageSource().contains("Your account has been successfully updated")) {
			System.out.println("Change profile successfully");
		} else {
			System.out.println("Profile information not changed");
		}

		driver.findElement(By.linkText("Log Off")).click();
		driver.findElement(By.linkText("Continue")).click();
		// driver.close();

	}

}
