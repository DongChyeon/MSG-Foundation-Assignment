import java.time.LocalDate;

public class Investment {
    private String investmentId;
    private String investmentName;
    private double expectedAnnualReturn;
    private LocalDate returnRateUpdatedDate;

    // 생성자, getter/setter 생략
    public Investment(String investmentId, String investmentName, double expectedAnnualReturn) {
        this.investmentId = investmentId;
        this.investmentName = investmentName;
        this.expectedAnnualReturn = expectedAnnualReturn;
        this.returnRateUpdatedDate = LocalDate.now(); // 초기화 시 현재 날짜로 설정
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