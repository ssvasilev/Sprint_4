package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {

    private WebDriver driver;

    //Локаторы
    public By nameInput = By.xpath("//input[@placeholder = '* Имя']"); //Локатор поля "Имя"
    private By familyInput = By.xpath("//input[@placeholder = '* Фамилия']"); //Локатор поля "Фамилия"
    private By adressInput = By.xpath("//input[@placeholder = '* Адрес: куда привезти заказ']"); //Локатор поля "Адреса"
    private By metroInput = By.xpath("//input[@placeholder = '* Станция метро']"); //Локатор поля "Станция метро"
    private By phoneInput = By.xpath("//input[@placeholder = '* Телефон: на него позвонит курьер']"); //Локатор поля "Телефон"
    private By metroSearchInput = By.className("select-search__select"); //Локатор выпадающего списка метро

    private By dateInput = By.xpath("//input[@placeholder = '* Когда привезти самокат']"); //Локатор поля "Когда привезти самокат

    private By timeSelectInput = By.className("Dropdown-arrow"); //Локатор поля "Пиктограммы выпадающего списка
    private By commentInput = By.xpath("//input[@placeholder = 'Комментарий для курьера']"); //Локатор поля "Комментарий"

    private By nextStepButton = By.xpath("//button[@class ='Button_Button__ra12g Button_Middle__1CSJM']"); // Локатор для кнопки с текстами "Далее" / "Заказать" / "Да"

    private By OrderPopupInput = By.className("Order_Modal__YZ-d3");

    //Методы
    //Клик по кнопке "Далее"
    public void clickNextStepOrder() {
        WebElement element = driver.findElement(nextStepButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(nextStepButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(nextStepButton).click(); //Нажми на элемент
    }

    //Проверка, что окно "Хотите оформить заказ?" доступно
    public void OrderPopupIsEnabled(){
        WebElement element = driver.findElement(OrderPopupInput); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(OrderPopupInput).isEnabled()); //Убедись, что он доступен
    }

    //Заполнение полей "Заказ"
    public void setFieldOrder(String nameSet, String familySet, String adressSet, String metroSet, String phoneSet, String dateSet, String timeSet , String colorSet, String commentSet) {
        driver.findElement(nameInput).sendKeys(nameSet); //Введи имя
        driver.findElement(familyInput).sendKeys(familySet); //Введи фамилию
        driver.findElement(adressInput).sendKeys(adressSet); //Адрес
        driver.findElement(metroInput).sendKeys(metroSet); //Введи название станции метро
        driver.findElement(metroSearchInput).click(); //Кликни на станцию метро в списке
        driver.findElement(phoneInput).sendKeys(phoneSet); //Введи номер телефона
        driver.findElement(nextStepButton).click(); //Нажми на кнопку "Далее"
        driver.findElement(dateInput).sendKeys(dateSet); //Введи дату
        driver.findElement(timeSelectInput).click(); //Кликни по стрелке выбора срока аренды
        driver.findElement(By.xpath(".//div[@class = 'Dropdown-menu']/div[" + timeSet +"]")).click(); //Выбор времени аренды
        driver.findElement(By.id(colorSet)).click(); //Введи цвет самоката
        driver.findElement(commentInput).sendKeys(commentSet); //Введи комментарий
    }

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
}
