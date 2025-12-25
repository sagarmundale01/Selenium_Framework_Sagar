package udemy.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators3 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Sibling - Child to parent traverse
		// header/div/button[1]/following-sibling::button[1]

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement siblingText = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]"));
		
		System.out.println(siblingText.getText());

		WebElement parentText = driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]"));
		System.out.println(parentText.getText());

		driver.close();
	}

}
