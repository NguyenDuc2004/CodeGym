import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double rate = 23000;


        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tiền USD cần chuyển đổi: ");
        double usd = scanner.nextDouble();

        double vnd = usd * rate;
        System.out.printf("%.2f USD = %.0f VND\n", usd, vnd);
    }
}