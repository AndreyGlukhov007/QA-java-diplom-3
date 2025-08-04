import POM.AuthorizationPOM;
import POM.MainPagePOM;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertTrue;
// Тестирование регистрации
public class RegistrationTest {

    private WebDriver driver;

    private String emailTest = "test"+getCurrentDateTime()+"@mail.ru";
    private String nameTest = "name" + getCurrentDateTime();

    //Этот метод нужен чтобы создавать уникальных пользователей. К логину и имени добавляется актуальная дата и время (часы, минуты, секунды).
    public String getCurrentDateTime() {
        // Получаем текущие дату и время
        LocalDateTime now = LocalDateTime.now();

        // Форматируем вывод
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");

        // Возвращаем отформатированную строку
        return now.format(formatter);
    }

//    @BeforeEach
//    public void optionsForTests(){
//        /*
//        Я оставил строчки 24 и 25 для того чтобы проверить работу браузера GoogleChrome. Я раскомментирную строчки 24 и 25 и закомментирую строчку 26, и тем самым запущу
//        тесты в GoogleChrome. Возможно есть более изящный способ провести кроссбраузерное тестирование, но я только учусь и о других способах не знаю. Если для прохождения
//        спринта мне нужно будет удалить 24 и 25 строчку я это сделаю.
//         */
//        ChromeOptions options =  new ChromeOptions();
//        driver = new ChromeDriver(options);
//        //driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.get("https://stellarburgers.nomoreparties.site/");
//    }

    // Регистрация пользователя.
    @Test
    public void registrationTest() throws InterruptedException {
        driver = RunBrowsers.getWebDriver(Browser.CHROME);
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");

        MainPagePOM mainPagePOM = new MainPagePOM(driver); // Зайти на главную страницу
        mainPagePOM.clickToInButton(); // Нажать на кнопку "Войти в аккаунт"
        // Попадаем на страницу авторизации
        AuthorizationPOM authorizationPOM = new AuthorizationPOM(driver);
        authorizationPOM.clickButtonRegistration();
        // Попадаем на страницу регистрации
        POM.RegistrationPOM registrationPOM = new POM.RegistrationPOM(driver);
        registrationPOM.clickName();
        String nameTestLocal = nameTest;
        registrationPOM.writeName(nameTestLocal);
        registrationPOM.clickEmail();
        String emailTestLocal = emailTest;
        registrationPOM.writeEmail(emailTestLocal);
        registrationPOM.clickPassword();
        registrationPOM.writePassword("qwerty");
        registrationPOM.clickButtonRegistration();
        // Снова попадаем на страницу авторизации
        Thread.sleep(3000); // После перехода на страницу авторизации элементы не успевают прогрузиться, поэтому я использую sleep. Явное ожидание не помогает, поэтому использую sleep.
        authorizationPOM.clickEmail();
        authorizationPOM.writeEmail(emailTestLocal);
        authorizationPOM.clickPassword();
        authorizationPOM.writePassword("qwerty");
        authorizationPOM.clickInButton();

        WebElement buttonOrder = driver.findElement(mainPagePOM.getLocatorOrderButton()); // Вернуть локатор кнопки "Оформить заказ".

        assertTrue(buttonOrder.isDisplayed(), "Кнопка должна быть видимой"); // Проверяем, что кнопка отображается
    }

    // Регистрация пользователя. Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
    @Test
    public void registrationErrorPasswordTest() {
        driver = RunBrowsers.getWebDriver(Browser.CHROME);
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");

        MainPagePOM mainPagePOM = new MainPagePOM(driver); // Зайти на главную страницу
        mainPagePOM.clickToInButton(); // Нажать на кнопку "Войти в аккаунт"
        // Попадаем на страницу авторизации
        AuthorizationPOM authorizationPOM = new AuthorizationPOM(driver);
        authorizationPOM.clickButtonRegistration();
        // Попадаем на страницу регистрации
        POM.RegistrationPOM registrationPOM = new POM.RegistrationPOM(driver);
        registrationPOM.clickName();
        String nameTestLocal = nameTest;
        registrationPOM.writeName(nameTestLocal);
        registrationPOM.clickEmail();
        String emailTestLocal = emailTest;
        registrationPOM.writeEmail(emailTestLocal);
        registrationPOM.clickPassword();
        registrationPOM.writePassword("qwert");
        registrationPOM.clickButtonRegistration();

        WebElement textError = driver.findElement(registrationPOM.getTextError()); // Вернуть локатор кнопки "Оформить заказ".

        assertTrue(textError.isDisplayed(), "Кнопка должна быть видимой"); // Проверяем, что кнопка отображается
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

}
