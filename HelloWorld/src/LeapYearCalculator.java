public class LeapYearCalculator {
    private int year;
    public LeapYearCalculator(int year) {
        this.year = year;
    }

    public void kiemTra() {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.printf("%d là năm nhuận.\n", year);
                } else {
                    System.out.printf("%d KHÔNG phải là năm nhuận.\n", year);
                }
            } else {
                System.out.printf("%d là năm nhuận.\n", year);
            }
        } else {
            System.out.printf("%d KHÔNG phải là năm nhuận.\n", year);
        }
    }
}
