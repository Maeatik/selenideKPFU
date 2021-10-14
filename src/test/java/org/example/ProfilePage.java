package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage
{
   //конструктор класса, занимающийся инициализацией полей класса

    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    //определение локатора кнопки выхода из аккаунта

    @FindBy(xpath = "//*[@id=\"page\"]/header/a[1]")
    private WebElement logoutBtn;
    // метод для нажатия кнопки выхода из аккаунта

    @Step("Выйти из аккаунта")
    public void userLogout() {
        logoutBtn.click(); }

    @FindBy(xpath = "//*[@id=\"progress-analyst-all\"]/table/tbody/tr[1]/td[3]")
    private WebElement testInfo1;

    @FindBy(xpath = "//*[@id=\"info\"]/div/div[1]/div[2]/div[7]/span[2]")
    private WebElement testInfo2;

    @Step("Получить информацию для теста1")
    public String getTestInfo1() {
        String TestInfo1 = testInfo1.getText();
        return TestInfo1;
    }
    @Step("Получить информацию для теста2")
    public String getTestInfo2() {
        String TestInfo2 = testInfo2.getText();
        return TestInfo2;
    }
}
