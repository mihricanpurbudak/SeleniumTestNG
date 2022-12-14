package tests.day23;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
public class C01_DataProvider {



    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"Java"},{"selenium"},{"samsung"},{"iphone"}};
    }



    @Test(dataProvider="aranacakKelimeler")
    public void test02(String kelimeler) {
        AmazonPage amazonPage = new AmazonPage();
        //amazona gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        //java, selenium, samsung ve iphone icin arama yapalim
        amazonPage.aramaKutusu.sendKeys(kelimeler, Keys.ENTER);
        //sonuclarin aradigimiz kelime icerdigini test edelim

        String actualKelime = amazonPage.aramaSonucWE.getText();
        Assert.assertTrue(actualKelime.contains(kelimeler));
        //sayfayi kapatalim
      //  Driver.closeDriver();
      //  Driver.quitDriver();
    }

    @Test(dependsOnMethods = "test02")
    public void test03() {

        Driver.getDriver();
    }
}
/*
Amazonda fake amazona takilmamak icin
try {
    amazonPage.searchBox.sendKeys(kelime, Keys.ENTER);
} catch (Exception e) {
    Driver.getDriver().navigate().refresh();
}
 */