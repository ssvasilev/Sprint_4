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
    public By nameInput = By.xpath("//input[@placeholder = '* Имя']"); //Локатор поля "Имя"
    private By familyInput = By.xpath("//input[@placeholder = '* Фамилия']"); //Локатор поля "Фамилия"
    private By adressInput = By.xpath("//input[@placeholder = '* Адрес: куда привезти заказ']"); //Локатор поля "Адреса"
    private By metroInput = By.xpath("//input[@placeholder = '* Станция метро']"); //Локатор поля "Станция метро"
    private By phoneInput = By.xpath("//input[@placeholder = '* Телефон: на него позвонит курьер']"); //Локатор поля "Телефон"
    private By metroSearchInput = By.className("select-search__select"); //Локатор выпадающего списка метро

    private By dateInput = By.xpath("//input[@placeholder = '* Когда привезти самокат']"); //Локатор поля "Когда привезти самокат

    private By timeSelectInput = By.className("Dropdown-arrow"); //Локатор поля "Пиктограммы выпадающего списка
    private By commentInput = By.xpath("//input[@placeholder = 'Комментарий для курьера']"); //Локатор поля "Комментарий"

    private By orderNextInput = By.xpath(".//button[contains(text(),'Далее')]"); //Локатор кнопки "Далее"

    private By OrderPopupInput = By.className("Order_Modal__YZ-d3");



    //Методы
    //Клик по кнопке "Заказать1"
    public void orderHeadButtonClick() {
        WebElement element = driver.findElement(OrderHeadButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(OrderHeadButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(OrderHeadButton).click(); //Нажми на элемент
    }
    //Клик по кнопке "Заказать2"
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


    //Клик по кнопке "Далее"
    public void orderButtonOrderNext() {
        WebElement element = driver.findElement(orderNextInput); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(orderNextInput).isEnabled()); //Убедись, что он доступен
        driver.findElement(orderNextInput).click(); //Нажми на элемент
    }

    //Проверка, что окно "Хотите оформить заказ?" доступно
    public void OrderPopupIsEnabled(){
        WebElement element = driver.findElement(OrderPopupInput); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(OrderPopupInput).isEnabled()); //Убедись, что он доступен
    }

    //Заполнение полей "Заказ"
    public void setField1(String nameSet, String familySet, String adressSet, String metroSet, String phoneSet, String dateSet, String timeSet , String colorSet, String commentSet) {
        driver.findElement(nameInput).sendKeys(nameSet); //Введи имя
        driver.findElement(familyInput).sendKeys(familySet); //Введи фамилию
        driver.findElement(adressInput).sendKeys(adressSet); //Адрес
        driver.findElement(metroInput).sendKeys(metroSet); //Введи название станции метро
        driver.findElement(metroSearchInput).click(); //Кликни на станцию метро в списке
        driver.findElement(phoneInput).sendKeys(phoneSet); //Введи номер телефона
        driver.findElement(orderNextInput).click(); //Нажми на кнопку "Далее"
        driver.findElement(dateInput).sendKeys(dateSet); //Введи дату
        driver.findElement(timeSelectInput).click(); //Кликни по стрелке выбора срока аренды
        driver.findElement(By.xpath(".//div[@class = 'Dropdown-menu']/div[" + timeSet +"]")).click(); //Выбор времени аренды
        driver.findElement(By.id(colorSet)).click(); //Введи цвет самоката
        driver.findElement(commentInput).sendKeys(commentSet); //Введи комментарий
    }


}
