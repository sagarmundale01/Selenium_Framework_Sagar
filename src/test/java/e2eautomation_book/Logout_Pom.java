package e2eautomation_book;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout_Pom {

	private WebDriver driver;
	
	public Logout_Pom(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By logOff = By.linkText("Log Off");
	By continueButton = By.linkText("Continue");
	
	public Logout_Pom clickLogOff()
	{
		driver.findElement(logOff).click();
		return this;
	}

	public Logout_Pom clickContinue()
	{
		driver.findElement(continueButton).click();
		return this;
	}
	
	public Logout_Pom logOff()
	{
		clickLogOff();
		return clickContinue();
	}
	
}
