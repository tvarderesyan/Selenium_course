import Steps.*;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.HashMap;


/**
 * Created by MY on 26.01.2018.
 */
public class SeleniumLearningTask3 extends BaseSteps {

    @Title("Заявка на Страхование путешественников")
    @Test
    public void Test() {

    MainSteps mainSteps = new MainSteps();
    TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
    SendAppSteps sendAppSteps = new SendAppSteps();
    SelectInsuranceSteps selectInsuranceSteps = new SelectInsuranceSteps();

    HashMap<String, String> testData = new HashMap<>();
        testData.put("Фамилия/Surname", "Ivanov");
        testData.put("Имя/Given names", "Ivan");
        testData.put("Дата рождения", "10.10.1988");
        testData.put("Фамилия", "Иванов");
        testData.put("Имя", "Иван");
        testData.put("Отчество", "Иванович");
        testData.put("Дата рождения1", "10.11.1988");
        testData.put("Серия паспорта", "4408");
        testData.put("Номер паспорта", "998877");
        testData.put("Дата выдачи", "09.11.2016");
        testData.put("Кем выдан", "УФМС России");


        mainSteps.selectMenuItem("Застраховать себя ");
        mainSteps.selectMenuInsurance("Страхование путешественников");
        travelInsuranceSteps.checkPageTitle("Страхование путешественников");
        travelInsuranceSteps.stepExecuteButton();

        for (String handle1 : driver.getWindowHandles()) {
            driver.switchTo().window(handle1);
        }

        selectInsuranceSteps.chooseType();
        selectInsuranceSteps.goToSendAppPage();



        sendAppSteps.fillField(testData);
        sendAppSteps.checkFillFields(testData);
        sendAppSteps.stepExecuteButton();
        sendAppSteps.checkErrorMessage("Заполнены не все обязательные поля");
    }

}
