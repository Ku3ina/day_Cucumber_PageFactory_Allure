package ru.lanit.atschool.steps;

//import cucumber.api.java.ru.*;
import io.cucumber.java.ru.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.lanit.atschool.pages.MainPage;
import ru.lanit.atschool.webdriver.WebDriverManager;


public class MainPageSteps {
    MainPage mainPage = new MainPage();
    Logger logger = Logger.getLogger(getClass());
    WebDriver driver = WebDriverManager.getDriver();


    @Пусть("открыт браузер и введен адрес \"(.*)\"$")
    public void openedBrowserAndEnteredUrl(String url) {
        mainPage.openPage(url);
    }

    @Тогда("пользователь переходит в раздел Пользователи")
    public void goToUsers() { // page factory
        mainPage.users.click();
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "https://dev.n7lanit.ru/users/active-posters/", "Адрес страницы неверен");
       logger.info("Выполнен переход в раздел \"Пользователи\" ");
    }

    @Пусть("пользователь переходит в раздел Категории")
    public void goToCategories() {
        mainPage.categories.click();
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "https://dev.n7lanit.ru/categories/", "Адрес страницы неверен");
        logger.info("Выполнен переход в раздел \"Категории\" ");
    }

    @И("пользователь ищет в системе \"(.*)\"$")
    public void searchUser(String user) {
        mainPage.searchField.click();
        mainPage.searchBtn1.sendKeys(user);
        mainPage.searchBtn2.click();
        String title = driver.getCurrentUrl();
//        Assert.assertEquals(title, "https://dev.n7lanit.ru/u/svetlana/14/poss/", "Тест не пройден"); // этот тест упадет
        Assert.assertEquals(title, "https://dev.n7lanit.ru/u/svetlana/14/posts/", "Адрес страницы неверен"); // этот выполнится
        logger.info("Выполнен поиск пользователя " + user);

    }

    @Тогда("тест завершен") // добавила закрытие браузера
    public void testFinalPage() {
        WebDriverManager.quit();
        logger.info("Браузер закрыт");

    }

}



