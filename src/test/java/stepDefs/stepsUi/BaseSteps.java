package stepDefs.stepsUi;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import runner.RunnerTest;
import utill.properties.PropertyReader;

import static com.codeborne.selenide.Selenide.*;
import static utill.properties.TestProperties.HOST;

/**
 * A class describing common steps for all groups of scenarios
 *
 * @author cxqwer@yandex.ru
 */
public class BaseSteps extends RunnerTest {

    public static void openPage(String url){
        open(String.format("%s/%s", HOST, url));
    }

    @И("wait {int} seconds")
    public static void подождатьСекунд(int sec) {
        sleep(sec * 1000);
    }
}
