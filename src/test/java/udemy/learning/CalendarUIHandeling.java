package udemy.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarUIHandeling {

    public static void main(String[] args) {

        String date = "15";
        String monthNumber = "6";
        String year = "2027";

        WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

        // Select year
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

        // Select month
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
                .get(Integer.parseInt(monthNumber) - 1).click();

        // Select date
        driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();
        
        System.out.println("Date selected: " + date + "/" + monthNumber + "/" + year);
        
        driver.quit();
        
    }
}
