package Steps;

import Steps.BaseSteps;
import pages.SendAppPage;
import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

/**
 * Created by MY on 22.01.2018.
 */
public class SendAppSteps extends BaseSteps {

    @Step("Поле {0} заполняется значением {1}")
    public void stepfillField(String field, String value) {
        new SendAppPage(driver).fillField(field, value);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value) {
        String actual = new SendAppPage(driver).getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("заполняются поля")
    public void fillField(HashMap<String, String> fields) {
        fields.forEach(this::stepfillField);
    }

    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields) {
        fields.forEach((k, v) -> checkFillField(k, v));
    }

    @Step("Выполнено нажатие на кнопку Отправить")
    public void stepExecuteButton() {
        new SendAppPage(driver).continueButton.click();

    }
    @Step("Присутствует сообщение об ошибке {0}")
    public void checkErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = new SendAppPage(driver).errorMessage.getText();
        assertTrue(String.format("Сообщение об ошибке [%s]. Ожидалось - [%s]",
                actualErrorMessage, expectedErrorMessage), actualErrorMessage.contains(expectedErrorMessage));
    }

}
