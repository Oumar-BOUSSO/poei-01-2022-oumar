package apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Iphone13ProPage {

    WebDriver driver;
    int timeoutSidebar = 3;
    int timeoutConfirmation = 10;

    By buyButtonSelector = By.id("ac-ln-action-product");


    public Iphone13ProPage(WebDriver driver) {
        this.driver = driver;
    }

    public Iphone13ProPage buyButtonSelector() {
        driver.findElement(buyButtonSelector).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSidebar));

        return this;
    }

}
