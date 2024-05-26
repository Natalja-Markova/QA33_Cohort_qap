import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.junit.jupiter.api.*;

public class FirstSeleniumTest extends BaseTest {

    @Test
    @DisplayName("Проверка заголовка страницы")
    void testOpenBrowser() {
        driver.get("https://www.google.com/");//Открытие страницы

        driver.navigate().back();//Возврат на предыдущую страницу
        driver.navigate().forward();//Переход на следующую страницу
        driver.navigate().refresh();//Обновление страницы
        Assertions.assertEquals("Google", driver.getTitle(), "Открыта страница с другим Title");//Проверка заголовка страницы
    }
}