package e2eautomation_book;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithWebTables_ProductTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.practice.bpbonline.com/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
		
        //Create the table element
        WebElement productTable = driver.findElement(By.tagName("table"));
        
        //Fetch all table rows
        List<WebElement> rows = productTable.findElements(By.xpath("//*/tbody/tr"));
        
		for(WebElement row : rows)
		{
			//Fetch all table cols
			List<WebElement> cols = row.findElements(By.xpath("td"));
			
			for(WebElement col : cols)
			{
				//print cell content
				String content = col.getText();
				System.out.println(content);
			}
		}
		
		
	}

}
