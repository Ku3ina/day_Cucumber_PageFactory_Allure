package ru.lanit.atschool.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.lanit.atschool.Intefaces.NameOfElement;

public class MainPage extends BasePage {

    @FindBy(xpath = ("/html/body/div[3]/nav//ul/li[2]/a"))
    public WebElement categories;

    @FindBy(xpath = ("//*[@id='misago-container']/nav//ul/li[3]/a"))
    public WebElement users;

    @FindBy(xpath = "//*[@id='user-menu-mount']//a/i")
    public WebElement searchField;

    @FindBy(xpath = "//*[@id='user-menu-mount']//ul/li[1]/input")
    public WebElement searchBtn1;

    @FindBy(xpath = "//*[@id='user-menu-mount']//ul/li[3]/a//div[2]")
    public WebElement searchResult1;

    @FindBy(xpath = "//*[@id='user-menu-mount']//button[1]")
    public WebElement authMenu;

    @FindBy(xpath = "//input[@id='id_username']")
    public WebElement authUser;

    @FindBy(xpath = "//input[@id='id_password']")
    public WebElement authPass;

    @FindBy(xpath = "//*[@id='modal-mount']//form/div[2]/button")
    public WebElement authSubmit;

    @FindBy(xpath = "//*[@id='snackbar-mount']//p")
    public WebElement authWrongOrEmptyData;

    @FindBy(xpath = "//*[@id='user-menu-mount']/ul/li[3]/a")
    public WebElement userAvatar;

    @FindBy(xpath = "//*[@id='page-mount']//div[1]//div[1]//h1")
    public WebElement userAvatarField;

    @FindBy(xpath = "//*[@id='user-menu-mount']/ul/li[3]/ul/li[8]/button")
    public WebElement userExitBtn;

    @NameOfElement("кнопка_авторизации")
    @FindBy(xpath = "//*[@id='user-menu-mount']//button[1]")
    public WebElement authBtn;

}


