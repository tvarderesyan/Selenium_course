package Steps;

import pages.MainPage;
import pages.SelectInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

/**
 * Created by MY on 26.01.2018.
 */
public class SelectInsuranceSteps extends BaseSteps {

    @Step("выбрано тип страхования Минимальная")
    public void chooseType() {

        new SelectInsurancePage(driver).type.click();
    }

    @Step("выполнено нажатие на Офромить")
    public void goToSendAppPage() {
        new SelectInsurancePage(driver).sendButton.click();
    }
}
