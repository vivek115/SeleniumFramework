package ObjectFactory;

import Pages.AddUser;
import Pages.Login;
import Pages.PIM;
import org.openqa.selenium.WebDriver;

public class Page {
    WebDriver driver;
    private Login loginPage;
    private AddUser userPage;
    private PIM PIMPage;

    public Page(WebDriver driver) {
       this.driver = driver;
    }
    public Login getLoginPage() {
        if (loginPage == null) {
            loginPage = new Login(driver);
        }
        return loginPage;
    }
    public AddUser getUserDetail() {
        if (userPage == null) {
            userPage = new AddUser(driver);
        }
        return userPage;
    }
    public PIM getPIM() {
        if (PIMPage == null) {
            PIMPage = new PIM(driver);
        }
        return PIMPage;
    }
}