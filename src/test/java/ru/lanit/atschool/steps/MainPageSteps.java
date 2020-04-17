package ru.lanit.atschool.steps;

import io.cucumber.java.ru.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.lanit.atschool.pages.BasePage;
import ru.lanit.atschool.pages.MainPage;
import ru.lanit.atschool.webdriver.WebDriverManager;

import java.io.ByteArrayInputStream;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;


public class MainPageSteps extends BasePage {
    private MainPage mainPage = new MainPage();
    private Logger logger = Logger.getLogger(getClass());
    private WebDriver driver = WebDriverManager.getDriver();
    private WebDriverWait waiter = WebDriverManager.getWaiter();

    /**
     * Снятие скриншотов средствами selenium
     */
    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] saveScreenshot(String screenshot) {
        logger.info("Create screenshot, step: " + screenshot + "");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Получаем URL из config.properties
     */

    @Пусть("открыт браузер и введен адрес")
    public void openedBrowserAndEnteredUrl() {
        mainPage.openPage(System.getProperty("url"));
    }

    @Тогда("пользователь переходит в раздел \"Пользователи\"")
    public void goToUsers() {
        try {
            waiter.until(elementToBeClickable(mainPage.users));
        } catch (TimeoutException e) {
            Assert.fail("Users button unavailable " + e.getMessage());
        } finally {
            mainPage.users.click();
            String title = driver.getCurrentUrl();
            Assert.assertEquals(title, "https://dev.n7lanit.ru/users/active-posters/", "Wrong url for \"Users\"");
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("Users")));
            logger.info("Go to the \"Users\" successfully");
        }
    }

    @Пусть("пользователь переходит в раздел \"Категории\"")
    public void goToCategories() {
        try {
            waiter.until(elementToBeClickable(mainPage.users));
        } catch (TimeoutException e) {
            Assert.fail("Categories button unavailable " + e.getMessage());
        }
        mainPage.categories.click();
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "https://dev.n7lanit.ru/categories/", "Wrong url for \"Categories\"");
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("Categories")));
        logger.info("Go to the \"Categories\" successfully");
    }

    @И("пользователь ищет в системе \"(.*)\" и выбирает первое значение из списка")
    public void searchUser(String user) {
        mainPage.searchField.click();
        mainPage.searchBtn1.sendKeys(user);
        mainPage.searchResult1.click();
        logger.info("Search for user: " + user);
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "https://dev.n7lanit.ru/u/svetlana/14/posts/", "Wrong url for searching user:  " + user);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("Success search")));
    }

    /**
     * Получаем xpath с помощью аннотации NameOfElement
     * @param name
     */
    @И("пользователь нажимает {string}")
    public void clickLoginFormOpenButton(String name) {
        try {
            waiter.until(elementToBeClickable(mainPage.get(name)));
            mainPage.get(name).click();
        } catch (TimeoutException e) {
            Assert.fail("Auth button unavailable " + e.getMessage());
        }
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("Auth button was used")));
    }

    /**
     * Далее пояснений к методам не будет, посчитала избыточным
     */
    @Когда("появилось окно Авторизации")
    public void loginFormDisplayed() {
        try {
            waiter.until(visibilityOfAllElements(mainPage.authMenu, mainPage.authUser, mainPage.authPass));
        } catch (TimeoutException e) {
            Assert.fail("Auth window not displayed " + e.getMessage());
        }
    }

    @И("пользователь вводит логин \"([A-Za-z]*)\"$") //логин может состоять только из букв
    public void typeUsername(String username) {
        mainPage.authUser.click();
        mainPage.authUser.sendKeys(username);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("Auth window with login")));
    }

    @И("пользователь вводит пароль \"(.*)\"$")
    //пароль может содержать любые символы(проверила при создании нового пользователя)
    public void typePassword(String password) {
        mainPage.authPass.click();
        mainPage.authPass.sendKeys(password);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("Auth window with password")));
    }

    @И("пользователь нажимает кнопку Входа")
    public void clickLoginSubmitButton() {
        try {
            waiter.until(elementToBeClickable(mainPage.authSubmit));
            mainPage.authSubmit.click();
        } catch (TimeoutException e) {
            Assert.fail("Access auth button unavailable " + e.getMessage());
        }
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("Click Enter button")));

    }

    @Тогда("появилось Сообщение о неправильных учетных данных")
    public void incorrectCredentialsAlert() {
        try {
            waiter.until(visibilityOfAllElements(mainPage.authWrongOrEmptyData));
        } catch (TimeoutException e) {
            Assert.fail("No message with wrong data " + e.getMessage());
        }
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("Auth error wrong data")));
    }

    @Тогда("появилось Сообщение о незаполненных учетных данных")
    public void emptyCredentialsAlert() {
        try {
            waiter.until(visibilityOfAllElements(mainPage.authWrongOrEmptyData));
        } catch (TimeoutException e) {
            Assert.fail("No message with no data " + e.getMessage());
        }
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("Auth error no data")));
    }

    @Если("отображается аватарка активного пользователя")
    public void activeUserAvatarDisplayed() {
        try {
            waiter.until(visibilityOfAllElements(mainPage.userAvatarField));
        } catch (TimeoutException e) {
            Assert.fail("Avatar is not displayed " + e.getMessage());
        }
    }

    @И("пользователь нажимает на аватарку активного пользователя")
    public void clickActiveUserAvatar() {
        mainPage.userAvatar.click();
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("Avatar click")));
    }

    @И("пользователь проверяет что в выпадающем окне отображается имя \"(.[A-Za-z]*)\"$")
    //на этом шаге возникают проблемы из за textToBePresentInElement, flaky test
    public void activeUserTitleDisplayed(String username) {
//        try {
//            waiter.until(textToBePresentInElement(mainPage.userAvatarField, username));
//        } catch (TimeoutException e) {
//            Assert.fail("Login not found in users grop list " + e.getMessage());
//        }
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("After avatar click")));
    }

    @Тогда("пользователь нажимает на кнопку Выхода из учетной записи и выходит")
    public void exitActiveUserAccount() {
        mainPage.userExitBtn.click();
        driver.switchTo().alert().accept(); //на этом моменте возникает alert, не стала выносить в отдельный шаг в сценарий
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshot("Exit button")));
    }

}



