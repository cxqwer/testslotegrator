package hooks;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

import java.util.Collection;

import static com.codeborne.selenide.Selenide.*;
import static utill.files.Screenshot.makeScreenshot;
import static utill.files.Screenshot.makeScreenshotPageSource;
import static utill.properties.TestProperties.*;

/**
 * A class with optional methods for a class describing actions for each Gerkin scenario
 *
 * @author cxqwer@yandex.ru
 * @see Hooks
 */
public class RunHooks {


    /**
     * Method determines whether the res api scenario is a test
     *
     * @param scenario
     * @return boolean
     */
    public static boolean isApiScenario(Scenario scenario) {
        Collection<String> tagsNamesList = scenario.getSourceTagNames();
        for (String tagName : tagsNamesList) {
            if (tagName.contains("api")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method determines what to do with the browser after the test is completed
     *
     * @param scenario
     */
    public static void makeWithBrowserAfterTests(Scenario scenario) {
        if (!isApiScenario(scenario)) {
            if (scenario.getStatus().equals(Status.FAILED)) {
                makeScreenshot();
                makeScreenshotPageSource();
            }
            if (CLOSE_DRIVER_AFTER_RUN) {
                closeWebDriver();
            } else {
                clearBrowserCookies();
                clearBrowserLocalStorage();
            }
        }
    }

    /**
     * Method for adding configurations to a web driver
     */
    public static void configBrowser() {
        Configuration.timeout = BASE_TIMEOUT;
        Configuration.browser = BROWSER_NAME;
        Configuration.startMaximized = true;
    }
}
