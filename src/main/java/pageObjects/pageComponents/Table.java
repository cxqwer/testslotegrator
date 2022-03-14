package pageObjects.pageComponents;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import pageObjects.BasePage;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertEquals;

/**
 * Class describing the component Table
 *
 * @author cxqwer@yandex.ru
 */
@Getter
public class Table extends BasePage {

    public SelenideElement getColumnTitle(int index) {
        return $(String.format("[id='payment-system-transaction-grid_c%s'] .sort-link", index));
    }

    public void checkTableSort(int columnIndex) {
        ElementsCollection selenideElements = $$(String.format("tbody tr td:nth-child(%s)", columnIndex + 1));
        List<String> actualTexts = selenideElements.stream().map(SelenideElement::getText).collect(Collectors.toList());
        List<String> expectedTexts = actualTexts.stream().sorted().collect(Collectors.toList());
        assertEquals(String.format("Column %s is not sorted", columnIndex), expectedTexts, actualTexts);
    }
}
