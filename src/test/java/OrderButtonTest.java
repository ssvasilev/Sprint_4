import PageObject.PageObjectOrder;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Parameterized.class)
public class OrderButtonTest {
    private final String nameSet;
    private final String familySet;
    private final String adressSet;
    private final String metroSet;
    private final String phoneSet;
    private final String dateSet;
    private final String timeSet;
    private final String colorSet;
    private final String commentSet;


    public OrderButtonTest(String nameSet, String familySet, String adressSet, String metroSet, String phoneSet, String dateSet, String timeSet, String colorSet, String commentSet) {

        this.nameSet = nameSet;
        this.familySet = familySet;
        this.adressSet = adressSet;
        this.metroSet = metroSet;
        this.phoneSet = phoneSet;
        this.dateSet = dateSet;
        this.timeSet = timeSet;
        this.colorSet = colorSet;
        this.commentSet = commentSet;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getDataOrder() {
        return new Object[][]{ //Срок аренды от 1 до 7, варианты цвета: black или grey
                {"Никита", "Комбаров", "Комсомольская ул., д. 6 кв.152", "Черкизовская", "89888678901", "30.11.2022\n", "1", "black", "Прикрепить бантик на руль"},
                {"Пётр", "Петрович", "Чкалова ул., д. 15 кв.55", "Китай-город", "89881235897", "22.08.2023\n", "2", "grey", "Оставить у двери"},
                {"Леонид", "Горюшин", "Вокзальная ул., д. 19 кв.170", "Речной вокзал", "89882836886", "27.05.2024\n", "3", "black", " "},
                {"Леонид", "Габулов", "Мира ул., д. 20 кв.35", "Комсомольская", "89889783152", "13.05.2024\n", "4", "grey", "Ничего не делать"},
                {"Николай", "Москвитин", "Солнечная ул., д. 9 кв.9", "ВДНХ", "89884268015", "27.04.2023\n", "5", "black", "Прокатиться при клиенте"},
                {"Виктор", "Лыткин", "Калинина ул., д. 19 кв.76", "Бабушкинская", "89881284948", "27.12.2023\n", "6", "grey", "Проверить шины"},
                {"Давид", "Авилов", "Спортивная ул., д. 22 кв.203", "Сокол", "89887832635", "21.07.2023\n", "7", "black", "Позвонить с этажа"},
        };
    }


    private WebDriver driver;

    @Test
    public void OrderTest1Run() {
        // создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переходим на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //создай объект класса
        PageObjectOrder objMainPage = new PageObjectOrder(driver);
        //Нажми на кнопку заказать
        objMainPage.orderButton1Click();
        //Заполняем поля на страницах заказа
        objMainPage.setField1(nameSet, familySet, adressSet, metroSet, phoneSet,dateSet, timeSet, colorSet, commentSet);
        //Нажимаем на кнопку "Заказать" в форме заказа
        objMainPage.orderButtonOrder();
        //Ожидаем появление окна подтверждения
        objMainPage.OrderPopupIsEnabled();
    }

    @Test
    public void OrderTest2Run() {
        // создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переходим на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //создай объект класса
        PageObjectOrder objMainPage = new PageObjectOrder(driver);
        //Нажми на кнопку заказать
        objMainPage.orderButton2Click();
        //Заполняем поля на страницах заказа
        objMainPage.setField1(nameSet, familySet, adressSet, metroSet, phoneSet,dateSet, timeSet, colorSet, commentSet);
        //Нажимаем на кнопку "Заказать" в форме заказа
        objMainPage.orderButtonOrder();
        //Ожидаем появление окна подтверждения
        objMainPage.OrderPopupIsEnabled();
    }

    @After
    public void tearDown() {
        // Закрой браузер
         driver.quit();
    }
}