package Pages;

public enum EmployeeStatus {
    All("All", 0),
    Freelance("Freelance", 1),
    Full_Time_Contract("Full-Time Contract", 2),
    Full_Time_Permanent("Full-Time Permanent", 3),
    Full_Time_Probation("Full-Time Probation", 4),
    Part_Time_Contract("Part-Time Contract", 5),
    Part_Time_Internship("Part-Time Internship", 6);
    private String name;
    private int id;

    EmployeeStatus(String name, int id) {
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


