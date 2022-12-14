package tests.day22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {
    /*
    -https://www.bluerentalcars.com/ adresine git
    -login butonuna bas
    -test data user email: customer@bluerentalcars.com ,
    -test data password : 12345 dataları girip login e basın
    -login butonuna tiklayin
    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Test","Geçerli kullanıcı adı ve password ile giriş yapıldı");
        //-https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Blue RentaCar sitesine gidildi");
        //-login butonuna bas
        BrcPage brc = new BrcPage();
        brc.brclogin.click();
        extentTest.info("login butonuna basıldı");
        //-test data user email: customer@bluerentalcars.com ,
        //-test data password : 12345 dataları girip login e basın
        //-login butonuna tiklayin
        brc.userEmail.sendKeys(ConfigReader.getProperty("userEmail"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pass"))
                .sendKeys(Keys.ENTER).perform();
        extentTest.info("Doğru kullanıcı email ve password girildi");
        extentTest.info("Ikinci login butonuna basıldı");
        //-Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName = brc.basariliGiris.getText();
        String expectedUserName = "John Walker";
        Assert.assertEquals(expectedUserName,actualUserName);
        extentTest.pass("Sayfaya basarili sekilde girildi");
    }
}
/*
//    -https://www.bluerentalcars.com/ adresine git
Driver.getDriver().get(ConfigReader.getProperty("bluerentacarUrl"));
//    -login butonuna bas
BlueCar blueCar= new BlueCar();
blueCar.login.click();

//    -test data user email: customer@bluerentalcars.com ,
blueCar.email.sendKeys(ConfigReader.getProperty("useremail"));

//    -test data password : 12345 dataları girip login e basın
blueCar.password.sendKeys(ConfigReader.getProperty("datapassword"));
//    -login butonuna tiklayin
blueCar.passwordlogin.click();
//    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
assert blueCar.basariliGiris.isDisplayed();
 */
/*
Hatanin resmini RAPORDA görmek istersek  target altinda Rapor icinde yazdirilan resmin uzernie sag tiklayin --->
Open in --> uzerine gelin -->  Explorer tiklayin bilgisayardaki dosyaninzin icine yönleneceksiniz
oradan raporu cift tiklayin acilan yeni sayfada alta kucuk resim var uzerini tiklayin
ve karsimiza resim cikmis olacak .

 */