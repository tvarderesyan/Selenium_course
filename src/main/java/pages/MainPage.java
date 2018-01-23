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

    @FindBy(xpath = "//DIV[contains(@class,'sbrf-div-list-inner --area bp-area header_more_nav')]")
    WebElement mainMenu;


    @FindBy(xpath = "//DIV[contains(@class,'alt-menu-collapser__area alt-menu-collapser__area_cols_3')]")
    WebElement subMenu;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, );
    }


    public void selectmainMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//span[contains(@class,'multiline')]/*[contains(text(),'"+menuItem+"')]")).click();
    }

    public void selectsubMenu(String menuItem){
        subMenu.findElement(By.xpath(".//div//a[contains(@class,'kit-link kit-link_color_black alt-menu-list__link alt-menu-list__link_level_1')]/*[contains(text(),'"+menuItem+"')]")).click();
    }





}