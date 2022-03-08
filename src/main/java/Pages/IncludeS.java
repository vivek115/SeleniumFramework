package Pages;

public enum IncludeS {
    Current_Employees_Only("Current Employees Only", 1),
    Current_and_Past_Employees("Current and Past Employees", 2),
    Past_Employees_Only("Past Employees Only", 3);
    private String name;
    private int id;

    IncludeS(String name, int id) {
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



