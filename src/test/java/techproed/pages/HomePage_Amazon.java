package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class HomePage_Amazon {

    public HomePage_Amazon() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id="nav-search-submit-button")
    public WebElement searchInitiator;

    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    public WebElement searchedText;

    @FindBy(xpath = "//span[@class='icp-nav-link-inner']")
    public WebElement languageDropdown;

    @FindBy(xpath = "//a[@href ='#switch-lang=de_DE']")
    public WebElement languageRadioButton;

    @FindBy(xpath = "(//span[@class='icp-color-base'])[1]")
    public WebElement languageButton;

    @FindBy(id = "nav-link-accountList")
    public WebElement signInTab;

    @FindBy(xpath = "(//*[@class='nav-action-inner'])[1]")
    public WebElement signInButton;

    @FindBy(id= "searchDropdownBox")
    public WebElement dropdownBox;

    @FindBy(xpath = "//*[@id='searchDropdownBox']/option")
    public List<WebElement> dropdownList;

    @FindBy(id="nav-hamburger-menu")
    public WebElement allDropdown;

    @FindBy(linkText = "Anmelden") //For DE ==> Sign In
    public WebElement signInButtonDropdown;

    @FindBy(id="nav-cart-count")
    public WebElement chartCount;

    @FindBy(id="ap_email")
    public WebElement emailBox;

    @FindBy(xpath = "//h4")
    public WebElement alertText;

    @FindBy(id="continue")
    public WebElement continueButton;

    @FindBy(id="createAccountSubmit")
    public WebElement accountCreationButton;

    @FindBy(partialLinkText = "Need")
    public WebElement helpButton;

    @FindBy(partialLinkText = "Forgot")
    public WebElement forgotPasswordText;

    @FindBy(tagName = "h1")
    public WebElement passwordAssistanceText;

    @FindBy(xpath = "//h1")
    public WebElement createAccountText;

}
