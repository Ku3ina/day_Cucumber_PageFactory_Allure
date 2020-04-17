package ru.lanit.atschool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Properties {
    private static Logger log;

    /**
     * Установка параметров из config.properties
     */
    public static void setProperties() {
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
            log = LogManager.getLogger(Properties.class);
            log.info("Выполнено чтение настроек из файла .properties");
        } catch (IOException e) {
            System.setProperty("chrome.driver.path", "src/main/resources/drivers/chromedriver.exe");
            log = LogManager.getLogger(Properties.class);
            log.error("Ошибка чтения настроек из файла .properties");
            log.info("Установлены настройки по умолчанию");
        }
    }
}
