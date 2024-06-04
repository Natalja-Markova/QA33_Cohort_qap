package page_helpers;

import model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//*[text()='Log out']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[contains(text(),'Log in')]"));
    }

    public void clickOnLoginLink(){
        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
    }
    public void clickOnRegistrationLink(){
        clickOnElement(By.xpath("//a[@href='/register']"));
    }

    public void clickOnLoginButton(){
        clickOnElement(By.xpath("//input[@value='Log in']" ));
    }

    public void clickOnRegistrationButton(){
        clickOnElement(By.xpath("//input[@value='Register']"));
    }

    public void clickOnSigOutButton(){
        clickOnElement(By.xpath("//*[text()='Log out']"));
    }

    public void fillLoginRegisterForm(Account user) {
        if (user.isMale()) {
            clickOnElement(By.id("gender-male"));
        } else if (user.isFemale()) {
            clickOnElement(By.id("gender-female"));
        }
        fillInputField(By.name("FirstName"), user.getFirstName());
        fillInputField(By.name("LastName"), user.getLastName());
        fillInputField(By.name("Email"), user.getEmail());
        fillInputField(By.name("Password"), user.getPassword());
        fillInputField(By.name("ConfirmPassword"), user.getConfirmPassword());
    }

    public void loginForm(Account user) {
       fillInputField(By.name("Email"), user.getEmail());
       fillInputField(By.name("Password"), user.getPassword());

    }

//    By.xpath("//*[text()='Sign Out']")

//    new User("manuelgm.com", "Manuel1234$")
//    (By.xpath("//*[contains(text(), '401')]")
}


