package elements;

import org.openqa.selenium.By;

public class Elements {
    /**
     * Ana sayfa
     */
    public static By signInField = By.id("myAccount"); // aşağı açılır girişyap penceresi
    public static By signInBtn = By.id("login"); // sign in butonu
    public static By accountName = By.xpath("//div[@id='myAccount']//span[@class='sf-OldMyAccount-1k66b']"); // hesap adı yazan kısım

    /**
     * Login ekranı
     */
    public static By userName = By.xpath("//input[@id='txtUserName']"); // username alanı
    public static By password = By.xpath("//input[@id='txtPassword']"); // pasword alanı)
    public static By loginBtn = By.id("btnLogin"); // Login butonu


}
