import org.junit.Test;
import pages.MainPage;
import pages.SendAppPage;
import pages.TravelInsurancePage;


/**
 * Created by Varderesyan Tsolak on 21.01.2018.
 */
public class MyRefactoringTest extends BaseTest {

    @Test

    public void newInsuranceTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectmainMenu("Застраховать себя ");
        mainPage.selectsubMenu("Страхование путешественников");

        new TravelInsurancePage(driver).executeButton.click();

        SendAppPage sendAppPage = new SendAppPage(driver);
        sendAppPage.fillField("Фамилия/Surname", "Ivanov");
        sendAppPage.fillField("Имя/Given names", "Ivan");
        sendAppPage.fillField("Дата рождения", "10101988");
        sendAppPage.fillField("Фамилия", "Иванов");
        sendAppPage.fillField("Имя", "Иван");
        sendAppPage.fillField("Отчество", "Ивановович");
        sendAppPage.fillField("Дата рождения1", "10101988");
        sendAppPage.fillField("Серия паспорта", "4405");
        sendAppPage.fillField("Номер паспорта", "998877");
        sendAppPage.fillField("Дата выдачи", "10102016");
        sendAppPage.fillField("Кем выдан", "УФМС России");

    }

}