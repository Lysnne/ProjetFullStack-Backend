package ikasaidi.backend.StockServiceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SeleniumTest {

    private WebDriver driver = new FirefoxDriver();
    private WebDriver driver2 = new ChromeDriver();
    private WebDriver driver3 = new EdgeDriver();

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "./data/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "./data/chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "./data/IEDriverServer.exe");
    }

    @Test
    public void testLoginForm() {
        driver.get("http://localhost/login");

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        username.sendKeys("johndoe90");
        password.sendKeys("Password123");

        loginButton.click();

        String loginOk = "http://localhost/profile";
        assertEquals(driver.getCurrentUrl(), loginOk);



    }
}
