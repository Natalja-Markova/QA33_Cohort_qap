import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

@Tag("@LoginTests")
@Tag("@REGRESS")
public class CreateAccountTest extends TestBase {
    @Test
    @Tag("@Positive")
    @Tag("@SMOKE")
    @DisplayName("Проверка успешной авторизации")
    void registrationTest1() {
        register("Male","John","Doe", "wqreyt5@gmail.com","1234qwer","1234qwer");
        Assertions.assertTrue(getElementBy(By.xpath("//a[contains(text(),'Log out')]")).isDisplayed(), "Отсутствует кнопка выхода ");
    }


}
