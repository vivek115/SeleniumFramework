package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifyPIM extends BaseTest {
    WebDriver driver;

    @Test
    public void Test1() {
        pageFactory.getLoginPage().SignUp();
        pageFactory.getLoginPage().VerifyHomePage();
    }

    @Test(dependsOnMethods = "Test1")
    public void user() throws InterruptedException {
      Thread.sleep(3000);
        pageFactory.getUserDetail().AddUser();
        pageFactory.getUserDetail().VerifyAddUserPage();
        pageFactory.getUserDetail().UserDetail("Aaliyah Haq", "hello@##123", "hello@##123");
        //pageFactory.getUserDetail().verifyUserCreated("vicky233123");
    }

    @Test(dependsOnMethods = "user")
    public void PIM() throws InterruptedException {
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageFactory.getPIM().Hover();
        pageFactory.getPIM().Employee_List();
        pageFactory.getPIM().Include();
        pageFactory.getPIM().title();
        pageFactory.getPIM().selectunit();
    }
}

