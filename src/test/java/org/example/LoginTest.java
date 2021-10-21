package org.example;

import io.qameta.allure.Step;
import org.apache.tika.metadata.PDF;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.files.FileFilters.withExtension;
import static org.apache.commons.io.FileUtils.readFileToString;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class LoginTest
{

    Path path = Paths.get("build\\downloads");
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @Before public void start() {
        open("https://kpfu.ru/");
        $(byXpath("//*[@id=\"top-panel\"]/div[1]/div[1]/a")).click();
        $(byName("p_login")).setValue(ConfProperties.getProperty("login"));
        $(byName("p_pass")).setValue(ConfProperties.getProperty("password"));
        $(byXpath("//*[@id=\"eu_enter\"]/input[3]")).click();

    }
    @Step("Test downloading document")
    @Test
    public void test2 () throws IOException
    {
        // Cкачиваем заявление из вкладки интернет-приемная
        $(byXpath("//*[@id=\"under-slider-menu\"]/div/a[4]")).click();
        $(byXpath("//*[@id=\"under-slider-menu\"]/div/a[8]/span")).click();
        $(byXpath("//*[@id=\"mCSB_1_container\"]/ul/li[1]/a")).click();
        File downloadedFile = $(byXpath("//*[@id=\"tab1\"]/p[2]/a")).download();

        String file = new String(readFileToString(downloadedFile, "Windows-1251").getBytes("Windows-1251"));
        Assert.assertTrue(file.contains("09-951"));
    }
    @Step("Test upload my photo to mine LK")
    @Test
    public void test3 () throws IOException
    {
        // Загружаем свое фото
        $(byXpath("//*[@id=\"under-slider-menu\"]/div/a[2]/i")).click();
        $(byXpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[2]/div[2]")).click();
        $(byXpath("//*[@id=\"answer\"]/a[1]")).click();
        $(byXpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[1]/form/div[1]/input")).uploadFile(new File("foto.jpeg"));
        $(byXpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[1]/form/div[2]/input")).click();
    }
}
