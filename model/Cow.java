package model;
// Cow.java

public class Cow {
    private String id;
    private int ageYears;
    private int ageMonths;
    private int udderCount;

    public Cow(String id, int ageYears, int ageMonths, int udderCount) {
        this.id = id;
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.udderCount = udderCount;
    }

    // Getter and Setter methods
    public String getId() { return id; }
    public int getAgeYears() { return ageYears; }
    public int getAgeMonths() { return ageMonths; }
    public int getUdderCount() { return udderCount; }
    public void setUdderCount(int udderCount) { this.udderCount = udderCount; }
}