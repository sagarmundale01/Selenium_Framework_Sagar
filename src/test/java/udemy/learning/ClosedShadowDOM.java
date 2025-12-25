package udemy.learning;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosedShadowDOM {

    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/sagar/Downloads/shadow-demo.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Access CLOSED shadow DOM element using JS
        WebElement element = (WebElement) js.executeScript("return document.querySelector('#host')" +
                                                           ".shadowRoot.querySelector('#msg');");

        System.out.println("Text inside closed shadow DOM: " + element.getText());

        // Click button inside closed shadow root
        WebElement btn = (WebElement) js.executeScript("return document.querySelector('#host')" +
                                                       ".shadowRoot.querySelector('#clickBtn');");
        btn.click();
        driver.quit();
 
    }
}
