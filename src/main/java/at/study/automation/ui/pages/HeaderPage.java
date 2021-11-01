package at.study.automation.ui.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends Page {

    public HeaderPage() {
        super();
    }

    /**
     * метод проверки что элемент отсутствует на странице.
     * @param webElement которого не должно быть на странице поиска
     * @return элемент есть на странице = False. Элемента нет = True
     */
    public Boolean isValidationMsgNotExist(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }

    }
    @FindBy(xpath = "//div[@id='account']//a[@class='login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@id='account']//a[@class='register']")
    public WebElement registerButton;

    @FindBy(xpath = "//div[@id='account']//a[@class='my-account']")
    public WebElement myAccount;

    @FindBy(xpath = "//div[@id='loggedas']")
    public WebElement whoEntered;

    @FindBy(xpath = "//div[@id='top-menu']//a[@class='home']")
    public WebElement homePage;

    @FindBy(xpath = "//div[@id='top-menu']//a[@class='my-page']")
    public WebElement myPage;

    @FindBy(xpath = "//div[@id='top-menu']//a[@class='projects']")
    public WebElement projects;

    @FindBy(xpath = "//div[@id='top-menu']//a[@class='administration']")
    public WebElement administration;

    @FindBy(xpath = "//div[@id='top-menu']//a[@class='help']")
    public WebElement help;

    @FindBy(xpath = "//div[@id='top-menu']//a[@class='logout']")
    public WebElement logout;

    @FindBy(xpath = "//div[@id='quick-search']//input[@id='q']")
    public WebElement search;

    // текстовый элемент "Домашняя страница"
    @FindBy(xpath = "//div[@id='content']/h2")
    public WebElement isHomePage;

}
