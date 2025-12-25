package e2eautomation_book;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoOfWindow {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		 driver.get("https://the-internet.herokuapp.com/windows");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     driver.manage().window().maximize();
	     
	     //Click on click here
	     driver.findElement(By.linkText("Click Here")).click();
	     
	     Set<String> allWindowHandles = driver.getWindowHandles();
	     
	     for(String handle:allWindowHandles)
	     {
	    	 System.out.println(handle);
	     }
	    	
	     //Convert the set into an array so that we can access the window.
	     //at array 0 position the main window handle will be there, and after that based on when a new window is opened
	     //it will take the next position in the array
	     
	     Object[] windows = allWindowHandles.toArray();
	    
	     //switch to new window
	     driver.switchTo().window(windows[1].toString());
	     
	     if(driver.getPageSource().contains("New Window"))
	     {
	    	 System.out.println("we are now on new window");
	         System.out.println("closing the child window");
	        // driver.close();
	     }

	     //switch to main window
 	     System.out.println("closing the main window");
         driver.switchTo().window(windows[0].toString());
 	    // driver.close();
	
	
	}
}
