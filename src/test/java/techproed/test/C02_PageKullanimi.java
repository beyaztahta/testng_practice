package test;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageKullanimi {

    //amazona gidelim
    //iphone aratalım
    //sonuc yazısının iphone içerdiğini test edelim


    @Test
    public void test01() {
        //amazona gidelim
        AmazonPage amazonPage=new AmazonPage();
        Driver.getDriver().get("https://amazon.com");

        //iphone aratalım
        amazonPage.aramaKutusu.sendKeys("iphone", Keys.ENTER);

        //sonuc yazısının iphone içerdiğini test edelim
        String actualSonuc = amazonPage.sonucYazisi.getText();
        String arananKelime = "iphone";

        assert actualSonuc.contains(arananKelime);
        Driver.closeDriver();
    }
}
