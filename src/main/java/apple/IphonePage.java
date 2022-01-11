package apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IphonePage {
    WebDriver driver;

    By searchResultSelector = By.cssSelector("ac-gn-item ac-gn-item-menu ac-gn-iphone");

    public IphonePage(WebDriver driver) {
        this.driver = driver;
    }

    public Iphone13ProPage openResult(int index) {
        List<WebElement> listOfResults = driver.findElements(searchResultSelector);
        listOfResults.get(index).click();

        Iphone13ProPage iphone13ProPage = new Iphone13ProPage(driver);
        return iphone13ProPage;
    }

}
