package TestCases;

import org.testng.annotations.Test;
public class VerifyLogin extends BaseTest {
    @Test
    public void Test1()
    {
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
    }
