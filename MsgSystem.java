import java.util.List;
import java.time.LocalDate;

public class MsgSystem {
    private List<Investment> investments;
    private List<Mortgage> mortgages;
    private OperatingExpense operatingExpense;

    private double availableFundsForWeek;
    private double expectedGrantsForWeek;
    private double expectedMortgagePaymentsForWeek;

    public MsgSystem(List<Investment> investments, List<Mortgage> mortgages, OperatingExpense expense) {
        this.investments = investments;
        this.mortgages = mortgages;
        this.operatingExpense = expense;
    }

    public double calculateInvestmentReturn() {
        double totalReturn = 0.0;
        for (Investment investment : investments) {
            totalReturn += investment.getExpectedAnnualReturn(); // 투자 수익 계산
        }
        return totalReturn;
    }

    public double calculateWeeklyInvestmentReturn() {
        return calculateInvestmentReturn() / 52.0; // 연간 수익을 주 단위로 변환
    }

    public double calculateWeeklyOperatingExpense() {
        return operatingExpense.calculateWeeklyExpense();
    }

    public double calculateWeeklyMortgagePayments() {
        double total = 0.0;
        for (Mortgage mortgage : mortgages) {
            double escrow = (mortgage.getAnnualInsurancePremium() * mortgage.getAnnualPropetyTax()) / 52.0;
            total += mortgage.getWeeklyPayment() + escrow;
        }
        this.expectedMortgagePaymentsForWeek = total;
        return total;
    }

    public double calculateWeeklyGrants() {
        double total = 0.0;
        for (Mortgage mortgage : mortgages) {
            double escrow = (mortgage.getAnnualInsurancePremium() + mortgage.getAnnualPropertyTax()) / 52.0;
            double totalWeeklyPay = mortgage.getWeeklyPayment() + escrow;
            double incomeLimit = mortgage.getWeeklyIncome() * 0.28;

            if (totalWeeklyPay <= incomeLimit) {
                total += (totalWeeklyPay - incomeLimit);
            }
        }
        this.expectedGrantsForWeek = total;
        return total;
    }

    public double calculateAvailableFundsForWeek() {
        double weeklyInvestment = calculateWeeklyInvestmentReturn();
        double weeklyOperatingExpense = calculateWeeklyOperatingExpense();
        double weeklyMortgagePayments = calculateWeeklyMortgagePayments();
        double weeklyGrants = calculateWeeklyGrants();

        this.availableFundsForWeek = weeklyInvestment + weeklyOperatingExpense + weeklyMortgagePayments + weeklyGrants;
        return this.availableFundsForWeek;
    }

    public void printWeeklyFundsReport() {
        System.out.println("주간 자금 보고서:");
        System.out.println("예상 연간 운영 비용: " + operatingExpense.getAnnualExpense());
        System.out.println("주간 운영 비용: " + calculateWeeklyOperatingExpense());
        System.out.println("예상 주간 투자 수익: " + calculateWeeklyInvestmentReturn());
        System.out.println("예상 주간 모기지 지불: " + expectedMortgagePaymentsForWeek);
        System.out.println("예상 주간 보조금: " + expectedGrantsForWeek);
        System.out.println("주간 사용 가능한 자금: " + availableFundsForWeek);
    }

    public void printAllInvestments() {
        System.out.println("모든 투자:");
        for (Investment investment : investments) {
            System.out.println("투자 ID: " + investment.getInvestmentId() +
                               ", 이름: " + investment.getInvestmentName() +
                               ", 예상 연간 수익: " + investment.getExpectedAnnualReturn() +
                               ", 업데이트 날짜: " + investment.getReturnRateUpdatedDate());
        }
    }

    public void printAllMortgages() {
        System.out.println("모든 모기지:");
        for (Mortgage mortgage : mortgages) {
            System.out.println("모기지 ID: " + mortgage.getMortgageId() +
                               ", 차용인: " + mortgage.getBorrower() +
                               ", 주간 지불: " + mortgage.getWeeklyPayment() +
                               ", 주간 소득: " + mortgage.getWeeklyIncome() +
                               ", 연간 재산세: " + mortgage.getAnnualPropertyTax() +
                               ", 연간 보험료: " + mortgage.getAnnualInsurancePremium());
        }
    }
}