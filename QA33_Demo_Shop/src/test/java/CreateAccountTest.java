import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("@LoginTests")
@Tag("@REGRESS")
public class CreateAccountTest extends TestBase {
    @Test
    @Tag("@Positive")
    @Tag("@SMOKE")
    @DisplayName("Проверка успешной авторизации")
    void registrationTest1() {
        register("Male", "John", "Doe", "qqreyt11@gmail.com", "1234qwer", "1234qwer");
        assertTrue(getElementBy(By.xpath("//a[contains(text(),'Log out')]")).isDisplayed(), "Отсутствует кнопка выхода ");
    }

    // TODO: 31/05/2024   login
    @Test
    @Tag("@Positive")
    @Tag("@SMOKE")
    @DisplayName("Проверка успешной логина ")
    void loginTest1() {
        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
        fillInputField(By.id("Email"), "ewqewq@gmail.com");
        fillInputField(By.id("Password"), "1234qwer");
        clickOnElement(By.xpath("//input[@value='Log in']"));
        //assertTrue(getElementBy(By.xpath("//div[contains(text(),'Your registration completed')]"))).isDisplayed;
        assertTrue(getElementBy(By.xpath("//*[text()='Log out']")).isDisplayed(),
                "Отсутствует кнопка выхода ");
    }
}
