package apple;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;


    int timeoutSearch = 15;

    By searchBarSelector = By.cssSelector("ac-gn-link ac-gn-link-iphone");
    By searchResultSelector = By.id("iphone-13-pro");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public IphonePage Iphone13ProPage(String productName) {
        // Trouver l'element et interagir avec l'element
        driver.findElement(searchBarSelector).sendKeys(productName + Keys.ENTER);

        // attendre que l'action soit fini
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSearch));
        wait.until(ExpectedConditions.elementToBeClickable(searchResultSelector));

        IphonePage IphonePage = new IphonePage(driver);
        return IphonePage;
    }
}
