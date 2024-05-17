import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework_1 {
    private static final String URL = "https://www.google.com/";

    public WebDriver driver;

    @BeforeEach
    void startDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    void quitDriver() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка заголовка страницы")
    void testOpenBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://ilcarro.web.app/search");
        driver.navigate().forward();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        Assertions.assertEquals("Search", driver.getTitle(), "Открыта другая страница с другим Title");
    }

}
