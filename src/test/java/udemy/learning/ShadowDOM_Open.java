package udemy.learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOM_Open {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		
		//Single Shadow dom
		SearchContext shadowRootElement = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		shadowRootElement.findElement(By.id("input")).sendKeys("QA Automation");
		
		
		//Nested Shadow dom
		driver.get("https://dev.automationtesting.in/shadow-dom");
		SearchContext parentShadowRootEle = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		String text =  parentShadowRootEle.findElement(By.id("shadow-element")).getText();
		System.out.println(text);
		
		SearchContext childShadowRootEle = parentShadowRootEle.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		String text2 = childShadowRootEle.findElement(By.id("nested-shadow-element")).getText();
		System.out.println(text2);
		
		
		//Multi Nested Shadow Root Element
		SearchContext grandChildShadowRootEle = childShadowRootEle.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		String text3 = grandChildShadowRootEle.findElement(By.id("multi-nested-shadow-root")).getText();
		System.out.println(text3);
		
		
		driver.quit();
		
	}

}
