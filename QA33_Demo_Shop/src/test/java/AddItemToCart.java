import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AddItemToCart extends BaseTest1 {

    @Test
    @DisplayName("Добавление товара в карзину")
    void addTest() {
        login("ewqewq@gmail.com", "1234qwer", "Log in");
        waitInSeconds(2);
        clickOnElement(By.xpath("(//input[@value='Add to cart'])[2]"));
        waitInSeconds(5);

        String newShopItems = getElementBy(By.xpath("//span[@class='cart-qty']")).getText().replaceAll("[^0-9]+", "");
        System.out.println(newShopItems);
        assertTrue(Integer.parseInt(newShopItems) > 0);


        waitInSeconds(4);
        clickOnElement(By.xpath("//span[@class='cart-label']"));
        waitInSeconds(2);
        List<WebElement> listAElements = driver.findElements(By.name("removefromcart"));
        System.out.println(listAElements.size());
        for (int i = 0; i < listAElements.size(); i++) {
            waitInSeconds(1);
            listAElements.get(i).click();
        }
        clickOnElement(By.xpath("//input[@name='updatecart']"));
        assertTrue(getElementBy(By.xpath("//*[text()='Log out']")).isDisplayed(),
                "Отсутствует кнопка выхода ");

    }

}
