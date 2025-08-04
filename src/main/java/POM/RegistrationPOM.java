package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPOM {

    private WebDriver driver;

    // Поле "Имя".
    private By name = By.cssSelector("[name='name']");
    // Поле "email".
    private By email = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    // Поле "Пароль".
    private By password = By.cssSelector("[name='Пароль']");
    // Кнопка "Зарегистрироваться"
    private By registrationButton = By.cssSelector(".button_button__33qZ0");
    // Текст ошибки при вводе пароль ДО 6-ти символов
    private By textError = By.cssSelector(".input__error");
    // Ссылка "Войти"
    private By linlIn = By.cssSelector(".Auth_link__1fOlj");

    public RegistrationPOM(WebDriver driver){
        this.driver=driver;
    }

    // Клик ЛКМ оп полю Имя.
    public void clickName(){
        driver.findElement(name).click();
    }
    // Вписать имя в поле Имя.
    public void writeName(String writeName){
        driver.findElement(name).sendKeys(writeName);
    }

    // Клик ЛКМ оп полю email.
    public void clickEmail(){
        driver.findElement(email).click();
    }
    // Вписать email в поле email
    public void writeEmail(String writeEmail){
        driver.findElement(email).sendKeys(writeEmail);
    }

    // Клик ЛКМ оп полю email.
    public void clickPassword(){
        driver.findElement(password).click();
    }
    // Вписать email в поле email
    public void writePassword(String writePassword){
        driver.findElement(password).sendKeys(writePassword);
    }
    // Клик по кнопке "Зарегистрироваться".
    public void clickButtonRegistration(){
        driver.findElement(registrationButton).click();
    }
    // Вернуть текст ошибки.
    public By getTextError(){
        return textError;
    }
    // Клик по ссылке "Войти".
    public void clicklinlIn(){
        driver.findElement(linlIn).click();
    }

}
