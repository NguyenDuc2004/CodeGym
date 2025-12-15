import java.util.Scanner;

public class PersonDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the width:");
        int width = scanner.nextInt();
        System.out.print("Enter the height:");
        int height = scanner.nextInt();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your Rectangle \n"+ rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rectangle.getArea());

        System.out.println("phuong trinh bac 2");
        System.out.println("nhap 3 tham so");
        double a,b,c;
        System.out.println("a: ");
        a = scanner.nextDouble();
        System.out.println("b: ");
        b = scanner.nextDouble();
        System.out.println("c: ");
        c = scanner.nextDouble();
        QuadraticEquation pt1 = new QuadraticEquation(a,b,c);
        if(pt1.getDiscriminant() > 0){
            System.out.println("nghiem 1: " + pt1.getRoot1());
            System.out.println("nghiem 2: " + pt1.getRoot2());
        }else if(pt1.getDiscriminant() == 0){
            System.out.println("nghiem kep: " + pt1.getRoot1());
        }else{
            System.out.println("The equation has no roots");
        }

    }
}
