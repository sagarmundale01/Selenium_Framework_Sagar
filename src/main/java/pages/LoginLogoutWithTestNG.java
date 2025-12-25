package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginLogoutWithTestNG {
    
	WebDriver driver;

    @BeforeMethod
    public void setup() 
    {
      	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    
    @Test
    public void validLogin()
    {   	
        driver.get("http://www.practice.bpbbonline.com/");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.name("email_address")).sendKeys("bpb@bpb.com");
        driver.findElement(By.name("password")).sendKeys("bpb@123");
        driver.findElement(By.id("tdb1")).click();

        if (driver.getPageSource().contains("My Account Information")) 
        {
            driver.findElement(By.linkText("Continue")).click();
            Reporter.log("User information is valid", true);
        
        }
        else 
        {
            Reporter.log("User information is invalid", true);
        }
    }

    @AfterMethod
    public void cleanUp() 
    {
        if (driver != null) 
        {
            driver.quit();
        }
    }
}
