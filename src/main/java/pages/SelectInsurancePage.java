package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by MY on 24.01.2018.
 */
public class SelectInsurancePage {

        @FindBy(xpath = "//DIV[contains(@class,'b-form-prog-note ng-binding')]")
    public WebElement type;


    @FindBy(xpath = "//span[contains(@class,'b-button-block-center')]")
    public WebElement sendButton;

    public SelectInsurancePage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
