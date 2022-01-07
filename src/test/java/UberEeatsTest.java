import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class UberEeatsTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();

        driver.get("https://ubereats.com/fr"); // Pour ouvrir la page
        driver.manage().window().maximize();   //Pour maximiser la taille de l'écran

        By buttonCookies = By.cssSelector("[class='bc gh gi gl bj bk bl bm bn bo bt bu ba bb']");
        driver.findElement(buttonCookies).click(); //Pour accepter les cookies
    }

    @Test
    public void addBurgerToCart () {
        //Arange
        By saisieAdresseLivraison = By.cssSelector("[class='do aw e9 ea eb ec ed ee ef']"); // Pour la saisie de l'adresse
        By autocompleteSelector = By.cssSelector("#location-typeahead-home-input");
        By trouverCategorieBurgers = By.cssSelector("[alt='Burgers']");    // Trouver la catégorie Burgers
        By ouvrirRestaurantKingMarcel =By.cssSelector("a[href='/fr/store/king-marcel-nanterre/07TTIgUiQPWyz4uq4_H35w'] > h3"); //Ouvrir le restaurant
        By ajoutPremierPlat = By.cssSelector("[alt='Le Marcel Jackson']");  // Ajouter premier plat
        By ajoutPanier = By.cssSelector("button.b8.b9.ba.bb.bc.bd"); //Ajouter le produit(premier plat) au panier
        By cartSelector = By.cssSelector("button[aria-label='checkout'] > div");
        String address = "La Defense";
        String expectedCartItems = "1";

        //Act
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.findElement(saisieAdresseLivraison).sendKeys("La Defense");
        wait.until(ExpectedConditions.visibilityOfElementLocated(autocompleteSelector));
        driver.findElement(saisieAdresseLivraison).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(trouverCategorieBurgers));
        driver.findElement(trouverCategorieBurgers).click();

        wait.until(ExpectedConditions.elementToBeClickable(ouvrirRestaurantKingMarcel));
        driver.findElement(ouvrirRestaurantKingMarcel).click();

        wait.until(ExpectedConditions.elementToBeClickable(ajoutPremierPlat));
        driver.findElements(ajoutPremierPlat).get(0).click();

        wait.until(ExpectedConditions.elementToBeClickable(ajoutPanier));
        driver.findElement(ajoutPanier).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(ajoutPanier));
        
         //Assert
          WebElement cart = driver.findElement(cartSelector);
          Assert.assertTrue(cart.getText().contains(expectedCartItems), "The cart does not contain 1 item");
   
    }

        @AfterMethod
        public void tearDown() {
        driver.quit();
    }
}
