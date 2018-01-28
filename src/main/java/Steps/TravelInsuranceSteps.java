package Steps;

import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;
import static org.junit.Assert.assertTrue;


/**
 * Created by Varderesyan Tsolak on 22.01.2018.
 */
public class TravelInsuranceSteps extends BaseSteps {

    @Step("заголовок страницы равен - {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = new TravelInsurancePage(driver).title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("Выполнено нажатие на кнопку Оформить")
    public void stepExecuteButton() {
        new TravelInsurancePage(driver).executeButton.click();

    }

}
