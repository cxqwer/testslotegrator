package utill.files;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

/**
 * A class for working with screenshots of an Allure report
 *
 * @author cxqwer@yandex.ru
 */
public abstract class Screenshot {
    private static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    private static byte[] getPageSourceBytes() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    public static void makeScreenshot() {
        Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", getScreenshotBytes());
    }

    public static void makeScreenshotPageSource() {
        Allure.getLifecycle().addAttachment("Page source", "text/html", "html", getPageSourceBytes());
    }
}
