import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class tp1 {

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

       // driver.quit();// ce bout de code permet d'arreter le chargement de la page google en boucle


    }


    @Test
    public void test2() {

    }
}
