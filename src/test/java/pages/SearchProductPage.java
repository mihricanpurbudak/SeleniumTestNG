package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;
public class SearchProductPage {
    public SearchProductPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//*[text()=' Products']")
    public WebElement prouducts;
    @FindBy (xpath = "//*[text()='All Products']")
    public WebElement allProductTitle;
    @FindBy (xpath = "//input[@id='search_product']")
    public WebElement searchBox;
    @FindBy (xpath = "//button[@id='submit_search']")
    public WebElement searchButton;
    @FindBy (xpath = "(//h2)[3]")
    public WebElement searchedProductTitle;
    @FindBy (linkText = "View Product")
    public WebElement viewProduct;
    @FindBy (xpath = "(//h2)[3]")
    public WebElement blueTop;
    @FindBy (xpath = "//div[@class='product-image-wrapper']")
    public List<WebElement> searchedProductList;

    @FindBy (xpath = "//button[@title='Alle akzeptieren']")
    public List<WebElement> cookiesButton;}

/*
Hanife H.
  4:55 PM
sendKeys("Dress", Keys.TAB,Keys.ENTER)
Fatih Kıraç
  4:56 PM
actions.sendKeys(aEP.searchProduct,"blue top").sendKeys(Keys.TAB,Keys.ENTER).perform();
Zeliha Öznük
  4:58 PM
ReusableMethods.getActions().click(searchProductPage.aramaKutusu).sendKeys("Blue Top")
        .click(searchProductPage.aramaButton).perform();
 //h2[contains(text(),'Searched Products')]
 */