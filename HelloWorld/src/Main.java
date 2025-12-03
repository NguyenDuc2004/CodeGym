import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SystemTime time = new SystemTime();
        VariableDataType vari = new VariableDataType();
        Rectangle rec = new Rectangle(3.4F,4.4F);
        Scanner sc = new Scanner(System.in);
        time.print();
        System.out.println("Bai2");
        vari.print();
        System.out.println("Dien TIch");
        System.out.println(rec.area());

        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");

        Scanner scanner = new Scanner(System.in);

        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();

        System.out.print("c: ");
        double c = scanner.nextDouble();

        // Tạo đối tượng phương trình và giải
        LinearEquation equation = new LinearEquation(a, b, c);
        equation.solve();

        System.out.print("Bạn muốn kiểm tra số ngày của tháng nào? ");
        int month = scanner.nextInt();
        DayOfMonth tinh = new DayOfMonth(month);
        tinh.tinhSoNgay();

        System.out.print("Nhập năm cần kiểm tra: ");
        int year = scanner.nextInt();

        LeapYearCalculator nam = new LeapYearCalculator(year);
        nam.kiemTra();

        System.out.print("Cân nặng của bạn (kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Chiều cao của bạn (m): ");
        double height = scanner.nextDouble();

        BodyMassIndex bmi = new BodyMassIndex(weight, height);
        bmi.checkBody();

        //Hien thi loi chao
        System.out.println();
        sc.nextLine();
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        HelloWorld hthi = new HelloWorld(name);
        hthi.print();

    }
}