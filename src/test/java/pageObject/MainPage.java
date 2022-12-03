package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локаторы

    private By OrderHeadButton = By.className("Button_Button__ra12g"); //Локатор кнопки "Заказать" в шапке

    private By OrderMiddleButton =  By.xpath(".//button[@class ='Button_Button__ra12g Button_Middle__1CSJM']"); //Локатор кнопки "Заказать №2"


    //Методы
    //Клик по кнопке "Заказать" в заголовке
    public void orderHeadButtonClick() {
        WebElement element = driver.findElement(OrderHeadButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(OrderHeadButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(OrderHeadButton).click(); //Нажми на элемент
    }
    //Клик по кнопке "Заказать\Далее\Да"
    public void orderMiddleButtonClick() {
        WebElement element = driver.findElement(OrderMiddleButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(OrderMiddleButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(OrderMiddleButton).click(); //Нажми на элемент
    }


    //Метод клика по панели
    public void clickAccordionButton(int num) {
        WebElement element = driver.findElement(By.id("accordion__heading-" + num)); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(By.id("accordion__heading-" + num)).isEnabled()); //Убедись, что он доступен
        driver.findElement(By.id("accordion__heading-" + num)).click(); //Нажми на элемент
    }

    //Метод получения текста из панели аккордиона
    public String getAccordionPanelText(int num) {
        WebElement element = driver.findElement(By.id("accordion__panel-" + num));
        return element.getAttribute("innerText");
    }


}
