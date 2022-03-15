package runner;

import dao.common.AutotestCache;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;

/**
 * Class for running tests using the Cucumber framework
 *
 * @author cxqwer@yandex.ru
 */
@RunWith(Cucumber.class)
@Slf4j
@CucumberOptions(
        strict = true,
        features = {"src/test/resources/features/"},
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        glue = {"steps", "hooks"},
        tags = "@all"
)
public class RunnerTest {
   public static AutotestCache CACHE = new AutotestCache();
}
