import java.time.LocalDate;

public class Investment {
    private String investmentId;
    private String investmentName;
    private double expectedAnnualReturn;
    private LocalDate returnRateUpdatedDate;

    public Investment(String investmentId, String investmentName, double expectedAnnualReturn) {
        this.investmentId = investmentId;
        this.investmentName = investmentName;
        this.expectedAnnualReturn = expectedAnnualReturn;
        this.returnRateUpdatedDate = LocalDate.now();
    }

    public void updateReturnRate(LocalDate date, double newRate) {
        this.expectedAnnualReturn = newRate;
        this.returnRateUpdatedDate = date;
    }

    public String getInvestmentId() {
        return investmentId;
    }

    public String getInvestmentName() {
        return investmentName;
    }

    public double getExpectedAnnualReturn() {
        return expectedAnnualReturn;
    }

    public LocalDate getReturnRateUpdatedDate() {
        return returnRateUpdatedDate;
    }
}