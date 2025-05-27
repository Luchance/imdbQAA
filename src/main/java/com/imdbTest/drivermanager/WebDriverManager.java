package com.imdbTest.drivermanager;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebDriverManager {

    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;
        open(); // opens blank page, initializes driver
        getWebDriver().manage().window().maximize();
    }
}