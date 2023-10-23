package objectRepository;

import org.openqa.selenium.By;

public class pageLogin {
    By user_name = By.name("user-name");
    By passwd = By.id("password");
    By button_login = By.xpath("//input[@type='submit'][@data-test='login-button']");
    public By getUser_name() { return user_name;}
    public By getPasswd() { return passwd; }
    public By getButton_login() { return button_login;}
}
