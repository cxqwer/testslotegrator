package pageObjects.pageSections;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import pageObjects.BasePage;
import utill.annotations.Name;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

/**
 * Class describing the Auth Form
 *
 * @author cxqwer@yandex.ru
 */
@Getter
public class AuthForm extends BasePage {

    @Name("Login Input")
    private SelenideElement loginInput = $(byId("UserLogin_username"));

    @Name("Password Input")
    private SelenideElement passwordInput = $(byId("UserLogin_password"));

    @Name("Sign in Button")
    private SelenideElement signInButton = $("[action='/admin/login'] [class*='btn-primary'][value ='Sign in']");
}
