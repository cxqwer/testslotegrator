package pageObjects.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import pageObjects.BasePage;
import pageObjects.pageComponents.Table;
import pageObjects.pageSections.MainSideMenu;
import utill.annotations.Name;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

/**
 * Class describing the Main Page
 *
 * @author cxqwer@yandex.ru
 */
@Getter
public class MainPage extends BasePage {

    private MainSideMenu mainSideMenu = new MainSideMenu();
    private Table table = new Table();

    @Name("PLAYERS TABLE")
    private SelenideElement playersTable =  $(byId("payment-system-transaction-grid"));
}
