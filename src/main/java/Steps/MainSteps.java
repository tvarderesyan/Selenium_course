package Steps;

import org.openqa.selenium.WebDriver;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by MY on 22.01.2018.
 */
public class MainSteps extends BaseSteps {

    @Step("выбран пункт меню {0}")
    public void selectMenuItem(String menuItem){
        new MainPage(driver).selectmainMenu(menuItem);
    }

    @Step("выбран вид страхования {0}")
    public void selectMenuInsurance(String menuItem){

        new MainPage(driver).selectsubMenu(menuItem);
    }

}
