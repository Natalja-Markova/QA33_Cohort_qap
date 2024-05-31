package com.ait.hw;
import com.ait.lesson.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Homework_3 extends BaseTest {

    @Test
    @DisplayName("Поиск элементов по xPath для формы ")
    void findElementByXpath(){
        driver.get(URL_DEMO_WEB_SHOP);
        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
        fillInputField(By.xpath("//input[@id='Email']"), "ewqewq@gmail.com");
        fillInputField(By.xpath("//input[@id='Password']"), "1234qwer");
        clickOnElement(By.xpath("//input[@value='Log in']"));
        Assertions.assertTrue(getElementBy(By.xpath("//a[contains(text(),'Log out')]")).isDisplayed(),
                "Отсутствует кнопка выхода ");
    }
    @Test
    @DisplayName("Поиск элементов по xPath")
    void findElementByXpath2(){
        driver.get(URL_DEMO_WEB_SHOP);
        WebElement elementByClassName = getElementBy(By.xpath("//body['header-logo']"));
        Assertions.assertTrue(elementByClassName.isDisplayed(), "elementByClassName нет на странице");

        WebElement elementByLinkText = getElementBy(By.xpath("//a[contains(text(),'Computers')]"));
        Assertions.assertTrue(elementByLinkText.isDisplayed(), "elementByLinkText нет на странице");

    }
}
