import POM.AuthorizationPOM;
import POM.MainPagePOM;
import POM.RecoverPasswordPOM;
import POM.RegistrationPOM;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;
// Вход (Тестирование авторизации).
public class AuthorizationTest {

    private WebDriver driver;

    @BeforeEach
    public void runDriver(){
        driver = RunBrowsers.getWebDriver(Browser.CHROME);
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    // Авторизация пользователя. Вход по кнопке «Войти в аккаунт» на главной.
    @Test
    public void authorizationTest(){

        MainPagePOM mainPagePOM = new MainPagePOM(driver); // Зайти на главную страницу
        mainPagePOM.clickToInButton(); // Нажать на кнопку "Войти в аккаунт"

        AuthorizationPOM authorizationPOM = new AuthorizationPOM(driver);
        authorizationPOM.clickEmail();
        authorizationPOM.writeEmail("Test31072025@mail.ru"); // Заполнить поле email
        authorizationPOM.clickPassword();
        authorizationPOM.writePassword("qwerty"); // Заполнить поле "Пароль".
        authorizationPOM.clickInButton();

        WebElement buttonOrder = driver.findElement(mainPagePOM.getLocatorOrderButton()); // Вернуть локатор кнопки "Оформить заказ".

        assertTrue(buttonOrder.isDisplayed(), "Кнопка должна быть видимой"); // Проверяем, что кнопка отображается
    }

    // Авторизация пользователя. Вход по кнопке «Личный Кабинет» на главной.
    @Test
    public void authorizationPersonalAccountButtonTest(){

        MainPagePOM mainPagePOM = new MainPagePOM(driver); // Зайти на главную страницу
        mainPagePOM.clickPersonalAccountButton(); // Нажать на кнопку "Личный Кабинет"

        AuthorizationPOM authorizationPOM = new AuthorizationPOM(driver);
        authorizationPOM.clickEmail();
        authorizationPOM.writeEmail("Test31072025@mail.ru"); // Заполнить поле email
        authorizationPOM.clickPassword();
        authorizationPOM.writePassword("qwerty"); // Заполнить поле "Пароль".
        authorizationPOM.clickInButton();

        WebElement buttonOrder = driver.findElement(mainPagePOM.getLocatorOrderButton()); // Вернуть локатор кнопки "Оформить заказ".

        assertTrue(buttonOrder.isDisplayed(), "Кнопка должна быть видимой"); // Проверяем, что кнопка отображается
    }

    // Авторизация пользователя. Вход через кнопку в форме регистрации.
    @Test
    public void authorizationButtonRegistrationTest(){

        MainPagePOM mainPagePOM = new MainPagePOM(driver); // Зайти на главную страницу
        mainPagePOM.clickToInButton(); // Нажать на кнопку "Войти в аккаунт"
        // Зайти на страницу авторизации.
        AuthorizationPOM authorizationPOM = new AuthorizationPOM(driver);
        authorizationPOM.clickButtonRegistration(); // Нажать на кнопку "Зарегистрироваться"
        // Зайти на страницу регистрации
        RegistrationPOM registrationPOM = new RegistrationPOM(driver);
        registrationPOM.clicklinlIn(); // Нажать на ссылку "Войти".
        // Заполнение полей на форме авторизации.
        authorizationPOM.clickEmail();
        authorizationPOM.writeEmail("Test31072025@mail.ru"); // Заполнить поле email
        authorizationPOM.clickPassword();
        authorizationPOM.writePassword("qwerty"); // Заполнить поле "Пароль".
        authorizationPOM.clickInButton();

        WebElement buttonOrder = driver.findElement(mainPagePOM.getLocatorOrderButton()); // Вернуть локатор кнопки "Оформить заказ".

        assertTrue(buttonOrder.isDisplayed(), "Кнопка должна быть видимой"); // Проверяем, что кнопка отображается
    }

    // Авторизация пользователя. Вход через кнопку в форме восстановления пароля.
    @Test
    public void authorizationRecoverPasswordTest(){

        MainPagePOM mainPagePOM = new MainPagePOM(driver); // Зайти на главную страницу
        mainPagePOM.clickToInButton(); // Нажать на кнопку "Войти в аккаунт"
        // Зайти на страницу авторизации.
        AuthorizationPOM authorizationPOM = new AuthorizationPOM(driver);
        authorizationPOM.clickRecoverPassword(); // Нажать на кнопку "Восстановить пароль"
        // Зайти на страницу восстановления пароля
        RecoverPasswordPOM recoverPasswordPOM = new RecoverPasswordPOM(driver);
        recoverPasswordPOM.clicklinlIn(); // Нажать на ссылку "Войти".
        // Заполнение полей на форме авторизации.
        authorizationPOM.clickEmail();
        authorizationPOM.writeEmail("Test31072025@mail.ru"); // Заполнить поле email
        authorizationPOM.clickPassword();
        authorizationPOM.writePassword("qwerty"); // Заполнить поле "Пароль".
        authorizationPOM.clickInButton();

        WebElement buttonOrder = driver.findElement(mainPagePOM.getLocatorOrderButton()); // Вернуть локатор кнопки "Оформить заказ".

        assertTrue(buttonOrder.isDisplayed(), "Кнопка должна быть видимой"); // Проверяем, что кнопка отображается
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

}
