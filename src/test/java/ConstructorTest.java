import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorTest {

    private WebDriver driver;
    private static int counter = 1;

    // Раздел «Конструктор». Проверь, что работают переходы к разделам: Булки.
    @Test
    public void clickBunsTest(){
        driver = RunBrowsers.getWebDriver(Browser.CHROME);
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");

        // Кликаем по вкладке "Начинки"
        // (попробуйте убрать вызов метода click() и посмотреть что произойдет)
        driver.findElement(By.xpath(".//span[text() = 'Начинки']/parent::div")).click();
        driver.findElement(By.xpath(".//span[text() = 'Булки']/parent::div")).click();

        // Будем проверять, что этот элемент (картинка "Флюоресцентная булка R2-D3")
        // находится в видимой области окна браузера.
        WebElement element =
                driver.findElement(By.xpath(".//img[@alt='Флюоресцентная булка R2-D3']"));

        boolean isElementInViewport =
                new WebDriverWait(driver, Duration.ofSeconds(1))
                        .until(
                                dvr -> {
                                    Rectangle rect = element.getRect();
                                    Dimension windowSize = dvr.manage().window().getSize();

                                    System.out.println("Проверка номера: " + counter++);
                                    System.out.println("rect.getX(): " + rect.getX());
                                    System.out.println("rect.getY(): " + rect.getY());
                                    System.out.println("rect.getWidth(): " + rect.getWidth());
                                    System.out.println("rect.getHeight: " + rect.getHeight());
                                    System.out.println("windowsSize.getWidth() " + windowSize.getWidth());
                                    System.out.println("windowsSize.getHeight() " + windowSize.getHeight() + "\n");

                                    // условие, которое проверяет внутри явного ожидания
                                    return rect.getX() >= 0
                                            && rect.getY() >= 0
                                            && rect.getX() + rect.getWidth() <= windowSize.getWidth()
                                            && rect.getY() + rect.getHeight() <= windowSize.getHeight();
                                });

        Assertions.assertTrue(isElementInViewport);
    }

    // Раздел «Конструктор». Проверь, что работают переходы к разделам: Соусы.
    @Test
    public void clickSaucesTest(){
        driver = RunBrowsers.getWebDriver(Browser.CHROME);
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");

        // Кликаем по вкладке "Начинки"
        // (попробуйте убрать вызов метода click() и посмотреть что произойдет)
        driver.findElement(By.xpath(".//span[text() = 'Соусы']/parent::div")).click();

        // Будем проверять, что этот элемент (картинка "Флюоресцентная булка R2-D3")
        // находится в видимой области окна браузера.
        WebElement element =
                driver.findElement(By.xpath(".//img[@alt='Соус Spicy-X']"));

        boolean isElementInViewport =
                new WebDriverWait(driver, Duration.ofSeconds(1))
                        .until(
                                dvr -> {
                                    Rectangle rect = element.getRect();
                                    Dimension windowSize = dvr.manage().window().getSize();

                                    System.out.println("Проверка номера: " + counter++);
                                    System.out.println("rect.getX(): " + rect.getX());
                                    System.out.println("rect.getY(): " + rect.getY());
                                    System.out.println("rect.getWidth(): " + rect.getWidth());
                                    System.out.println("rect.getHeight: " + rect.getHeight());
                                    System.out.println("windowsSize.getWidth() " + windowSize.getWidth());
                                    System.out.println("windowsSize.getHeight() " + windowSize.getHeight() + "\n");

                                    // условие, которое проверяет внутри явного ожидания
                                    return rect.getX() >= 0
                                            && rect.getY() >= 0
                                            && rect.getX() + rect.getWidth() <= windowSize.getWidth()
                                            && rect.getY() + rect.getHeight() <= windowSize.getHeight();
                                });

        Assertions.assertTrue(isElementInViewport);
    }

    // Раздел «Конструктор». Проверь, что работают переходы к разделам: Начинки.
    @Test
    public void clickFillingsTest(){
        driver = RunBrowsers.getWebDriver(Browser.CHROME);
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");

        // Кликаем по вкладке "Начинки"
        // (попробуйте убрать вызов метода click() и посмотреть что произойдет)
        driver.findElement(By.xpath(".//span[text() = 'Начинки']/parent::div")).click();

        // Будем проверять, что этот элемент (картинка "Мясо бессмертных маллюсков Prostostomia")
        // находится в видимой области окна браузера.
        WebElement element =
                driver.findElement(By.xpath(".//img[@alt='Мясо бессмертных моллюсков Protostomia']"));

        boolean isElementInViewport =
                new WebDriverWait(driver, Duration.ofSeconds(1))
                        .until(
                                 dvr -> {
                                    Rectangle rect = element.getRect();
                                    Dimension windowSize = dvr.manage().window().getSize();

                                    System.out.println("Проверка номера: " + counter++);
                                    System.out.println("rect.getX(): " + rect.getX());
                                    System.out.println("rect.getY(): " + rect.getY());
                                    System.out.println("rect.getWidth(): " + rect.getWidth());
                                    System.out.println("rect.getHeight: " + rect.getHeight());
                                    System.out.println("windowsSize.getWidth() " + windowSize.getWidth());
                                    System.out.println("windowsSize.getHeight() " + windowSize.getHeight() + "\n");

                                    // условие, которое проверяет внутри явного ожидания
                                    return rect.getX() >= 0
                                            && rect.getY() >= 0
                                            && rect.getX() + rect.getWidth() <= windowSize.getWidth()
                                            && rect.getY() + rect.getHeight() <= windowSize.getHeight();
                                });

        Assertions.assertTrue(isElementInViewport);
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

}
