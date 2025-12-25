package e2eautomation_book;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginLogoutUsingPOM {

	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     
	}
	@Test
	public void test() throws Exception
	{
		driver.get("http://practice.bpbonline.com/");
		Login_Pom login = new Login_Pom(driver);
		Logout_Pom logout = new Logout_Pom(driver);
		login.clickMyAccount();
		login.loginAs("bpb@bpb.com", "bpb@123");
		login.validateLogin("My Account Information");
		logout.logOff();
		
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
