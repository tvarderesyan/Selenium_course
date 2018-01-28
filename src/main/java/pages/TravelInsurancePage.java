package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Varderesyan Tsolak on 21.01.2018.
 */
public class TravelInsurancePage {

    @FindBy(xpath = "(//H1[text()='Страхование путешественников'])[1]")
    public WebElement title;

    @FindBy(xpath = "//IMG[@src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']")
    public WebElement executeButton;

    public TravelInsurancePage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }


}