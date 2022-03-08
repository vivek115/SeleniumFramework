package Pages;

public enum ConfigurationDropDown {
    Optional_Fields("Optional Fields", 1),
    Custom_Fields("Custom Fields", 2),
    Data_Import("Data Import", 3),
    Reporting_Methods("Reporting Methods", 4),
    Termination_Reasons("Termination Reasons", 5);


    private String name;
    private int id;

    ConfigurationDropDown(String name, int id) {
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




