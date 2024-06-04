package page_helpers;

import core.AppManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.*;

public class BaseHelperTest {

    protected static AppManager app = new AppManager("chrome");

    @BeforeSuite
    static void startTest() {
        app.init();
    }

    @AfterSuite
    static void stopTest() {
        app.stop();
    }
}