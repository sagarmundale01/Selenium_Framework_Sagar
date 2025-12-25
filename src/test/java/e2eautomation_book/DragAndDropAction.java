package e2eautomation_book;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropAction {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// to perform scroll on application using selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		// switch to the iframe
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		// source element
		WebElement drag = driver.findElement(By.id("draggable"));

		// target element
		WebElement drop = driver.findElement(By.id("droppable"));

		// create action object
		Actions action = new Actions(driver);

		// call the drag drop action
		action.dragAndDrop(drag, drop).perform();

		// wait for 5 seconds before closing the browser

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
