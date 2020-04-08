package ru.lanit.atschool.steps;

import io.cucumber.java.ru.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.lanit.atschool.pages.BasePage;
import ru.lanit.atschool.pages.FirstPage;
import ru.lanit.atschool.pages.MainPage;
import ru.lanit.atschool.webdriver.WebDriverManager;


public class MainPageSteps  {
    MainPage mainPage = new MainPage();
    FirstPage firstPage = new FirstPage(); //создали новый экземпляр класса

    @Пусть("открыт браузер и введен адрес \"(.*)\"$")
    public void openedBrowserAndEnteredUrl(String url) {
        mainPage.openPage(url);
    }

    @Тогда("пользователь переходит в раздел Пользователи")
    public void goToUsers() {
        firstPage.getUsersPage().click(); //используем метод класса

        // String title = driver.getTitle();
        //  Assert.assertEquals(title, "Top posters | Пользователи | Lanit education", "Тест не пройден");
    }

    @Пусть("пользователь переходит в раздел Категории")
    public void goToCategories() {
        firstPage.getCategoriesPage().click();

        // String title = driver.getTitle();
        // Assert.assertEquals(title, "Категории | Lanit education", "Тест не пройден");
    }

    @И("пользователь ищет в системе \"(.*)\"$")
    public void searchUser(String user) {
        firstPage.getSearchPage().click();
        firstPage.getSearchPageButton().sendKeys(user);
        firstPage.getSearchPageAccessButton().click();

        //   firstPage.getSearchPage().click();
        //   driver.findElement(By.xpath("//*[@id='user-menu-mount']//ul/li[1]/input")).click();
        //   driver.findElement(By.xpath("//*[@id='user-menu-mount']//ul/li[3]/a//div[2]/h5")).click();

    }

    @Тогда("тест завершен")
    public void testFinalPage() {
        firstPage.getSearchPageAccessButton();
     //    String title = driver.getTitle();
     //     Assert.assertEquals(title, "Сообщений | Svetlana | Lanit education", "Тест не пройден");

    }


}



