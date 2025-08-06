package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPOM {

    private WebDriver driver;

    // Ссылка "Войти"
    private By linlIn = By.cssSelector(".Auth_link__1fOlj");

    public RecoverPasswordPOM(WebDriver driver){
        this.driver=driver;
    }

    // Клик по ссылке "Войти".
    public void clicklinlIn(){
        driver.findElement(linlIn).click();
    }

}
