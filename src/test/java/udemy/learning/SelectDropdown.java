package udemy.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage().window().maximize();
		driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
		
		WebElement down = driver.findElement(By.name("input_8"));
		Select select = new Select(down);
		
		select.selectByValue("level1");
		Thread.sleep(2000);
		
		select.selectByVisibleText("51 - 100 employees");
		Thread.sleep(2000);
				
		select.selectByIndex(5);
		Thread.sleep(2000);
		
		driver.close();
		
		

	//System.out.println(down = (WebElement) driver.findElement(By.name("input_8")).getSize());
		

	}

}
