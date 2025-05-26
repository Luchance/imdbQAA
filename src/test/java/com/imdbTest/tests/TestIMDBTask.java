package com.imdbTest.tests;

import com.imdbTest.drivermanager.WebdriverManager;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestIMDBTask {

    @BeforeClass
    public void setUp() {
        WebdriverManager.initDriver();
    }

    @Test
    @Description("Sample login test with Selenide and Allure")
    public void loginTest() {
        open("https://google.com");

        $("#email").setValue("user@example.com");
        $("#password").setValue("password123");
        $("#loginButton").click();
        $(".dashboard").should(appear);
    }
}