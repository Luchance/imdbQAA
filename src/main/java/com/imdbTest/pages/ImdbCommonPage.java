package com.imdbTest.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.imdbTest.utility.waiter.WaitUtils.waitUntilElementStopsMoving;

public class ImdbCommonPage {
    private final ElementsCollection navSuggestionItems =
            $$x("//div[@id='react-autowhatever-navSuggestionSearch']//li");
    public final ElementsCollection topCastItems =
            $$x("//section[contains(@data-testid, 'title-cast')]//div[@data-testid='title-cast-item']");

    public SelenideElement searchBar = $(By.id("suggestion-search"));
    public SelenideElement searchBarButton = $(By.id("suggestion-search-button"));
    public SelenideElement pageTitle = $x("//h1[contains(@data-testid, 'hero__pageTitle')]");

    public String getSuggestionByIndex(int index) {
        return navSuggestionItems.get(index - 1)
                .shouldBe(visible)
                .getText()
                .split("\n")[0];
    }

    public void clickOnSuggestionByIndex(int index) {
        navSuggestionItems.get(index - 1)
                .shouldBe(visible)
                .click();
    }

    public String getCastNameByIndex(int index) {
        SelenideElement castItem = topCastItems.get(index - 1);

        castItem.scrollIntoView(true)
                .shouldBe(visible, enabled);

        waitUntilElementStopsMoving(castItem, 3);
        return castItem.getText().split("\n")[0];
    }

    public void clickOnCastByIndex(int index) {
        topCastItems.get(index - 1)
                .$x(".//a")
                .scrollIntoView(true)
                .shouldBe(visible)
                .click();
    }
}