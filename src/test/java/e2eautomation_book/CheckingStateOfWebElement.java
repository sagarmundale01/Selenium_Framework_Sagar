package e2eautomation_book;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckingStateOfWebElement {

	public static void main(String[] args) throws Exception{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://artoftesting.com/samplesiteforselenium");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		WebElement firstCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		
		System.out.println(firstCheckBox.isDisplayed());
		System.out.println(firstCheckBox.isEnabled());
		System.out.println(firstCheckBox.isSelected());
		
		firstCheckBox.click();
		System.out.println(firstCheckBox.isSelected());
	    
		driver.quit();
		
		//output:-
        //true
        //true
        //false
        //true
		
	}
}
