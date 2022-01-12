import amazon.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AmazonTest {

    WebDriver driver;

    @BeforeMethod
    public  void setup(){
        // AVEC SELENIUM GRIDE
        //URL seleniumGridUrl = null;
        //try {
           // seleniumGridUrl = new URL("http://127.0.0.1:4444");
       // } catch (MalformedURLException e) {
           // e.printStackTrace();
        //}
        //ChromeOptions chromeOptions = new ChromeOptions();
       // driver = new RemoteWebDriver(seleniumGridUrl, chromeOptions);


        driver = new ChromeDriver();//=>AVEC SELENIUM WEB DRIVER
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        // fermer cookies
        driver.findElement(By.id("sp-cc-accept")).click();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void hpChromeBookAddToCartPriceTest() {
        // Arrange
        String productName = "HP Chromebook x360 14a-ca0000sf";
        String expectedPrice = "360 €";

        // Act
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct(productName);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.openResult( 0);

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.noCoverage();


        ConfirmationAddToCartPage confirmationAddToCartPage = new ConfirmationAddToCartPage(driver);
        confirmationAddToCartPage.openCart();

        CartPage cartPage = new CartPage(driver);
        String productPrice = cartPage.getProductPrice(0);
        String activeCartSubtotal = cartPage.getActiveCartSubtotal();
        String buyboxCartSubtotal = cartPage.getBuyboxCartSubtotal();

        // Assert
        Assert.assertEquals(productPrice, expectedPrice);
        Assert.assertEquals(activeCartSubtotal, expectedPrice);
        Assert.assertEquals(buyboxCartSubtotal, expectedPrice);
    }

    //@Test
    //public void machineARacletteTest() {
        // Arrange
        //String productName = "Machine a raclette";

        // Act
        //amazon.MainPage mainPage = new amazon.MainPage(driver);
        //mainPage.searchProduct(productName);

        //amazon.SearchResultPage searchResultPage = new amazon.SearchResultPage(driver);
        //searchResultPage.openResult( 5);

        //amazon.ProductPage productPage = new amazon.ProductPage(driver);
        //productPage.addToCart();
        //productPage.noCoverage();

        //amazon.ConfirmationAddToCartPage confirmationAddToCartPage = new amazon.ConfirmationAddToCartPage(driver);
        //confirmationAddToCartPage.openCart();

    //}

    //TEST POUR LE HOVER
    @Test public void hoverTest() {
        By buttonSelector = By.id("nav-link-accountList");
        WebElement button = driver.findElement(buttonSelector);
        Actions hover = new Actions(driver);
        hover.moveToElement(button);
        hover.perform();

        By myAccountLinkSelector = By.cssSelector("#nav-al-your-account .nav-title + a");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountLinkSelector)).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }
}
