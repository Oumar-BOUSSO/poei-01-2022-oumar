package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    int timeoutSearch = 10;

    By searchBarSelector = By.id(("twotabsearchtextbox"));
    By searchResultSelector =By.cssSelector("[data-component-type='s-search-result']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public void searchProduct(String productName) {

        //TROUVER L'ELEMENT ET INTERAGIR AVEC L'LEMENT
        driver.findElement(searchBarSelector).sendKeys(productName + Keys.ENTER);
        //ATTENDRE QUE l'ACTION SOIT FINIE
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSearch));
        wait.until(ExpectedConditions.elementToBeClickable(searchResultSelector));

    }

}
