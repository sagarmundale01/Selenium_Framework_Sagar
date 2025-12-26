package seleniumframeworkdesign;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //we are going to use explicit wait here

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();

//		LandingPage landingPage = new LandingPage(driver);
//		landingPage.loginApplication("sagarmundale01@gmail.com", "Automation$112");
		
		driver.findElement(By.id("userEmail")).sendKeys("sagarmundale01@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Automation$112");
		driver.findElement(By.id("login")).click();

		// list of products on the page
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst()
				.orElse(null);

		if (prod != null) {
			prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals("ZARA COAT 3"));
		
		if (match)
		{
			System.out.println("Product is added to the cart");
		} 
		else 
		{
			System.out.println("Product is not added to the cart");
		}

		//continue to checkout
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
			
		List<WebElement> countries = driver.findElements(By.cssSelector(".ta-results button"));
			
		for (WebElement country : countries) 
			{
				if (country.getText().equals(" India")) 
				{
					country.click();
					break;
				}
			}
		
		driver.findElement(By.cssSelector(".action__submit")).click(); 
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		if (confirmMessage.equals("THANKYOU FOR THE ORDER."))
		{
			System.out.println("Order is successfully placed.");
		} 
		else 
		{
			System.out.println("Order is not placed.");
		}
		
		System.out.println("End of StandAloneTest");
				
		driver.quit();

	}

}
