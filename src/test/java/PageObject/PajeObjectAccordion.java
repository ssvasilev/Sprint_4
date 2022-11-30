package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PajeObjectAccordion {
    private WebDriver driver;


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

    public PajeObjectAccordion(WebDriver driver) {
        this.driver = driver;
    }
}

