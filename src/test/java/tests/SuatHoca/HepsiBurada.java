package tests.SuatHoca;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;


public class HepsiBurada {


        //Hepsiburada sayfasına gidiniz

    //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
//Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
//Sayfayı kapatalım
    WebDriver driver= Driver.getDriver();
    @AfterClass
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test() throws IOException {
        driver.get("https://www.hepsiburada.com/");
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("hepsiburada"));
        ReusableMethods.waitFor(2);
        // driver.findElement(By.xpath("//li[contains(span,'Elektronik')]")).click();



////label[starts-with(@id,’message’)  //a[starts-with(@class,'sf-ChildMenuItems')]

        String sayfaAdi;
        String dinamikpath;
        for (int i = 1; i <66 ; i++) {
            ReusableMethods.hover(driver.findElement(By.xpath("//li[contains(span,'Elektronik')]")));
            ReusableMethods.waitFor(2);
            ReusableMethods.hover(driver.findElement(By.xpath("//li[contains(a,'Bilgisayar/Tablet')]")));
            dinamikpath="(//a[starts-with(@class,'sf-ChildMenuItems-KdzkrxSVhcwDy3od0Yre item')]//following::span)["+i+"]";
            WebElement sayfa= driver.findElement(By.xpath(dinamikpath));
            sayfaAdi=sayfa.getText();
          //  sayfa.click();
          //  ReusableMethods.waitFor(2);
           // ReusableMethods.getScreenshot(sayfaAdi);
         //   driver.navigate().back();
          //  ReusableMethods.waitFor(3);

        }

    }

}
/*
package us8Akin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01 {

    @Test
    public void test01() throws InterruptedException {

        SpendingGoodPage spengood = new SpendingGoodPage();
        Actions actions = new Actions(Driver.getDriver());

        //   1- Vendor http://spendinggood.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));

        //   2- Vendor acilan pencereden sign in simgesine tiklar
        spengood.signIn.click();

        //   3- Vendor username or email address alanina gecerli bir kullanici adi veya email girer
        spengood.userName.sendKeys(ConfigReader.getProperty("user"), Keys.ENTER);

        //   4- Vendor password alanina gecerli bir sifre girer
        //   5- Vendor 'Sign in' butonuna tiklar
        spengood.password.sendKeys(ConfigReader.getProperty("pass"), Keys.ENTER);

        Thread.sleep(3000);

        //   6- Vendor acilan sayfada 'My Account' simgesine tiklar
        spengood.myAccount.click();

        //   7- Vendor "Store Manager" baslikli simgeyi tiklar
        spengood.storeManager.click();

        //   8- Vendor acilan yeni sayfada 'Products' basligini tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spengood.products.click();

        //   9- Vendor bir urunun uzerine tiklar


        //   10- Vendor acilan pencerede 'Manage Stock' kutucugu isaretler
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spengood.manageStock.click();

        //   11- Vendor 'Stock Qty' alanina urun miktari girer
        spengood.stockQty.sendKeys(ConfigReader.getProperty("miktar"));

       // Driver.closeDriver();



    }
}
ackage us8Akin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02 {


    @Test
    public void test01() throws InterruptedException {

        SpendingGoodPage spengood = new SpendingGoodPage();
        Actions actions = new Actions(Driver.getDriver());

        //   1- Vendor http://spendinggood.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));

        //   2- Vendor acilan pencereden sign in simgesine tiklar
        spengood.signIn.click();

        //   3- Vendor username or email address alanina gecerli bir kullanici adi veya email girer
        spengood.userName.sendKeys(ConfigReader.getProperty("user"), Keys.ENTER);

        //   4- Vendor password alanina gecerli bir sifre girer
        //   5- Vendor 'Sign in' butonuna tiklar
        spengood.password.sendKeys(ConfigReader.getProperty("pass"), Keys.ENTER);

        Thread.sleep(3000);

        //   6- Vendor acilan sayfada 'My Account' simgesine tiklar
        spengood.myAccount.click();

        //   7- Vendor "Store Manager" baslikli simgeyi tiklar
        spengood.storeManager.click();

        //   8- Vendor acilan yeni sayfada 'Products' basligini tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spengood.products.click();

        //   9- Vendor 'Add New' sekmesine tiklar
        spengood.addNew.click();

        //   10- Vendor acilan pencerede 'Manage Stock' kutucugu isaretler
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spengood.manageStock.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);

        //   11- Vendor "Allow Backorders" alanina tiklar
        spengood.backOrders.click();

        //   12- Vendor "Do not Allow" opsiyonunu secer
        WebElement allw = Driver.getDriver().findElement(By.xpath("//*[@id='backorders']"));
        Select select = new Select(allw);
        select.selectByIndex(0);

        //   13- Vendor "Allow, but notify customer" opsiyonunu secer
        select.selectByIndex(1);

        //   14- Vendor "Allow" opsiyonunu secer
        select.selectByIndex(2);

        Driver.closeDriver();


    }
}
package us8Akin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03 {

    @Test
    public void test01() throws InterruptedException {

        SpendingGoodPage spengood = new SpendingGoodPage();
        Actions actions = new Actions(Driver.getDriver());

        //   1- Vendor http://spendinggood.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));

        //   2- Vendor acilan pencereden sign in simgesine tiklar
        spengood.signIn.click();

        //   3- Vendor username or email address alanina gecerli bir kullanici adi veya email girer
        spengood.userName.sendKeys(ConfigReader.getProperty("user"), Keys.ENTER);

        //   4- Vendor password alanina gecerli bir sifre girer
        //   5- Vendor 'Sign in' butonuna tiklar
        spengood.password.sendKeys(ConfigReader.getProperty("pass"), Keys.ENTER);

        Thread.sleep(3000);

        //   6- Vendor acilan sayfada 'My Account' simgesine tiklar
        spengood.myAccount.click();

        //   7- Vendor "Store Manager" baslikli simgeyi tiklar
        spengood.storeManager.click();

        //   8- Vendor acilan yeni sayfada 'Products' basligini tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spengood.products.click();

        //   9- Vendor 'Add New' simgesine tiklar
        spengood.addNew.click();

        //    10- Vendor 'Shipping' simgesine tiklar
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        spengood.shipping.click();

        //    11- Vendor 'Weight' alanina paketin agirligini kilogram cinsinden  girer
        spengood.weight.sendKeys(ConfigReader.getProperty("agirlik"));

        //    12- Vendor 'Dimensions' alanina sirasiyla uzunluk,genislik ve yukseklik  degerlerini cm cisinden girer
        actions.sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("uzunluk")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("genislik")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("yukseklik")).perform();

        Driver.closeDriver();

    }
}
ackage us8Akin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04 {

    @Test
    public void test01() throws InterruptedException {

        SpendingGoodPage spengood = new SpendingGoodPage();
        Actions actions = new Actions(Driver.getDriver());

        //   1- Vendor http://spendinggood.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));

        //   2- Vendor acilan pencereden sign in simgesine tiklar
        spengood.signIn.click();

        //   3- Vendor username or email address alanina gecerli bir kullanici adi veya email girer
        spengood.userName.sendKeys(ConfigReader.getProperty("user"), Keys.ENTER);

        //   4- Vendor password alanina gecerli bir sifre girer
        //   5- Vendor 'Sign in' butonuna tiklar
        spengood.password.sendKeys(ConfigReader.getProperty("pass"), Keys.ENTER);

        Thread.sleep(3000);

        //   6- Vendor acilan sayfada 'My Account' simgesine tiklar
        spengood.myAccount.click();

        //   7- Vendor "Store Manager" baslikli simgeyi tiklar
        spengood.storeManager.click();

        //   8- Vendor acilan yeni sayfada 'Products' basligini tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spengood.products.click();

        //   9- Vendor 'Add New' simgesine tiklar
        spengood.addNew.click();

        //    10- Vendor 'Shipping' simgesine tiklar
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        spengood.shipping.click();

        //    11- Vendor 'Processing Time' sekmesine tiklar  ve urunu teslimat yapacagi sureyi secer
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);

        spengood.processingTime.click();
        WebElement time = Driver.getDriver().findElement(By.xpath("//*[@id='_wcfmmp_processing_time']"));
        Select select = new Select(time);
        select.selectByIndex(4);

        //    12- Vendor urun hacmini belirler
        String actualText = spengood.shippingClass.getText();
        String expectedText = "Volume";
        Assert.assertNotEquals(expectedText,actualText);

        Driver.closeDriver();

    }
}
package us8Akin;

public class Z01 {

    /*-------Komutlar
    git --version
    git config --       global user.email "email_adresiniz"
    git config --       global user.name "isminiz"
    git config --       global -l
    git init
    git status
    git add .
    git status
    git restore [dosya]--          tek bir dosyayi iptal eder
    git restore . --               tum dosyalari iptal eder
    git restore --stage  [dosya] --      stage deki tek bir dosyayi iptal eder
    git restore --stage .  --            stage deki  --tum dosyalari iptal eder
    git reset --hard hashcode ---    work degisikleri iptal eder , stage i bosaltir
    git diff -->              Working space deki değişikliği gösterir
    git diff --staged -->     Staging Area daki değ işiklikleri gösterir
    git commit -m "first commit"
    git show "hashcode" -->    Versiyondaki değişiklikleri gösterir
    git log    -->    uzunca hashcode lari veriyor
    git log --oneline -->
    git checkout hashcode .  --> bizi bu versiyona goturur
    git branch --> mevcut branch i gosterir
    git branch brnchismi --> yeni branch olusturur
    git checkout branchismi --> o branche gecer
    git merge branchismi --> iki branchi birlestirir
    git remote add origin https://github.com/techproed2020/Git_...
    git push -u origin main
    git branch -d branchisim --> branch i siler



         GIT teki kisim:
    1) git --version --> biligisayarimizdaki git uygulamanin olup olmadigini
     ve kacinci version yuklu oldugunu ogreniyoruz

    2) localimizdeki version kontrol sistemini remuve dakiyle iliskilendirmek
      icin asagdaki komutlari kullaniyoruz:
        - git config --global user.name "Isim Soyisim"     kullanicinin github'taki kullanici adi
        - git config --global user.email "kullanicinin github taki email adresi"
        - git config --global color.ui true --->   reklendirme icin kullaniyoruz opsiyoneldir.
        Not: git config --system ... paremetrelerini kullanidigimizda
        tum kullanicilar ve tum raporlar uzerinde etkili olur. Ama bu cok tevsiye edilmez
        daha cok Tim lead bu paremetreleri kullanir.
        git config --local  ...--->   paremetresi ise sadece gecerli repo uzerinde etkili olur.

     3)Repository(Depo) : Version kontrol ve birlikte calisma altyapisini ayri tutmak
        istedigimiz her bir bagimsiz yapiya REPOSITORY denir.
        Genellikle her bir proje icin ayri bir repository tanimlanir

     4) git init --->   Local bilgisayarimizda bir projeyi version sistemine alabilmek
      icin git init komutu kullanilir. bu komut kullanilinca proje klasorunde   .git
      klasoru olusturulur. Bu, local repomuzu saklayacaktir.
       Local repo olusturmak icin yani .git ile klasorumuzun icindeki dosyalari iliskilendirmek icin kullanilir

     5) git add .  --> Working space'den (yani yerel) dosyalarimi staging area'ya
              (yani commitlemek icin beklenen yer) gonderilir.
     6) git status --> Working space'deki ve staging area 'daki durumu gosterir

     7) git commit -m"mesaj" ---> staging area dan commt storra dosyalarimi gondermek icin kullanilir
               ( commit yani versiyon yani surum olusturmus olurum)

     8) git push ---> Lokalimizde olusturulan commitleri uzak repo'ya(yani remote - GitHub) gondermek icin kullandigimiz kod
               Yalniz git push  komutunu direk kullanmak istersek 1 kez
                          git remote add origin adress(github)taki email adresimiz-
                          git pus -u origin master   (bizim brancimizin adi)
                 Not: Yukardaki  iki komutu ilk sefer icin kullanilir daha sonra ikinci commit'ler icin sadece
                 git push kullaniriz

     9)  git log --oneline ---> Commitlerimdeki yani versiyonlarimdaki durumu gosterir
                        bieze versionlarimizin hash kodlarimizin ilk 7 karekterini veriyor.

     10)  git branch isim ===> yeni bir branch( dal ) olusturmus oluyoruz. Sebebi Projenin ana yapisana dokunmadan
                 proje uzerinde calismak icin olusturulur.
                 git branch ===> branch listesini bize verir.
                 git checkout isim ===> hangi branch'e gecmek istiysak o branchen ismini yaziyoruz
                 git status ===> branchlerde herhangi bir degisiklik olup olmadigini bize gosterir.

     11) git merge branch ismi===> hangi brench'te isek ve onu diger brench ile esitlemek istiyorsa bu komutu kullaniyoruz

     12) git stash ===> Working spacede ve stating area daki degisiklikleri gecici olarak hafizaya alir ve bolgeleri temizler

     13) git stash pop ===> Hafizaya alinan degisiklikleri geri getirmek icin kullanilir.

     14) git clone  + github daki repository adresi === > Githubdaki (remuve) daki bir repoyu lokale indirmek icinkullanilir

     15) .gitignore ====> remote gondermek istemedigimiz klasorleri gizlemek icin
            -  .idea
            -  *.iml  ===> .iml olan herseyi gizle diyoruz
            -  file==> save all deyip cikis yapiyoruz

     16) conflict ===> cod cakismalarina denir. Farkli devoloperlarin ayni satirlarrda kod yazip
            merge yaptigi sirada ortaya cikan cakismalardir.
            hatayi duzeltmek icin istedigimiz kod satirini silebiliriz ve her ikisinide kalmasini istiyorsak da olur.

    Conflict' in ornek sekli
    <<<<<<<<<<< HEAD
            System.out.println("Gitignore Deneme 2")
    ============
            System.out.println("Gitignore Deneme Branch")
    >>>>>>>>>>> mehmet
           - hatayi duzeltikten sonra ;
           git add .
           git commit -m"mesaj" yaparak conflict duzelmis oluyor.
           en son branch leri esitliyoruz.
        **************
package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

    public static Properties properties;

    static { // Her method'dan önce çalışır
        String dosyaYolu = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fis); // fis'in okuduğu bilgileri properties'e yükledi

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getProperty(String key){
        /*
        test metodundan yolladığımız string key değerini alıp
        Properties class'ından getProperty() methodunu kullanarak
        bu key'e ait value'yu bize getirir
         */
   /*     return properties.getProperty(key);
                }


                }






                */
