import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tp1 {
    WebDriver driver;

    @BeforeMethod

    public void setup(){
        WebDriver driver = new ChromeDriver();//permet de charger la page google sans l'ouvrir

        driver.get("https://amazon.fr");//permet d'ouvrir la page google
        driver.manage().window().maximize();

        //fermer les cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();

    }

    //chercher la machine à raclette dans la barre de recherche Amazon
    @Test
    public void test1() {
        WebDriver driver = new ChromeDriver();//permet de charger la page google sans l'ouvrir

        driver.get("https://amazon.fr");//permet d'ouvrir la page google
        driver.manage().window().maximize();

        //fermer les cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();

        //driver.get("https://www.google.com");

        //driver.findElement(By.id("twotabsearchtextbox"));
        //driver.findElement(By.name("field-keywords"));
        //driver.findElement(By.cssSelector(""));

        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));

        barreRecherche.sendKeys("machine a raclette");
        //pour la barre de recherche
        barreRecherche.sendKeys(Keys.ENTER);

        driver.quit();// ce bout de code permet d'arreter le chargement de la page google en boucle

    }


    @Test
    public void test2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        // fermer cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();
        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine a raclette");
        barreRecherche.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //WebElement produit1 = driver.findElement(By.cssSelector("[cel_widget_id='MAIN-SEARCH_RESULTS-5']"));
       //produit1.click();

        WebElement produit1 = driver.findElement(By.cssSelector("[data-cel-widget='search_result_1']"));
        produit1.click();

        WebElement ajoutPanier = driver.findElement(By.cssSelector("[data-action='dp-pre-atc-declarative']"));
        ajoutPanier.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();


    }
}
