import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppleTest {
    WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.apple.com");
        driver.manage().window().maximize();

        // Pour fermer le bouton continuer sur amazone en choisissant un pays
        driver.findElement(By.id("ac-ls-continue")).click();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }


    @Test
    public void iphone13ProMax() {
        //ARANGE
        String productName = "Iphone 13 Pro Max";
        String expectedPrice = "1099,00 €";



        //ACT



        //ASSERT
    }
}
