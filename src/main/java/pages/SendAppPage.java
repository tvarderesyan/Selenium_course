package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Varderesyan Tsolak on 21.01.2018.
 */
public class SendAppPage {
    WebDriver driver;

    @FindBy(xpath = "(//H2[@class='l-header-title ng-binding'][text()='Страхование путешественников'][text()='Страхование путешественников'])[1]")
    public WebElement title;

    @FindBy(name = "insured0_surname")
    WebElement lastNameEng;

    @FindBy(name = "insured0_name")
    WebElement firstNameEng;

    @FindBy(name = "insured0_birthDate")
    WebElement insuredBirthday;

    @FindBy(name = "surname")
    WebElement lastName;

    @FindBy(name = "name")
    WebElement firstName;

    @FindBy(name = "middlename")
    WebElement middleName;

    @FindBy(xpath = "(//INPUT[@ng-model='formdata.insurer.GENDER'])[2]")
    WebElement gender;

    @FindBy(name = "birthDate")
    WebElement birthDate;

    @FindBy(xpath = "//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']")
    WebElement serialNumber;

    @FindBy(xpath = "//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']")
    WebElement number;

    @FindBy(name = "issueDate")
    WebElement issueDate;

    @FindBy(name = "issuePlace")
    WebElement issuePlace;

    @FindBy(xpath = "//*[@ng-click='save()'][text()='Продолжить']")
    public WebElement continueButton;

    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(title));
        this.driver = driver;
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {

            case "Фамилия/Surname":
                fillField(lastNameEng, value);
                break;
            case "Имя/Given names":
                fillField(firstNameEng, value);
                break;
            case "Дата рождения":
                fillField(insuredBirthday, value);
                break;
            case "Фамилия":
                fillField(lastName, value);
                break;
            case "Имя":
                fillField(firstName, value);
                break;
            case "Отчество":
                fillField(middleName, value);
                break;
            case "Дата рождения1":
                fillField(birthDate, value);
                birthDate.sendKeys(Keys.TAB);
                break;
            case "Пол":
                gender.click();
                break;
            case "Серия паспорта":
                fillField(serialNumber, value);
                break;
            case "Номер паспорта":
                fillField(number, value);
                break;
            case "Дата выдачи":
                fillField(issueDate, value);
                break;
            case "Кем выдан":
                fillField(issuePlace, value);
                break;
            case "Продолжить":
                continueButton.click();
                break;

            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    protected void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
}