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

    @FindBy(xpath = "(//div[contains(@class,'l-header-inside g-cleared')])")
    public WebElement title;

    @FindBy(xpath = "//DIV[contains(@class,'b-form-prog-note ng-binding')]")
    WebElement type;


    @FindBy(xpath = "//span[contains(@class,'b-button-block-center')]")
    WebElement sendButton;

    public SelectInsurancePage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
public void findTitle(String menuItem){
        title.findElement(By.xpath("(//H2[@class='l-header-title ng-binding'][text()='Страхование путешественников'][text()='Страхование путешественников'])[1]"));
}

    public void selecType(String menuItem){
        type.findElement(By.xpath("(//DIV[@ng-click='setProdProg(prodProg)'])[1]")).click();
    }

    public void send(String menuItem){
        sendButton.findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Оформить']")).click();
    }




}
