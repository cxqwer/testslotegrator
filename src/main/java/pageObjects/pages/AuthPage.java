package pageObjects.pages;

import lombok.Getter;
import pageObjects.BasePage;
import pageObjects.pageSections.AuthForm;

/**
 * Class describing the Auth Page
 *
 * @author cxqwer@yandex.ru
 */
@Getter
public class AuthPage extends BasePage {

    private final String PAGE_URL = "admin/login";

    private AuthForm authForm = new AuthForm();
}
