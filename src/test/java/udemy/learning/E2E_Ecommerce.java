package udemy.learning;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2E_Ecommerce {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Create array of items needed
		String[] itemsNeeded = { "Brocolli", "Cucumber", "Beetroot", "Carrot" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();
			String formatedName = name.split("-")[0].trim(); // extract name of vegetable only

			// convert array into arraylist for easy search
			// check whether name you extracted is present in array

			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			int j = 0;

			if (itemsNeededList.contains(formatedName)) {
				j++;
				System.out.println(formatedName);
				// click on add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}

			}
		}

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

		WebElement orderDetail = driver.findElement(By.cssSelector("button.promoBtn"));
		orderDetail.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(orderDetail.getText());

		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		System.out.println(driver.findElement(By.cssSelector("span.totAmt")).getText());
		System.out.println(driver.findElement(By.cssSelector("span.discountAmt")).getText());
		System.out.println(driver.findElement(By.cssSelector("span.discountPerc")).getText());

		driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/button")).click();

		driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/div/select")).sendKeys("India");
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();

		System.out.println(driver.getTitle());
		System.out.println(driver.getPageSource().contains("Thank you, your order has been placed successfully")); // true
		driver.close();
	}
}
