package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class PageObjectOrder {
    private WebDriver driver;
    //Локатор
    private By Order1 = By.className("Button_Button__ra12g"); //Локатор кнопки "Заказать №1"
    private By OrderButton =  By.xpath(".//button[@class ='Button_Button__ra12g Button_Middle__1CSJM']");    //Локатор кнопки "Заказать №2"
    public By name = By.xpath("//input[@placeholder = '* Имя']"); //Локатор поля "Имя"
    private By family = By.xpath("//input[@placeholder = '* Фамилия']"); //Локатор поля "Фамилия"
    private By adress = By.xpath("//input[@placeholder = '* Адрес: куда привезти заказ']"); //Локатор поля "Адреса"
    private By metro = By.xpath("//input[@placeholder = '* Станция метро']"); //Локатор поля "Станция метро"
    private By phone = By.xpath("//input[@placeholder = '* Телефон: на него позвонит курьер']"); //Локатор поля "Телефон"
    private By metroSearch = By.className("select-search__select"); //Локатор выпадающего списка метро

    private By date = By.xpath("//input[@placeholder = '* Когда привезти самокат']"); //Локатор поля "Когда привезти самокат

    private By timeSelect = By.className("Dropdown-arrow"); //Локатор поля "Пиктограммы выпадающего списка
    private By comment = By.xpath("//input[@placeholder = 'Комментарий для курьера']"); //Локатор поля "Комментарий"

    private By orderNext = By.xpath(".//button[contains(text(),'Далее')]"); //Локатор кнопки "Далее"


    private By OrderPopup = By.className("Order_Modal__YZ-d3");

    //Методы

    //Клик по кнопке "Заказать1"
    public void orderButton1Click() {
        WebElement element = driver.findElement(Order1); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(Order1).isEnabled()); //Убедись, что он доступен
        driver.findElement(Order1).click(); //Нажми на элемент
    }
    //Клик по кнопке "Заказать2"
    public void orderButton2Click() {
        WebElement element = driver.findElement(OrderButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(OrderButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(OrderButton).click(); //Нажми на элемент
    }

    //Клик по кнопке "Далее"
    public void orderButtonOrderNext() {
        WebElement element = driver.findElement(orderNext); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(orderNext).isEnabled()); //Убедись, что он доступен
        driver.findElement(orderNext).click(); //Нажми на элемент
    }

    //Клик по кнопку "Заказать в финале"
    public void orderButtonOrder() {
        WebElement element = driver.findElement(OrderButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(OrderButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(OrderButton).click(); //Нажми на элемент
    }

    //Проверка, что окно "Хотите оформить заказ?" доступно
    public void OrderPopupIsEnabled(){
        WebElement element = driver.findElement(OrderPopup); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(OrderPopup).isEnabled()); //Убедись, что он доступен
    }

    //Заполнение полей "Заказ"
    public void setField1(String nameSet, String familySet, String adressSet, String metroSet, String phoneSet, String dateSet, String timeSet , String colorSet, String commentSet) {
        driver.findElement(name).sendKeys(nameSet); //Введи имя
        driver.findElement(family).sendKeys(familySet); //Введи фамилию
        driver.findElement(adress).sendKeys(adressSet); //Адрес
        driver.findElement(metro).sendKeys(metroSet); //Введи название станции метро
        driver.findElement(metroSearch).click(); //Кликни на станцию метро в списке
        driver.findElement(phone).sendKeys(phoneSet); //Введи номер телефона
        driver.findElement(orderNext).click(); //Нажми на кнопку "Далее"
        driver.findElement(date).sendKeys(dateSet); //Введи дату
        driver.findElement(timeSelect).click(); //Кликни по стрелке выбора срока аренды
        driver.findElement(By.xpath(".//div[@class = 'Dropdown-menu']/div[" + timeSet +"]")).click(); //Выбор времени аренды
        driver.findElement(By.id(colorSet)).click(); //Введи цвет самоката
        driver.findElement(comment).sendKeys(commentSet); //Введи комментарий
    }


    public PageObjectOrder(WebDriver driver) {
        this.driver = driver;
    }

}
