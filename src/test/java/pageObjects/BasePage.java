package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utill.annotations.Name;

import java.lang.reflect.Field;

/**
 * A class describing common methods for any Page Object
 *
 * @author cxqwer@yandex.ru
 */
public class BasePage {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    @SuppressWarnings("unchecked")
    public <T> T get(String cucumberElementName) {
        Class<?> clazz = this.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Name.class)) {
                Name nameAnnotation = field.getAnnotation(Name.class);
                if (nameAnnotation.value().equals(cucumberElementName)) {
                    try {
                        field.setAccessible(true);
                        return (T) field.get(this);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        throw new IllegalArgumentException("ERROR: there is no such element with name " + cucumberElementName + " at page " + this.getClass().getName());
    }

    public SelenideElement getElement(String cucumberElementName) {
        try {
            return (SelenideElement) get(cucumberElementName);
        } catch (ClassCastException ex) {
            logger.error("Can't cast to SelenideElement:'" + cucumberElementName + "'");
            ex.printStackTrace();
            throw ex;
        }
    }
}
