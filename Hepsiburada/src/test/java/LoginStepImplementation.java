import base.BaseTest;
import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import static elements.Elements.*;


public class LoginStepImplementation extends BaseTest {


    /**
     * Aşağıda kullanılan webelementler, elements package'inin içindedir.
     */

    @Step("<url> sayfasına git")
    public void navigateUrl(String url){

        driver.get(url); // url'e yöneliyoruz.
        driver.manage().window().maximize();
        String title = driver.getTitle();
        String expectedTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        assertText(expectedTitle,title);
        Logger.info("hepsiburada.com'a yonlendi");

    }

    @Step("Giriş yap butonunu kontrol et ve tıkla")
    public void clickSignIn(){

        waitUntilVisible(signInField); // giriş yap alanının görünmesini bekliyoruz.
        hoverElement(signInField);  // mouse u ilgili alana sürüklüyoruz.
        waitUntilVisible(signInBtn); // aşağı açılan pencerede giriş yap butonunu bekliyoruz
        clickElement(signInBtn); // signInBtn elementine tıklıyoruz
        Logger.info("Sign in butonuna tiklandi");
    }

    @Step("Geçerli <kullaniciAdi> ve <sifre> bilgilerini gir")
    public void setUsernameAndPassword(String kullaniciAdi, String sifre){
        waitUntilVisible(userName); // username alanının görünürlüğünü kontrol ediyoruz
        waitUntilVisible(password); // password alanının görünürlüğünü kontrol ediyoruz
        sendKeys(userName,kullaniciAdi); // kullanıcı adını setliyoruz
        sendKeys(password,sifre); // şifreyi setliyoruz
        Logger.info("Kullanici adi ve sifre girildi");
    }

    @Step("Login ekranındaki giriş yap butonuna tıkla")
    public void clickLoginBtn(){
        waitUntilVisible(loginBtn); // login butonunun görünürlüğünü kontrol ediyoruz
        clickElement(loginBtn);  // login butonuna tıklıyoruz
        Logger.info("Login butonuna tıklandı");
    }

    @Step("Hesabım alanında <expectedName>  isminin doğruluğunu kontrol et")
    public void verifyAccountName(String expectedName){
        waitUntilVisible(accountName); // hesap adınının yazdığı alanı bekliyoruz
        assertElementText(accountName, expectedName); // hesap adı alanında yazanla beklediğimiz sonucu karşılaştırıyoruz.
        Logger.info("Hesap adi kontrolu yapildi.");
    }

}
