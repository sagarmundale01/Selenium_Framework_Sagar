package udemy.learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowActivities {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.navigate().to("https://rahulshettyacademy.com");     // to rahul shetty academy
		driver.navigate().back();                                   // to google
		driver.navigate().forward();                                // to rahul shetty academy
		driver.navigate().refresh();                                // refresh the page
		
		System.out.println(driver.getCurrentUrl()                 + " - Current URL");
		System.out.println(driver.getTitle()                      + " - Title of the page");
		System.out.println(driver.getPageSource()                 + " - Page Source");
		System.out.println(driver.getWindowHandle()               + " - Window Handle");
		System.out.println(driver.getWindowHandles()              + " - Window Handles");
		System.out.println(driver.getClass()	                  + " - Class Info");
		System.out.println(driver.hashCode()                      + " - Hash Code");
		System.out.println(driver.toString()                      + " - To String");
//		System.out.println(driver.getClass().getName()            + " - Class Name");
//		System.out.println(driver.getClass().getSimpleName()      + " - Simple Class Name");
//		System.out.println(driver.getClass().getPackageName()     + " - Package Name");
//		System.out.println(driver.getClass().getPackage()         + " - Package Info");
//		System.out.println(driver.getClass().getModifiers()       + " - Modifiers");
//		System.out.println(driver.getClass().getSuperclass()      + " - Superclass Info");
//		System.out.println(driver.getClass().getInterfaces()      + " - Interfaces Info");
//		System.out.println(driver.getClass().getDeclaredClasses() + " - Declared Classes Info");
//		System.out.println(driver.getClass().getDeclaredMethods() + " - Declared Methods Info");
//		System.out.println(driver.getClass().getDeclaredFields()  + " - Declared Fields Info");
//		System.out.println(driver.getClass().getProtectionDomain() + " - Protection Domain Info");
//		System.out.println(driver.getClass().getSigners()          + " - Signers Info");
//		System.out.println(driver.getClass().getAnnotations()      + " - Annotations Info");
//		
		driver.close(); 

	}

}
