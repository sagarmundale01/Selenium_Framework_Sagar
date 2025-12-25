package udemy.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();

		//driver.switchTo().frame(1);
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		driver.findElement(By.id("draggable")).click();

		Actions action = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("droppable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
	
	}
}
