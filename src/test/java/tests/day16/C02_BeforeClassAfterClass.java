package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_BeforeClassAfterClass extends TestBaseBeforeClassAfterClass {
    @Test
    public void testamazon() {
driver.get("https://www.amazon.com");
    }

    @Test
    public void testBestBuy() {
driver.get("https://www.BestBuy.com");
    }

    @Test
    public void testTechproed() {
        driver.get("https://www.Techproeducation.com");

    }

}