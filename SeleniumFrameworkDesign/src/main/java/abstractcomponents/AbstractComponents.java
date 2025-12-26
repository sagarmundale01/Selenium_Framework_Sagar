package abstractcomponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.CartPage;

public class AbstractComponents {

	
	WebDriver driver;
	WebDriverWait wait; 
	
	public AbstractComponents(WebDriver driver) 
	{
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	public void waitForElementToAppear(By findBy) 
	{
		// we are going to use explicit wait here
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	
	public void waitForElementToDisappear(WebElement element) 
	{
		// we are going to use explicit wait here
		wait.until(ExpectedConditions.invisibilityOf(element));

	}
	
}
