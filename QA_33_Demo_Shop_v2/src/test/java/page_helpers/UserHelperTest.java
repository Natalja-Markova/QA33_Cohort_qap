package page_helpers;


import model.Account;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static core.AppManager.TEST_LOGIN_USER;


public class UserHelperTest extends BaseHelperTest {

    @BeforeMethod
    void precondition() {
        if (!app.getUserHelper().isLoginLinkPresent()) {
            app.getUserHelper().clickOnSigOutButton();
        }
    }


    @Test
    void loginPositiveTest() {
        app.getUserHelper().clickOnLoginLink();
        app.getUserHelper().loginForm(TEST_LOGIN_USER);
        app.getUserHelper().clickOnLoginButton();
        Assert.assertTrue(app.getUserHelper().isSignOutButtonPresent());
        app.getUserHelper().clickOnSigOutButton();

    }
    @Test
    void registerPositiveTest() {
        Account user=new Account(true,false,"John",
                "Wick",getSaltString()+"@gmail.com",
                "Bingo12345","Bingo12345");
        app.getUserHelper().clickOnRegistrationLink();
        app.getUserHelper().fillLoginRegisterForm(user);
        app.getUserHelper().clickOnRegistrationButton();
        Assert.assertTrue(app.getUserHelper().isSignOutButtonPresent());
    }
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();

    }

}