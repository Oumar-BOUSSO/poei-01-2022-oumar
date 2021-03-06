import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class tp1 {
    WebDriver driver;

    //Methode ou fonction permettant d'eviter de repeter le meme code dans les tests
    @BeforeMethod
    public void setup(){
        //SELENIUM GRIDE
        URL seleniumGridUrl = null;
        try {
            seleniumGridUrl = new URL("http://127.0.0.1:4444");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(seleniumGridUrl, chromeOptions);
        
        //driver = new ChromeDriver();//permet de charger la page google sans l'ouvrir


        driver.get("https://amazon.fr");//permet d'ouvrir la page google
        driver.manage().window().maximize();

        //fermer les cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();

    }
    //Code Pour fermer le navigateur: c'est une fonction
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    //chercher la machine à raclette dans la barre de recherche Amazon
    @Test
    public void test1() {

        //driver.get("https://www.google.com");

        //driver.findElement(By.id("twotabsearchtextbox"));
        //driver.findElement(By.name("field-keywords"));
        //driver.findElement(By.cssSelector(""));

        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));

        barreRecherche.sendKeys("machine a raclette");
        //pour la barre de recherche
        barreRecherche.sendKeys(Keys.ENTER);
    }

    @Test
    public void test2() {
        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine a raclette");
        barreRecherche.sendKeys(Keys.ENTER);

        //WebElement produit1 = driver.findElement(By.cssSelector("[cel_widget_id='MAIN-SEARCH_RESULTS-5']"));
       //produit1.click();

        WebElement produit1 = driver.findElement(By.cssSelector("[data-cel-widget='search_result_1']"));
        produit1.click();

        WebElement ajoutPanier = driver.findElement(By.cssSelector("[data-action='dp-pre-atc-declarative']"));
        ajoutPanier.click();

    }

    //Pour la synchronisation
    @Test
    public void testExplicitWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.findElement(By.id("nav-hamburger-menu")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".hmenu-item[data-menu-id='10']")));
        driver.findElement(By.cssSelector(".hmenu-item[data-menu-id='10']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.hmenu-visible > li:nth-child(3)")));
        driver.findElement(By.cssSelector("ul.hmenu-visible > li:nth-child(3) > a")).click();
    }

    @Test
    public void testMultipleElements() {
        // Arrange Act Assert (AAA)
        // Arrange
        int expectedNumberOfResults = 60;
        String keyword = "machine a raclette";
        int timeoutSearchLoad = 10;
        By searchBarSelector = By.id("twotabsearchtextbox");
        By searchResultSelector = By.cssSelector("[data-component-type='s-search-result']");

        // Act
        WebElement barreRecherche = driver.findElement(searchBarSelector);
        barreRecherche.sendKeys( keyword + Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSearchLoad));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultSelector));

        List<WebElement> listeDeResultat = driver.findElements(searchResultSelector);

        // Assert
        Assert.assertEquals(listeDeResultat.size(), expectedNumberOfResults, "The number of search results is not correct");
    }

}


