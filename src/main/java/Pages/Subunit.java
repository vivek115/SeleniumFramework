package Pages;

public enum Subunit {
    All("All", 0),
    Administration("Administration", 2),
    Engineering("Engineering", 3),
    Development("  Development", 4),
    Quality_Assurance("  Quality Assurance", 5),
    TechOps("  TechOps", 6),
    Sales_Marketing("Sales & Marketing", 7),
    Sales("  Sales", 8),
    Marketing("  Marketing", 9),
    Client_Services("Client Services", 10),
    Technical_Support("  Technical Support", 11),
    Finance("Finance", 12),
    Human_Resources("Human Resources", 13);

    private String name;
    private int id;

    Subunit(String name, int id) {
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

