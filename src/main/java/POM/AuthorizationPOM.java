package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthorizationPOM {

    private WebDriver driver;

    // Поле "email".
    private By email = By.cssSelector("[name='name']");
    // Поле "Пароль".
    private By password = By.cssSelector("[name='Пароль']");
    // Кнопка "Войти".
    public By InButton = By.xpath("//*[text()='Войти']");
    // Кнопка "Зарегистрироваться".
    private By registration = By.xpath("//*[text()='Зарегистрироваться']");
    // Ссылка "Востановить пароль".
    private By recoverPassword= By.xpath("//*[text()='Восстановить пароль']");

    public AuthorizationPOM(WebDriver driver){
        this.driver=driver;
    }
    // Клик ЛКМ оп полю email.
    public void clickEmail(){
        driver.findElement(email).click();
    }
    // Вписать email в поле email
    public void writeEmail(String writeEmail){
        driver.findElement(email).sendKeys(writeEmail);
    }
    // Вернуть локатор email.
    public By getEmail(){
        return email;
    }
    // Клик ЛКМ оп полю email.
    public void clickPassword(){
        driver.findElement(password).click();
    }
    // Вписать email в поле email
    public void writePassword(String writePassword){
        driver.findElement(password).sendKeys(writePassword);
    }
    // Вернуть локатор Пароль.
    public By getPassword(){
        return password;
    }
    // Клик ЛКМ по кнопке "Войти".
    public void clickInButton(){
        driver.findElement(InButton).click();
    }
    // Клик ЛКМ по кнопке "Зарегистрироваться".
    public void clickButtonRegistration(){
        driver.findElement(registration).click();
    }
    // Клик ЛКМ по кнопке "Восстановить пароль".
    public void clickRecoverPassword(){
        driver.findElement(recoverPassword).click();
    }

}
