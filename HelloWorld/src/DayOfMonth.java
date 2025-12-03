public class DayOfMonth {
    private int month;

    public DayOfMonth(int month) {
        this.month = month;
    }

    public void tinhSoNgay() {
        switch (month) {
            case 2:
                System.out.println("Tháng 2 có 28 hoặc 29 ngày.");
                break;

            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12:
                System.out.println("Tháng " + month + " có 31 ngày.");
                break;

            case 4: case 6: case 9: case 11:
                System.out.println("Tháng " + month + " có 30 ngày.");
                break;

            default:
                System.out.println("Tháng không hợp lệ! Vui lòng nhập 1–12.");
        }
    }
}