/*
package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SpendingGoodPage {

    public SpendingGoodPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//*[text()='Sign In ']")
    public WebElement signIn;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement userName;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//li[@id='menu-item-1074']")
    public WebElement myAccount;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "//*[@class='wcfm_menu_items wcfm_menu_wcfm-products']")
    public WebElement products;

    @FindBy(xpath = "//*[@id='add_new_product_dashboard']")
    public WebElement addNew;

    @FindBy(xpath = "//*[@id='manage_stock']")
    public WebElement manageStock;

    @FindBy(xpath = "//*[@id='stock_qty']")
    public WebElement stockQty;

    @FindBy(xpath = "//*[@id='backorders']")
    public WebElement backOrders;

    @FindBy(xpath = "//*[text()='Shipping']")
    public WebElement shipping;

    @FindBy(xpath = "//*[@id='weight']")
    public WebElement weight;

    @FindBy(xpath = "//*[@id='_wcfmmp_processing_time']")
    public WebElement processingTime;

    @FindBy(xpath = "//*[@class='shipping_class wcfm_title']")
    public WebElement shippingClass;



}
belirli classlari calistirma.xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="istenen class'lari calistirma">
    <test name="classlar">
        <classes>
            <class name="us8Akin.C01"/>
        </classes>
    </test>
</suite>

 */