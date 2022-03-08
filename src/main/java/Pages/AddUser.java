package Pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AddUser {
    WebDriver driver;

    public AddUser(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Admin")
    private WebElement Admin;
    @FindBy(linkText = "User Management")
    private WebElement UserManagement;
    @FindBy(linkText = "Users")
    private WebElement Users;
    @FindBy(xpath = "//input[@id='btnAdd']")
    private WebElement AddButton;
    @FindBy(xpath = "//div[@class='head']")
    private WebElement verifyUserPage;
    @FindBy(xpath = "//select[@id='systemUser_userType']")
    private WebElement UserRole;
    @FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
    private WebElement Employee_Name;
    @FindBy(xpath = "//input[@id='systemUser_userName']")
    private WebElement UserName;
    @FindBy(xpath = "//select[@id='systemUser_status']")
    private WebElement Employee_Status;
    @FindBy(xpath = "//input[@id='systemUser_password']")
    private WebElement PassWord;
    @FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
    private WebElement ConfirmPassWord;
    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement SaveButton;
    @FindBy(xpath = "//input[@id='searchSystemUser_userName']")
    private WebElement Username;
    @FindBy(xpath = "//input[@id='searchBtn']")
    private WebElement SearchButton;
    @FindBy(linkText = "vicky233123")
    private WebElement VerifyUser;
    @Test
    public void AddUser() {
        Admin.click();
        Actions action = new Actions(driver);
        action.moveToElement(UserManagement).build().perform();
        action.moveToElement(Users).click();
        AddButton.click();
    }

    @Test
    public void VerifyAddUserPage() {
        String element = verifyUserPage.getText();
        Assert.assertEquals(element, "Add User", "Add user page is not verified");
    }

    @Test
    public void UserDetail( String employeename,String password, String confirmpassword) {
        for (int i = 0; i <= 1; i++) {
            UserRole.click();
            UserRole.sendKeys(Keys.ARROW_DOWN);
            UserRole.sendKeys(Keys.ENTER);
        }
        Employee_Name.sendKeys(employeename);
        String abc = getSaltString();
        UserName.click();
        UserName.sendKeys(abc);
        for (int i = 0; i <= 1; i++) {
            Employee_Status.click();
            Employee_Status.sendKeys(Keys.ARROW_DOWN);
            Employee_Status.sendKeys(Keys.ENTER);
        }
        PassWord.sendKeys(password);
        ConfirmPassWord.sendKeys(confirmpassword);
        SaveButton.click();
    }

    public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
//    public void verifyUserCreated(String username1) throws InterruptedException {
//        Thread.sleep(2000);
//        Username.sendKeys(username1);
//        SearchButton.click();
//        String element = VerifyUser.getText();
//        Assert.assertEquals(element, "vicky233123", "User is not added in the users list");
//    }
}
