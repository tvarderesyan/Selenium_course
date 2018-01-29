import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.String;

public class SeleniumLearningTask1 {
    private WebDriver driver;
    private String baseUrl;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");

        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/");

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//SPAN[@class='multiline'])[5]"))));

        WebElement element = driver.findElement(By.xpath("(//SPAN[@class='multiline'])[5]"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//A[@class='kit-link kit-link_color_black alt-menu-list__link alt-menu-list__link_level_1'])[36]"))));
        WebElement subElement = driver.findElement(By.xpath("(//A[@class='kit-link kit-link_color_black alt-menu-list__link alt-menu-list__link_level_1'])[36]"));
        action.moveToElement(subElement);
        action.click();
        action.perform();

        //Checking header "Страхование путешественников"
        WebElement title = driver.findElement(By.xpath("//H1[text()='Страхование путешественников']"));
        Assert.assertEquals("Страхование путешественников", title.getText());


        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//IMG[@src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']"))));
        driver.findElement(By.xpath("//IMG[@src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']")).click();

        //Change to new tap
        for (String handle1 : driver.getWindowHandles()) {
            System.out.println(handle1);
            driver.switchTo().window(handle1);
        }

        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//DIV[@class='b-form-box-title ng-binding'][text()='Минимальная']"))));
        driver.findElement(By.xpath("//DIV[@class='b-form-box-title ng-binding'][text()='Минимальная']")).click();
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//*[@ng-click='save()'][text()='Оформить']"))));
        driver.findElement(By.xpath("//*[@ng-click='save()'][text()='Оформить']")).click();


        //Filling the fields on the page
        fillField(By.name("insured0_surname"), "Ivanov");
        fillField(By.name("insured0_name"), "Ivan");
        fillField(By.name("insured0_birthDate"), "12091990");
        fillField(By.name("surname"), "Тестов");
        fillField(By.name("name"), "Тест");
        fillField(By.name("middlename"), "Тестович");
        driver.findElement(By.xpath("(//INPUT[@ng-model='formdata.insurer.GENDER'])[2]")).click();
        fillField(By.name("birthDate"), "10101988");
        fillField(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']"), "4405");
        fillField(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']"), "998877");
        fillField(By.name("issueDate"), "12102000");
        fillField(By.name("issuePlace"), "Москва, Ленинский проспкт, 10");

        //Check for correctness of data filling
        Assert.assertEquals("Ivanov", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        Assert.assertEquals("Ivan", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        Assert.assertEquals("12.09.1990", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        Assert.assertEquals("Тестов", driver.findElement(By.name("surname")).getAttribute("value"));
        Assert.assertEquals("Тест", driver.findElement(By.name("name")).getAttribute("value"));
        Assert.assertEquals("Тестович", driver.findElement(By.name("middlename")).getAttribute("value"));
        Assert.assertEquals("10.10.1988", driver.findElement(By.name("birthDate")).getAttribute("value"));
        Assert.assertEquals("1", driver.findElement(By.name("female")).getAttribute("value"));
        Assert.assertEquals("4405", driver.findElement(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']")).getAttribute("value"));
        Assert.assertEquals("998877", driver.findElement(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']")).getAttribute("value"));
        Assert.assertEquals("12.10.2000", driver.findElement(By.name("issueDate")).getAttribute("value"));
        Assert.assertEquals("Москва, Ленинский проспкт, 10", driver.findElement(By.name("issuePlace")).getAttribute("value"));

        driver.findElement(By.xpath("//*[@ng-click='save()'][text()='Продолжить']")).click();

        Assert.assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")).getText());

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void fillField(By locator, String value) {
        //driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
}
