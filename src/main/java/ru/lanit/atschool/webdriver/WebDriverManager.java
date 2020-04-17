/**
 * Класс для работы с вэбдрайвером
 * Автор Васильев И.Н. atcc@mail.ru
 * 02.12.2018
 */
package ru.lanit.atschool.webdriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    public static WebDriver driver;
    protected static final Logger logger = Logger.getLogger(WebDriverManager.class);
    public static WebDriverWait waiter;

    private WebDriverManager() {
    }

    /**
     * @return WebDriver
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            try {
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--window-size=1024,768");
                driver = new ChromeDriver(option);
            } catch (UnreachableBrowserException e) {
                logger.error("Невозможно инциализировать драйвер!", e);
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    /**
     * Закрытие браузера
     */
    public static void quit() {
        if (driver == null) {
            logger.info("Драйвер уже закрыт");
        }
        try {
            driver.quit();
            driver = null;
        } catch (UnreachableBrowserException e) {
            logger.error("Невозможно закрыть браузер!");
        }
    }

    /**
     * @return WebDriverWait
     */
    public static WebDriverWait getWaiter() {
        if (waiter == null) {
            waiter = new WebDriverWait(WebDriverManager.getDriver(), Integer.parseInt(System.getProperty("explicit.wait")));
        }
        return waiter;
    }
}
