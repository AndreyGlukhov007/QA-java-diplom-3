import POM.AuthorizationPOM;
import POM.MainPagePOM;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonalAccountTest {

    private WebDriver driver;

    @BeforeEach
    public void runDriver(){
        driver = RunBrowsers.getWebDriver(Browser.CHROME);
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    // Проверь переход по клику на «Личный кабинет».
    @Test
    public void inPersonalAccountTest(){

        MainPagePOM mainPagePOM = new MainPagePOM(driver); // Зайти на главную страницу
        mainPagePOM.clickPersonalAccountButton(); // Нажать на кнопку "Личный Кабинет"

        AuthorizationPOM authorizationPOM = new AuthorizationPOM(driver);
        WebElement emailTest = driver.findElement(authorizationPOM.getEmail()); // Вернуть локатор поля email.
        WebElement passwordTest = driver.findElement(authorizationPOM.getEmail()); // Вернуть локатор поля email.

        assertTrue(emailTest.isDisplayed(), "Текст в поле \"Email\" должен быть видимый"); // Проверяем, что кнопка отображается
        assertTrue(passwordTest.isDisplayed(), "Текст в поле \"Пароль\" должен быть видимый"); // Проверяем, что кнопка отображается
    }
    // Проверь переход по клику на «Конструктор».
    @Test
    public void inTransitionConstructorTest() {

        MainPagePOM mainPagePOM = new MainPagePOM(driver); // Зайти на главную страницу
        mainPagePOM.clickPersonalAccountButton(); // Нажать на кнопку "Личный Кабинет"

        mainPagePOM.clickСonstructorButton(); //клик по кнопке "Конструктор".

        WebElement inButton = driver.findElement(mainPagePOM.returnInButton()); // Вернуть локатор кнопки "Оформить заказ".

        assertTrue(inButton.isDisplayed(), "Кнопка должна быть видимой"); // Проверяем, что кнопка отображается
    }

    // Проверь переход по клику на логотип Stellar Burgers.
    @Test
    public void inTransitionLogoTest() {

        MainPagePOM mainPagePOM = new MainPagePOM(driver); // Зайти на главную страницу
        mainPagePOM.clickPersonalAccountButton(); // Нажать на кнопку "Личный Кабинет"

        mainPagePOM.clickToLogo(); //клик по логотипу бургера.

        WebElement inButton = driver.findElement(mainPagePOM.returnLogo()); // Вернуть локатор логотипа Бургер.

        assertTrue(inButton.isDisplayed(), "Кнопка должна быть видимой"); // Проверяем, что кнопка отображается
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

}
