package Pages;

public enum Jobtitle {
    All("All", 0),
    Automation_Tester("Automation Tester", 26),
    BTest("BTest", 27),
    Chief_Executive_Officer("Chief Executive Officer", 1),
    Chief_Financial_Officer("Chief Financial Officer", 2),
    Customer_Success_Manager("Customer Success Manager", 17),
    Database_Administrator("Database Administrator", 12),
    EA("EA", 28),
    Engineer("Engineer", 3),
    Finance_Manager("Finance Manager", 20),
    Financial_Analyst("Financial Analyst", 21),
    Head_of_Support("Head of Support", 18),
    HR_Associate("HR Associate", 24),
    HR_Manager("HR Manager", 23),
    IT_Manager("IT Manager", 10),
    Network_Administrator("Network Administrator", 11),
    Payroll_Administrator("Payroll Administrator", 25),
    Pre_Sales_Coordinator("Pre-Sales Coordinator", 14),
    QA_Engineer("QA Engineer", 9),
    QA_Lead("QA Lead", 8),
    Sales_Representative("Sales Representative", 13),
    Social_Media_Marketer("Social Media Marketer", 15),
    Software_Architect("Software Architect", 6),
    Software_Engineer("Software Engineer", 7),
    Support_Specialist("Support Specialist", 19),
    test("test", 29),
    VP_Client_Services("VP - Client Services", 5),
    VP_Sales_Marketing("VP - Sales & Marketing", 4);

    private String name;
    private int id;

    Jobtitle(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String ChallengeName() {
        return name;
    }

    public int ChallengeId() {
        return id;
    }

}

