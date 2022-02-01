package techproed.tests.smoketest;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage_Amazon;
import techproed.utilities.ConfigurationReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

public class HomePage_AmazonTest {

    HomePage_Amazon homePage=new HomePage_Amazon();

    @Test
    public void homePageTest(){

        Driver.getDriver().get(ConfigurationReader.getProperty("amazon_url"));

        homePage.searchBox.sendKeys("iphone");
        homePage.searchInitiator.click();
        String searchedTex= homePage.searchedText.getText();
        searchedTex = searchedTex.replaceAll("[^A-Za-z]","");
        Assert.assertEquals(searchedTex, "iphone");

        ReusableMethods.hover(homePage.languageDropdown);
        homePage.languageRadioButton.click();
        JSUtils.scrollDownByJS();
        ReusableMethods.waitFor(2);
        String languageCheck = homePage.languageButton.getText();
        Assert.assertEquals(languageCheck,"Deutsch");

        ReusableMethods.hover(homePage.signInTab);
        Assert.assertTrue(homePage.signInButton.isDisplayed());

        homePage.dropdownBox.click();
        int dropdownList = homePage.dropdownList.size();
        Assert.assertEquals(dropdownList, 28);

        homePage.allDropdown.click();
        Assert.assertTrue(homePage.signInButtonDropdown.isDisplayed());

        String chart = homePage.chartCount.getText().toString();
        Assert.assertEquals(chart, "0");

        Driver.closeDriver();
    }

    @Test
    public void setSignInPage(){

        Driver.getDriver().get(ConfigurationReader.getProperty("amazon_url"));

        homePage.signInTab.click();
        homePage.emailBox.sendKeys(Faker.instance().internet().emailAddress());
        homePage.continueButton.click();
        String alertText= homePage.alertText.getText();
        Assert.assertEquals(alertText,"There was a problem");

        homePage.helpButton.click();
        homePage.forgotPasswordText.click();

        String assistanceText= homePage.passwordAssistanceText.getText();
        Assert.assertEquals(assistanceText,"Password assistance");

        Driver.getDriver().navigate().back();

        Driver.getDriver().navigate().back();

        homePage.accountCreationButton.click();

        String createAccountText= homePage.createAccountText.getText();
        Assert.assertEquals(createAccountText,"Create account");

//        Close Driver
        Driver.closeDriver();
    }

}