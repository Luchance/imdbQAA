package com.imdbTest.tests;

import com.imdbTest.drivermanager.WebDriverManager;
import com.imdbTest.pages.ImdbCommonPage;
import com.imdbTest.utility.coockeHelper.CookieBanner;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestIMDBTask {

    private ImdbCommonPage imdbMainPage;
    private CookieBanner cookieBanner;

    @BeforeClass
    public void setUp() {
        WebDriverManager.initDriver();
        imdbMainPage = new ImdbCommonPage();
        cookieBanner = new CookieBanner();
    }

    @Test
    @Description("Test case for homework task")
    public void imdbQaTest() {
        openHomePage();
        searchForTerm("qa");
        verifySuggestionTitleMatches(1);
        verifyCastMember(3);

    }

    @Step("Open IMDb home page")
    private void openHomePage() {
        open("https://www.imdb.com/");
        cookieBanner.closeIfVisible();
    }

    @Step("Search for term: {term}")
    private void searchForTerm(String term) {
        imdbMainPage.searchBar.setValue(term);
    }

    @Step("Verify suggestion title at index {index}")
    private void verifySuggestionTitleMatches(int index) {
        String suggestionTitle = imdbMainPage.getSuggestionByIndex(index);
        imdbMainPage.clickOnSuggestionByIndex(index);
        Assert.assertEquals(imdbMainPage.pageTitle.getText(), suggestionTitle);
    }

    @Step("Verify cast member at index {index}")
    private void verifyCastMember(int index) {
        String castMember = imdbMainPage.getCastNameByIndex(index);
        Assert.assertTrue(imdbMainPage.topCastItems.size() > index,
                "Expected more than " + index + " suggestions, but found: " + imdbMainPage.topCastItems.size());
        imdbMainPage.clickOnCastByIndex(index);
        Assert.assertEquals(imdbMainPage.pageTitle.getText(), castMember);
    }
}