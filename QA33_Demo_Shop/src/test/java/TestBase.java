import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {
    WebDriver driver;
    WebDriverWait wait;
    static final String URL_Demo_Web_Shop = "https://demowebshop.tricentis.com/";
    static final String LOGIN = "Log in";
    static final String REGISTRATION = "Register";
    static final User TEST_USER =new User ("manuel@gm.com","Manuel1234$");

    @BeforeEach
    void startDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(URL_Demo_Web_Shop);
    }
    @AfterEach
    void quitDriver() {
        driver.quit();
    }

    //Поиск элемента на странице, с явным ожиданием его появления
    protected WebElement getElementBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }
    private WebElement waitForClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //Ожидание появления уведомления от браузера
    protected Alert getAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    protected void fillInputField(By locator, String value) {
        WebElement element = waitForClickableElement(locator);
        element.click();
        element.clear();
        element.sendKeys(value);
        Assertions.assertEquals(value, element.getAttribute("value"), "Введенный текст отличается от того что в элементе");
    }
    protected void clickOnElement(By locator) {
        WebElement element = waitForClickableElement(locator);
        element.click();
    }
    protected void register( String gender, String firstName, String lastName,String email, String password, String confirmPassword) {
        // clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
        //a[@href='/register'
        clickOnElement(By.xpath("//a[@href='/register']"));
        clickOnElement(By.xpath("//input[@value='Register']"));
        if (gender.equals("Male")) {
            clickOnElement(By.id("gender-male"));
        } else if (gender.equals("Female")) {
            clickOnElement(By.id("gender-female"));
        }
        fillInputField(By.name("FirstName"), firstName);
        fillInputField(By.name("LastName"), lastName);
        fillInputField(By.name("Email"), email);
        fillInputField(By.name("Password"), password);
        fillInputField(By.name("ConfirmPassword"), confirmPassword);

        clickOnElement(By.id("register-button"));


        /*if (LOGIN.equals(loginOrRegistration)) {
            clickOnElement(By.name("login"));
        } else if (REGISTRATION.equals(loginOrRegistration)) {
            clickOnElement(By.name("registration"));*/
        }
   protected void login(String email, String password, String LOGIN) {
        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
        fillInputField(By.id("Email"), email);
        fillInputField(By.id("Password"), password);
        clickOnElement(By.xpath("//input[@value='Log in']" ));
//        if (LOGIN.equals(login)) {
//            clickOnElement(By.name("login"));
//        } else if (REGISTRATION.equals(login)) {
//            clickOnElement(By.name("registration"));
//        }
    }
        protected void loginTestUser(String email,String password ,String LOGIN) {
            login("manuel@gm.com","Manuel1234$","Log in");
        }
    protected void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
