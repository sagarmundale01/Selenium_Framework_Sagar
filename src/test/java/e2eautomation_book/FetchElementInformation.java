package e2eautomation_book;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchElementInformation {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://practice.bpbonline.com/");
		driver.manage().window().maximize();
		
		WebElement quickFind = driver.findElement(By.xpath("//input[@title=' Quick Find ']"));
		
		System.out.println(quickFind.getAttribute("alt"));
		System.out.println(quickFind.getTagName());
        System.out.println(quickFind.getText());
		System.out.println(quickFind.getCssValue("background-color"));
		System.out.println(quickFind.getSize().height);
		System.out.println(quickFind.getRect().height);
		System.out.println(quickFind.getScreenshotAs(OutputType.FILE));
		driver.close();
		
	}

}
