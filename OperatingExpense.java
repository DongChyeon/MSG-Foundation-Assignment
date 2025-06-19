import java.time.LocalDate;

public class OperatingExpense {
    private double annualExpense;
    private LocalDate updatedDate;

    public OperatingExpense(double annualExpense, LocalDate updatedDate) {
        this.annualExpense = annualExpense;
        this.updatedDate = updatedDate;
    }

    public double calculateWeeklyExpense() {
        return annualExpense / 52.0;
    }

    public void updateExpense(double newExpense, LocalDate date) {
        this.annualExpense = newExpense;
        this.updatedDate = date;
    }

    public double getAnnualExpense() {
        return annualExpense;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }
}
