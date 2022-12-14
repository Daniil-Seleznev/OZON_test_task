import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public abstract class AbstractTest {

    private static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    public static void natigateToFieldsPage() {
        getDriver().navigate().to("C:\\Users\\Danya\\IdeaProjects\\OZON_test\\Edit Fields.html");
    }

    public static void natigateToButtonsPage() {
        getDriver().navigate().to("C:\\Users\\Danya\\IdeaProjects\\OZON_test\\Buttons.html");
    }

    @AfterAll
    public static void close(){
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}