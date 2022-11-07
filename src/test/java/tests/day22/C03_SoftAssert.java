package tests.day22;

        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebElement;
        import org.testng.annotations.Test;
        import org.testng.asserts.SoftAssert;
        import utilities.TestBaseBeforeClassAfterClass;
        import utilities.TestBaseCross;

public class C03_SoftAssert extends TestBaseCross {
    @Test
    public void test01() {

        SoftAssert softAssert = new SoftAssert();
        //1-amazon anasayfaya gidin
        driver.get("https://amazon.com");
        //2-title in Amazon içerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"),"Girdiğiniz kelimeyi içermiyor");
        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"WE erişilemez");
        //4-arama kutusuna Nuella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        //5-arama yapıldıgını test edin
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonuc.isDisplayed(),"SonucWE görüntülenemedi");
        //6-arama sonucunun Nutella içerdigini test edin
        softAssert.assertTrue(sonuc.getText().contains("Nutella"),"Nutella içermiyor");
        softAssert.assertAll();
        System.out.println("Hata varsa burası çalışmaz");
    }
}
/*
<!--
        Interview sorusu : CrossBrowser biliyormusunuz. Biliyorsanız kısaca anlatırmısınız
        -Öncelikle CrossBrowser yapmak için TestNG framework'unde utilities package'ı altında bir tane driver class'ı oluştururum.
        XML dosyasından göndereceğim browser'ları burada tanımlamak için parametreli bir method oluştururum.
        -Sonrasında yine utilities package'ı altında TestBase class'ı oluştururum. Bu class'da parametre notasyonu ile
        bir method oluştururum ve drive'ımı bu method altında daha önce oluşturmuş olduğum driver class'da oluşturduğum parametreli
        methoda atama yaparım ve XML dosyasından parametre olarak browser ne gelirse onu çalıştırır.
        Sonra CrossBrowser yapacağım test class'larımı oluşturur ve oluşturmuş olduğum TestBase class'a extends yaparım.
        -Son olarak XML dosyamı oluşturur hangi class'larımı hangi browser ile çalıştıracaksam test tag'ından sonra parametre tag'ı
        ile browser'ımı seçerim.
        Eğer paralel olarak CrossBrowser yapacaksam suite tag'ına paralel ve thread-count değerlerini eklerim.
        -->*/