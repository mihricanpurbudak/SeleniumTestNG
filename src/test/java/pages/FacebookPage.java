
package pages;

        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import utilities.Driver;

public class FacebookPage {

    public FacebookPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[@id='email']")
    public WebElement email;
    @FindBy(xpath = "//*[@id='pass']")
    public WebElement sifre;

    @FindBy(xpath = "//*[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']")
    public WebElement login;
    @FindBy(xpath = "(//*[@value='1'])[3]")
    public WebElement getLogin;

    /*Bu kisim Erol hocanin locate ile hata verdigi icin yeni Locate alinarak asagidaki
    GirisYapilmadi objesi ile testin past olmasi saglandi
     // @FindBy(xpath = "//*[@class='_9ay7']")
    //  public WebElement girisYapilmadi;
     */
    @FindBy(xpath = "//*[@id='reg_pages_msg']")
    public WebElement GirisYapilmadi;

}
