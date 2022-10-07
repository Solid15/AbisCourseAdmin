package be.abis.courseadmin.enumm;

public enum Gender {
    MALE("he", "M"),
    FEMALE("she", "F"),
    OTHER("they", "O");

    private String pronoun;
    private String abbreviation;

    Gender(String pronoun, String abbreviation) {
        this.pronoun = pronoun;
        this.abbreviation = abbreviation;
    }

    public String getPronoun() {
        return pronoun;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
