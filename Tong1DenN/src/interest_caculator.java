public class interest_caculator {
    private double money;
    private int month;
    private double interestRate;

    public interest_caculator(int month, double money, double interestRate) {
        this.month = month;
        this.money = money;
        this.interestRate = interestRate;
    }

    public void totalInterest(){
        double totalInterest = 0;
        for(int i = 0; i < month; i++){
            totalInterest += money * (interestRate/100)/12 * month;
        }
        System.out.println("Total of interest: " + totalInterest);


    }
}
