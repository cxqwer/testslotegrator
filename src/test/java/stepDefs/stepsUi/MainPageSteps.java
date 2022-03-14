package stepDefs.stepsUi;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pageObjects.pages.MainPage;
import runner.RunnerTest;

import static utill.files.Screenshot.makeScreenshot;

/**
 * A class describing the steps of the main page
 *
 * @author cxqwer@yandex.ru
 */
public class MainPageSteps extends RunnerTest {
    private MainPage mainPage = new MainPage();

    @Then("The navigation menu is displayed on the main page")
    public void checkNavigationOnPage() {
        mainPage.getMainSideMenu().getNavigationMenu().shouldBe(Condition.visible);
        makeScreenshot();
    }

    @When("In the navigation menu select {string}")
    public void inSideMenuSelect(String tab) {
        makeScreenshot();
        mainPage.getMainSideMenu().getElement(tab).click();
    }

    @And("In the navigation menu in the drop-down list select {string}")
    public void inSideMenuDropDownSelect(String tab) {
        makeScreenshot();
        mainPage.getMainSideMenu().selectDropDown(tab);
    }

    @Then("The main page displays {string}")
    public void checkElement(String element) {
        mainPage.getElement(element).shouldBe(Condition.visible);
        makeScreenshot();
    }

    @When("In the table click on the heading of the {int}st column")
    public void clickByColumnTitle(int index) {
        makeScreenshot();
        mainPage.getTable().getColumnTitle(index).click();
    }

    @Then("The table is sorted in ascending order by {int}st column")
    public void checkColumnSort(int index) {
        mainPage.getTable().checkTableSort(index);
        makeScreenshot();
    }
}
