package e2eautomation_book;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Pom {
	
	private WebDriver driver;
    
	//constructor of the class
	public Login_Pom(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By myaccount = By.linkText("My Account");
	By usernameLocator = By.name("email_address");
	By passwordLocator = By.name("password");
	By loginButtonLocator = By.id("tbd1");
	
	//this will click on the MyAccount link
	public Login_Pom clickMyAccount()
	{
		driver.findElement(myaccount).click();
		return this;  //Return the current page object as this action does't navigate to a page represented by another PageObjcect
		             
	}
	
	public Login_Pom typeUsername(String username)   //The login page allows the user to type their username into the username field 
	{
		driver.findElement(usernameLocator).sendKeys(username);
		return this;
	}
	
	public Login_Pom typePassword(String password)
	{
		driver.findElement(passwordLocator).sendKeys(password);
		return this;
	}
	
	
	public Login_Pom SubmitLogin()
	{
		driver.findElement(loginButtonLocator).submit();
		return this;
	}
	
	
	public boolean validateLogin(String srchTxt)
	{
		if(driver.getPageSource().contains(srchTxt)) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public Login_Pom loginAs(String username, String password)
	{
		typeUsername(username);
		typePassword(password);
		return SubmitLogin();
	}
}