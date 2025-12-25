package e2eautomation_book;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo_IFrame {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		 driver.get("https://the-internet.herokuapp.com/iframe");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     driver.manage().window().maximize();
	     
	     //switch the focus to the iframe, we identify in here the iframe using its id property
	     driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
	     
	     //your content goes here is associated with the paragraph html element
	     String contents = driver.findElement(By.xpath("//p")).getText();
	     System.out.println(contents); 
	     
	     Alert alert=driver.switchTo().alert();
	     alert.dismiss();
	     
	     driver.switchTo().defaultContent();  //switch back to the parent html document
	     
	 //    driver.close();    
	     
	     
	}	
}
