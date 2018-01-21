package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Varderesyan Tsolak on 21.01.2018.
 */
public class MainPage {

    @FindBy(xpath = "(//SPAN[@class='multiline'])[5]")
    WebElement mainMenu;

    @FindBy(xpath = "(//A[@class='kit-link kit-link_color_black alt-menu-list__link alt-menu-list__link_level_1'])[36]")
    WebElement subMenu;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public void selectmainMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//li[contains(@class,'multiline')]/*[contains(text(),'"+menuItem+"')]")).click();
    }

    public void selectsubMenu(String menuItem){
subMenu.findElement(By.xpath(".//li[contains(@class,'kit-link kit-link_color_black alt-menu-list__link alt-menu-list__link_level_1')]/*[contains(text(),'"+menuItem+"')]")).click();
    }





}
