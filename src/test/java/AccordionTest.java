import PageObject.PajeObjectAccordion;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class AccordionTest {

    private int number;

    private String text;


public AccordionTest(int number, String text){
    this.number = number;
    this.text = text;
    }

    //Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getDataOrder() {
        return new Object[][]{
                {0,"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1,"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2,"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3,"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4,"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5,"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6,"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7,"Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    private WebDriver driver;

    @Test
    public void AccordionTest() {
        // создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переходим на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //создай объект класса
        PajeObjectAccordion objMainPage = new PajeObjectAccordion(driver);
        //Клик по панели аккордиона
        objMainPage.clickAccordionButton(number);
        //Получение текста из панели аккордиона
        String realtext = objMainPage.getAccordionPanelText(number);
        //Проверь, что текст строки соответствует образцу
        assertThat(realtext, equalTo(text));
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}
