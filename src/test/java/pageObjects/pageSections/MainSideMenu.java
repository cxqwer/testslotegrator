package pageObjects.pageSections;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import pageObjects.BasePage;
import utill.annotations.Name;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Class describing the component Navigation menu
 *
 * @author cxqwer@yandex.ru
 */
@Getter
public class MainSideMenu extends BasePage {

    @Name("Navigation menu")
    private SelenideElement navigationMenu =  $(byId("nav"));

    @Name("Users")
    private SelenideElement usersTab = $(byId("s-menu-users")).parent();

    @Name("Active drop down")
    private SelenideElement activeDropDown = $("[class='active'] [class='collapse in']");

    public void selectDropDown(String tab){
        activeDropDown.find(byText(tab)).shouldBe(Condition.visible).click();
    }
}
