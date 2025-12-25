package udemy.learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelIntroduction {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.getTitle();
		System.out.println(driver.getTitle());
	    System.out.println(driver.getCurrentUrl());
		
		System.out.println("selenium");
	    System.out.println("automation");
	    
	    driver.close();

	}

}
