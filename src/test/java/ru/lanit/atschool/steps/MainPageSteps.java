package ru.lanit.atschool.steps;

//import cucumber.api.java.ru.*;

import io.cucumber.java.*;
import io.cucumber.java.ru.*;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.lanit.atschool.pages.MainPage;
import ru.lanit.atschool.webdriver.WebDriverManager;

import java.io.ByteArrayInputStream;


public class MainPageSteps {
    MainPage mainPage = new MainPage();
    Logger logger = Logger.getLogger(getClass());
    WebDriver driver = WebDriverManager.getDriver();

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] saveScreenshot(String screenShot) {
        logger.info("Create screenshot, step: " + screenShot + "");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Пусть("открыт браузер и введен адрес \"(.*)\"$")
    public void openedBrowserAndEnteredUrl(String url) {
        mainPage.openPage(url);
    }

    @Тогда("пользователь переходит в раздел \"Пользователи\"")
    public void goToUsers() {
        mainPage.users.click();
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "https://dev.n7lanit.ru/users/active-posters/", "Wrong url for \"Users\"");
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("Users")));
        logger.info("Go to the \"Users\" successfully");
    }

    @Пусть("пользователь переходит в раздел \"Категории\"")
    public void goToCategories() {
        mainPage.categories.click();
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "https://dev.n7lanit.ru/categories/", "Wrong url for \"Categories\"");
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("Categories")));
        logger.info("Go to the \"Categories\" successfully");
    }

    @И("пользователь ищет в системе \"(.*)\"$")
    public void searchUser(String user) {
        mainPage.searchField.click();
        mainPage.searchBtn1.sendKeys(user);
        mainPage.searchBtn2.click();
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "https://dev.n7lanit.ru/u/svetlana/14/posts/", "Wrong url for searching user:  " + user);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("search")));
        logger.info("Success search for user: " + user);
    }


}



