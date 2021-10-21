package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    public WebDriver driver;
    public LoginPage(WebElement loginField, WebElement loginBtn, WebElement passwordField,WebElement inputBtn, WebElement uspBtn, WebElement aboutMeBtn)
    {
        this.loginField = loginField;
        this.loginBtn = loginBtn;
        this.passwordField = passwordField;
        this.inputBtn = inputBtn;
        this.uspBtn = uspBtn;
        this.aboutMeBtn = aboutMeBtn;
    }

    @FindBy(xpath = "//*[@id=\"eu_enter\"]/input[1]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"eu_enter\"]/input[3]")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"top-panel\"]/div[1]/div[1]/a")
    private WebElement inputBtn;

    @FindBy(xpath = "//*[@id=\"eu_enter\"]/input[2]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"main-blocks\"]/div[1]/div[6]")
    private WebElement uspBtn;

    @FindBy(xpath = "//*[@id=\"under-slider-menu\"]/div/a[2]")
    private WebElement aboutMeBtn;



    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Login input")
    public void inputLogin(String login) {
        loginField.sendKeys(login); }

    @Step("Password input")
    public void inputPassword(String password) {
        passwordField.sendKeys(password); }

    @Step("login button press")
    public void clickLoginBtn() {
        loginBtn.click();
    }

    @Step("input button press")
    public void clickInputBtn() {
        inputBtn.click();
    }
    @Step("usp button click")
    public void clickUspBtn() {
        uspBtn.click();
    }
    @Step("about me button click")
    public void clickAboutMeBtn() {
        aboutMeBtn.click();
    }



}
