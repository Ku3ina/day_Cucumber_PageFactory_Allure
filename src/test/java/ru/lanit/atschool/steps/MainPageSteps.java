package ru.lanit.atschool.steps;

import io.cucumber.java.ru.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.lanit.atschool.pages.BasePage;
import ru.lanit.atschool.pages.FirstPage;
import ru.lanit.atschool.pages.MainPage;
import ru.lanit.atschool.webdriver.WebDriverManager;


public class MainPageSteps {
    MainPage mainPage = new MainPage();

    @Пусть("открыт браузер и введен адрес \"(.*)\"$")
    public void openedBrowserAndEnteredUrl(String url) {
        mainPage.openPage(url);
    }

    @Тогда("пользователь переходит в раздел Пользователи")
    public void goToUsers() {
        mainPage.users.click();
    }

    @Пусть("пользователь переходит в раздел Категории")
    public void goToCategories() {
        mainPage.categories.click();
    }

    @И("пользователь ищет в системе \"(.*)\"$")
    public void searchUser(String user) {
        mainPage.searchField.click();
        mainPage.searchBtn1.sendKeys(user);
        mainPage.searchBtn2.click();
        WebDriver driver = WebDriverManager.getDriver();
        String title = driver.getCurrentUrl();
        //  Assert.assertEquals(title, "https://dev.n7lanit.ru/u/svetlana/14/poss/", "Тест не пройден"); // этот тест упадет
        Assert.assertEquals(title, "https://dev.n7lanit.ru/u/svetlana/14/posts/", "Адрес страницы неверен"); // этот выполнится

    }

    @Тогда("тест завершен") // надо было бы убрать, но я оставила
    public void testFinalPage() {

    }

}



