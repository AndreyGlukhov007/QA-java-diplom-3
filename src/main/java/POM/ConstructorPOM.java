package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPOM {

    private WebDriver driver;

    // Раздел "Булки".
    private By buns =By.xpath("//*[text()='Булки']");
    // Раздел "Соусы".
    private By sauces =By.xpath("//*[text()='Соусы']");
    // Раздел "Начинки".
    private By fillings =By.xpath("//*[text()='Начинки']");

    public ConstructorPOM(WebDriver driver) {
        this.driver = driver;
    }
    // Клик ЛКМ по разделу "Булки".
    public void clickBuns(){
        driver.findElement(buns).click();
    }
    // Клик ЛКМ по разделу "Соусы".
    public void clickSauces(){
        driver.findElement(sauces).click();
    }
    // Клик ЛКМ по разделу "Начинки".
    public void clickFillings(){
        driver.findElement(fillings).click();
    }
    // Вернуть локатор "Соусы".
    public By returnSauces(){
        return sauces;
    }

}
