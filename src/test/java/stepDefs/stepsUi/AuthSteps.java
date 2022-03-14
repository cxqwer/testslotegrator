package stepDefs.stepsUi;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.pages.AuthPage;

import java.util.List;
import java.util.Map;

import static stepDefs.stepsUi.BaseSteps.openPage;
import static utill.files.Screenshot.makeScreenshot;

/**
 * A class describing the steps of the authorization page
 *
 * @author cxqwer@yandex.ru
 */
public class AuthSteps  {
    private AuthPage authPage = new AuthPage();

    @When("Open auth page")
    public void openAuthPage() {
        openPage(authPage.getPAGE_URL());
    }

    @Then("On the authorization page display a list of items:")
    public void наСтраницеАвторизацииОтображаетсяСписокЭлементов(List<String> elements) {
        elements.forEach(e->authPage.getAuthForm().getElement(e).shouldBe(Condition.visible));
        makeScreenshot();
    }

    @When("Login:")
    public void выполняемАвторизацию(Map<String, String> map) {
        authPage.getAuthForm().getLoginInput().setValue(map.get("Login"));
        authPage.getAuthForm().getPasswordInput().setValue(map.get("Password"));
        makeScreenshot();
        authPage.getAuthForm().getSignInButton().click();
    }
}
