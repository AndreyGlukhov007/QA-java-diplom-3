import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunBrowsers {

    public static WebDriver getWebDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "driver/chrome/chromedriver.exe");
                return new ChromeDriver();
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "driver/yandex/yandexdriver.exe");
                return new ChromeDriver();
            default:
                return new ChromeDriver();
        }
    }
}
