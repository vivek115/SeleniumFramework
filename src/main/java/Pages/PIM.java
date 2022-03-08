package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.Random;

public class PIM {
    WebDriver driver;

    public PIM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "PIM")
    private WebElement PIM;
    @FindBy(linkText = "Configuration")
    private WebElement Configuration;
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
    private static final String DROPDOWN_VALUES = "//a[contains(text(),'%s')]";
    @FindBy(xpath = "//a[@id='menu_pim_listCustomFields']")
    private WebElement Select_Dropdown;
    @FindBy(linkText = "Employee List")
    private WebElement EmployeeList;
    @FindBy(xpath = "//input[@class='ac_input inputFormatHint']")
    private WebElement Name;
    @FindBy(xpath = "//input[@id='empsearch_id']")
    private WebElement Employee_Id;
    @FindBy(xpath = "//select[@id='empsearch_employee_status']")
    private WebElement Status;
    private static final String DROPDOWN_VALUES1 = "//select[@id='empsearch_employee_status']/child::option[@value='%s']";
    @FindBy(xpath = "//select[@id='empsearch_employee_status']/child::option[@value='3']")
    private WebElement SelectDropdown;
    @FindBy(xpath = "//select[@id='empsearch_termination']")
    private WebElement Include;
    private static final String DROPDOWN_VALUES2 = "//select[@id='empsearch_termination']/child::option[@value='%s']";
    @FindBy(xpath = "//select[@id='empsearch_termination']/child::option[@value='3']")
    private WebElement SelectDropdown1;
    @FindBy(xpath = "//input[@id='empsearch_supervisor_name']")
    private WebElement SupervisorName;
    @FindBy(xpath = "//select[@id='empsearch_job_title']")
    private WebElement JobTitle;
    private static final String DROPDOWN_VALUES3 = "//select[@id='empsearch_job_title']/child::option[@value='0']";
    @FindBy(xpath = "//select[@id='empsearch_job_title']/child::option[@value='1']")
    private WebElement SelectDropdown2;
    @FindBy(xpath = "//select[@id='empsearch_sub_unit']")
    private WebElement SelectUnit;
    private static final String DROPDOWN_VALUES4 = "//select[@id='empsearch_sub_unit']/child::option[@value='%s']";
    @FindBy(xpath = "//select[@id='empsearch_sub_unit']/child::option[@value='3']")
    private WebElement Selectdropdown3;
    @FindBy(xpath = "//input[@id='searchBtn']")
    private WebElement SearchButton;

    ////select[@id='empsearch_job_title']/child::option[@value='0']
////*[@id='empsearch_id']
    public void Hover() {
        PIM.click();
        Actions action = new Actions(driver);
        action.moveToElement(Configuration).build().perform();
        for (ConfigurationDropDown ele : ConfigurationDropDown.values()) {
            WebElement io = driver.findElement(By.xpath(String.format(DROPDOWN_VALUES, ele.ChallengeName())));
            Assert.assertEquals(io.getText(), ele.ChallengeName(), "Values are not same");
        }
        Select_Dropdown.click();
    }

    public void Employee_List() {
        String abc = getSaltString();
        EmployeeList.click();
        Name.sendKeys(abc);
        Employee_Id.sendKeys(abc);
        Status.click();
        for (EmployeeStatus ele : EmployeeStatus.values()) {
            WebElement io = driver.findElement(By.xpath(String.format(DROPDOWN_VALUES1, ele.ChallengeId())));
            Assert.assertEquals(io.getText(), ele.ChallengeId(), "Values are not same");
        }
        SelectDropdown.click();
    }

    public void Include() {
        Include.click();
        String abc = getSaltString();
        for (IncludeS ele1 : IncludeS.values()) {
            WebElement io = driver.findElement(By.xpath(String.format(DROPDOWN_VALUES2, ele1.ChallengeId())));
            Assert.assertEquals(io.getText(), ele1.ChallengeId(), "Values are not same");
        }
        SelectDropdown1.click();
        SupervisorName.sendKeys(abc);
    }

    public void title() {
        JobTitle.click();
        for (Jobtitle ele : Jobtitle.values()) {
            WebElement io = driver.findElement(By.xpath(String.format(DROPDOWN_VALUES3, ele.ChallengeId())));
            Assert.assertEquals(io.getText(), ele.ChallengeId(), "Values are not same");
        }
        SelectDropdown2.click();
    }

    public void selectunit() {
        SelectUnit.click();
        for (Subunit ele : Subunit.values()) {
            WebElement io = driver.findElement(By.xpath(String.format(DROPDOWN_VALUES4, ele.ChallengeId())));
            Assert.assertEquals(io.getText(), ele.ChallengeId(), "Values are not same");
        }
        Selectdropdown3.click();
        SearchButton.click();
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
}