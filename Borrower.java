public class Borrower {
    private String name;
    private int yearsEmployed;
    private int marriageDuration;
    private double totalIncome;

    public Borrower(String name, int yearsEmployed, int marriageDuration, double totalIncome) {
        this.name = name;
        this.yearsEmployed = yearsEmployed;
        this.marriageDuration = marriageDuration;
        this.totalIncome = totalIncome;
    }

    public boolean isEligibleForGrant() {
        return marriageDuration >= 1 && marriageDuration < 10 && yearsEmployed >= 1;
    }

    public String getName() {
        return name;
    }

    public int getYearsEmployed() {
        return yearsEmployed;
    }

    public int getMarriageDuration() {
        return marriageDuration;
    }

    public double getTotalIncome() {
        return totalIncome;
    }
}
