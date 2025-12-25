package udemy.learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {

    public static void main(String[] args) throws InterruptedException {

    	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractise/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tableFixHead")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop = 5000;", table);

        driver.quit();
        
    }
}    
        
        
        
        
        
        
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,500)");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.quit();
   