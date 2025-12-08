import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        int number = scanner.nextInt();
        isPrime check = new isPrime(number);
        check.checkPrime();

        //bai th2 vong for
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;
        System.out.println("Enter investment amount: ");
        money = scanner.nextDouble();
        System.out.println("Enter number of months: ");
        month = scanner.nextInt();
        System.out.println("Enter annual interest rate in percentage: ");
        interestRate = scanner.nextDouble();
        interest_caculator tinhlai = new interest_caculator(month,money,interestRate);
        tinhlai.totalInterest();

        //ucln
        int a;
        int b;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = input.nextInt();
        System.out.println("Enter b: ");
        b = input.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        greatest_common_factor ucln = new greatest_common_factor(a,b);
        ucln.checkUCLN();

        //menu
        draw_geometry g = new draw_geometry();
        g.showMenu();
    }
}