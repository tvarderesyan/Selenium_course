package Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


/**
 * Created by Varderesyan Tsolak on 28.01.2018.
 */
public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
    SelectInsuranceSteps selectInsuranceSteps = new SelectInsuranceSteps();
    SendAppSteps sendAppSteps = new SendAppSteps();

    @When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem) {

        mainSteps.selectMenuItem(menuItem);
    }

    @When("^выбран вид страхования = \"(.*)\"$")
    public void stepSelectMenuInsurance(String menuItem) {

        mainSteps.selectMenuInsurance(menuItem);
    }

    @Then("^заголовок страницы равен \"(.+)\"$")
    public void checkTitleDMSPage(String title) {
        travelInsuranceSteps.checkPageTitle(title);
    }

    @When("^Выполнено нажатие на кнопку Оформить$")
    public void stepSelectTravelInsurance() {
        travelInsuranceSteps.stepExecuteButton();
    }

    @When("^выбрано тип страхования Минимальная")
    public void stepSelectInsuranceType() {
        selectInsuranceSteps.chooseType();
    }

    @When("^выполнено нажатие на Офромить")
    public void stepSelectInsurance() {
        selectInsuranceSteps.goToSendAppPage();
    }

    @When("^заполняются поля: $")
    public void stepFillFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (k, v) -> sendAppSteps.stepfillField(k, v));
    }

    @Then("^поля заполнены верно:$")
    public void stepcheckFillFields(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> sendAppSteps.checkFillField(field, value));
    }

    @When("^Выполнено нажатие на кнопку Оформить")
    public void stepSelectExecuteButton() {
        sendAppSteps.stepExecuteButton();
    }

    @Then("^Присутствует сообщение об ошибке: ")
    public void checkErrorMessage(String errorMessage) {
        sendAppSteps.checkErrorMessage(errorMessage);
    }

}

