package ru.lanit.atschool.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;
public class MainPage extends BasePage {

    /**
     * Метод открывает браузер на заданной странице
     * страница задается в файле config.properties.
     */
    public void openPage(String url) {
        driver.get(url);
        // logger.info("Выполнен вход на страницу: " + url);
    }

    /**
     * Раздел "Категории".
     */

    @FindBy(xpath = ("/html/body/div[3]/nav//ul/li[2]/a"))
    public WebElement categories;

    /**
     * Раздел "Пользователи".
     */

    @FindBy(xpath = ("//*[@id='misago-container']/nav//ul/li[3]/a"))
    public WebElement users;

    /**
     * Выбор кнопки "Поиск".
     */

    @FindBy(xpath = "//*[@id='user-menu-mount']//a/i")
    public WebElement searchField;

    /**
     * Нажатие на кнопку "Поиск".
     */

    @FindBy(xpath = "//*[@id='user-menu-mount']//ul/li[1]/input")
    public WebElement searchBtn1;

    /**
     * Нажатие на кнопку "Поиск". Да, это не оптимально, проблема в локаторах, я их доизучу
     */

    @FindBy(xpath = "//*[@id='user-menu-mount']//ul/li[3]/a//div[2]/h5")
    public WebElement searchBtn2;


   // @FindBy( = "//*[@id='user-menu-mount']//ul/li[3]/a//div[2]/h5")
   // public WebElement userName;

}

