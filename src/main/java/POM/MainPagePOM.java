package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPagePOM {

    private WebDriver driver;
    // Кнопка "Войти в аккаунт".
    private By InButton =By.cssSelector(".button_button__33qZ0");
    // Кнопка "Оформить заказ".
    private By order = By.cssSelector(".button_button__33qZ0");
    // Кнопка "Личный кабинет".
    private By personalAccountButton = By.xpath("//*[text()='Личный Кабинет']");
    // Кнопка "Конструктор".
    private By constructorButton = By.xpath("//*[text()='Конструктор']");
    // Логотип бургера
    private By logo = By.cssSelector(".AppHeader_header__logo__2D0X2");

    public MainPagePOM(WebDriver driver){
        this.driver=driver;
    }

    //  Нажать ЛКМ на кнопку "Войти в аккаунт"
    public void clickToInButton(){
        driver.findElement(InButton).click();
    }
    // Вернуть локатор кнопки "Конструктор"
    public By returnInButton(){
        return InButton;
    }
    // Вернуть локатор кнопки "Оформить заказ".
    public By getLocatorOrderButton(){
        return order;
    }
    // Клик ЛКМ по кнопке "Личный Кабинет".
    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }
    // Клик ЛКМ по кнопке "Конструктор".
    public void clickСonstructorButton(){
        driver.findElement(constructorButton).click();
    }
    // Клик ЛКМ по логотипу бургера.
    public void clickToLogo(){
        driver.findElement(logo).click();
    }
    // Вернуть локатор логотипа Бургер
    public By returnLogo(){
        return logo;
    }

}
