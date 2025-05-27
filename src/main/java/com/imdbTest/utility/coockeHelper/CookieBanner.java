package com.imdbTest.utility.coockeHelper;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$x;

public class CookieBanner {
    private final SelenideElement declineButton = $x("//button[contains(text(), 'Decline')]");

    public void closeIfVisible() {
        try {
            // Wait up to 5 seconds for the Decline button to become visible
            if (declineButton.shouldBe(appear, Duration.ofSeconds(5)).isDisplayed()) {
                declineButton.click();
                System.out.println("Cookie banner closed.");
            }
        } catch (ElementNotFound e) {
            System.out.println("Cookie banner not found — skipping.");
        } catch (Exception e) {
            System.out.println("Unexpected error while handling cookie banner: " + e.getMessage());
        }
    }
}