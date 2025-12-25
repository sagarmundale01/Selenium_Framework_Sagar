package e2eautomation_book;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithDropdownElement_Manufacturer {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.practice.bpbonline.com/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        //create the dropdown element
        Select manufacturers = new Select(driver.findElement(By.xpath("//select[@name='manufacturers_id']")));
        
        //getting all option elements available within the dropdown
        List<WebElement> allmanfs = manufacturers.getOptions();
        allmanfs.remove(0);   //removing please select from the list
        
        
        //creating an arraylist for all manufacturera name
        ArrayList<String> allNames = new ArrayList<String>();
        for(WebElement man : allmanfs)
        {
        	allNames.add(man.getText());
        	
        }
        
        //selecting each manufacturer one by one
        for(String manname : allNames)
        {
        	//select element by its visible text
        	manufacturers.selectByVisibleText(manname);
        	
        	//handling stale element exception as page refreshes.
        	manufacturers = new Select(driver.findElement(By.xpath("//select[@name='manufacturers_id']")));
        	
        	if(driver.getPageSource().contains("There are no products available in this category."))
        			
        			{
        		      System.out.println("The manufacturer has no products");
        			}
        	else
        	{
        		//create the table element
        		WebElement productTable = driver.findElement(By.className("productListingHeader"));
        		
        		//fetch all table rows
        		System.out.println("\n\nThe manufacturer-"+manname +" products are listed--");
        		
        		List<WebElement> rows = productTable.findElements(By.xpath("//*/tbody/tr"));
        		
        		for(WebElement row: rows)
        		{
        			//fetch all table cols
        			List<WebElement> cols = row.findElements(By.xpath("td"));
        			
        			for(WebElement col: cols)
        			{
        				//print cell content
        				String content = col.getText();
        				System.out.println(content);
        			}
        		}
        	}
        	
        } 
        
        driver.close();

	}

}
