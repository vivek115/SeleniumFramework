package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='txtUsername']")
    private WebElement Usernamee;
    @FindBy(xpath = "//input[@id='txtPassword']")
    private WebElement Password;
    @FindBy(linkText = "Forgot your password?")
    private WebElement ForgotPassword;
    @FindBy(xpath = "//input[@id='btnCancel']")
    private WebElement Click_On_CancelButton;
    @FindBy(xpath = "//input[@id='btnLogin']")
    private WebElement Click_On_LoginButton;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String verify_title(){
        return  driver.getTitle();
    }
    public void SignUp() {
        Usernamee.sendKeys("Admin");
        Password.sendKeys("admin123");
   //     ForgotPassword.click();
    //    Click_On_CancelButton.click();
        Click_On_LoginButton.click();
    }
    public void VerifyHomePage(){
        String actual = driver.getCurrentUrl();
        String expected = "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials";
        Assert.assertEquals(actual,expected,"Home page is not verified");
    }
}