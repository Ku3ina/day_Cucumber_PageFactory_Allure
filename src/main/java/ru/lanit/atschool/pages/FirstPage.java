package ru.lanit.atschool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.lanit.atschool.webdriver.WebDriverManager;

import static org.openqa.selenium.By.xpath;

public class FirstPage { // для использования паттерна page object. Cоздаем класс
    WebDriver driver = WebDriverManager.getDriver();
    public WebElement getUsersPage() {     // и методы в которых содержится поиск страниц, в MainPageSteps вызываем его
        WebElement usersPage = driver.findElement(xpath("//*[@id='misago-container']/nav//ul/li[3]/a"));
        return usersPage;
    }

  public WebElement getCategoriesPage() {
        WebElement categoriesPage = driver.findElement(By.xpath("/html/body/div[3]/nav//ul/li[2]/a"));
        return categoriesPage;
    }


    public WebElement getSearchPage() {
        WebElement searchPage = driver.findElement(xpath("//*[@id='user-menu-mount']//a/i"));
        return searchPage;
    }

    public WebElement getSearchPageButton() {
        WebElement searchButton = driver.findElement(xpath("//*[@id='user-menu-mount']//ul/li[1]/input"));
        return searchButton;
    }

    public WebElement getSearchPageAccessButton() {
        WebElement searchButton2 = driver.findElement(xpath("//*[@id='user-menu-mount']//ul/li[3]/a//div[2]/h5"));
        return searchButton2;
    }


}
