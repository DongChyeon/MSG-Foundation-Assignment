import java.time.LocalDate;

public class Mortgage {
    private String mortgageId;
    private Borrower borrower;
    private double originalPurchasePrice;
    private LocalDate issuedDate;

    private double weeklyPayment;

    private double annualPropertyTax;
    private LocalDate propertyTaxUpdatedDate;

    private double annualInsurancePremium;
    private LocalDate insuranceUpdatedDate;

    public Mortgage(String mortgageId, Borrower borrower, double originalPurchasePrice,
                    LocalDate issuedDate, double weeklyPayment, double weeklyIncome,
                    double annualPropertyTax, double annualInsurancePremium) {
        this.mortgageId = mortgageId;
        this.borrower = borrower;
        this.originalPurchasePrice = originalPurchasePrice;
        this.issuedDate = issuedDate;
        this.weeklyPayment = weeklyPayment;
        this.annualPropertyTax = annualPropertyTax;
        this.annualInsurancePremium = annualInsurancePremium;
        this.propertyTaxUpdatedDate = LocalDate.now();
        this.insuranceUpdatedDate = LocalDate.now();
    }

    public String getMortgageId() {
        return mortgageId;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public double getWeeklyPayment() {
        return weeklyPayment;
    }

    public double getAnnualPropertyTax() {
        return annualPropertyTax;
    }

    public double getAnnualInsurancePremium() {
        return annualInsurancePremium;
    }

    public double getWeeklyIncome() {
        return borrower.getTotalIncome() / 52.0;
    }

    public double calculateMonthlyPayment() {
        return weeklyPayment * 4.345;
    }

    public void updatePropertyTax(double tax, LocalDate updatedDate) {
        this.annualPropertyTax = tax;
        this.propertyTaxUpdatedDate = updatedDate;
    }

    public void updateInsurance(double premium, LocalDate updatedDate) {
        this.annualInsurancePremium = premium;
        this.insuranceUpdatedDate = updatedDate;
    }
}