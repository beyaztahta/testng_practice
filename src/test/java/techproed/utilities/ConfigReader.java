package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;
    /*
    Methodu devreye sokabilmel icin FİLEINPUTSTREAM ile dosya yolunu belirtmemiz gerekir.
    Methodttan once calısması ıcın static blok icerisine FILEINPUTSTREAM i olusturmamız gerekır.
    */
    static {
        String path="config.properties";
        try {
            FileInputStream fis=new FileInputStream(path);
            properties=new Properties();//objeyi olusturduk ve deger atamasi yaptik.
            properties.load(fis);//fis in okudugu bilgileri properties e yukler.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static String getProperties(String key) {
        /*
        Test methodundan gonderdigimiz String key degerini alıp Properties classından getProperty()methodunu kullanarak
        bu key e ait value yu bize getirir.
         */
        return properties.getProperty(key);
    }
}
