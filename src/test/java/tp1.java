import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class tp1 {
    WebDriver driver;

    //Methode ou fonction permettant d'eviter de repeter le meme code code les tests
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();//permet de charger la page google sans l'ouvrir

        //Implicit wait 2 secondes ici
        //Cette mméthode s'applique une fois pour mes tests
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

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
}
