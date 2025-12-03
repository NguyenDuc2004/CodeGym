import java.util.Scanner;

public class HelloWorld {
////    public static void main(String[] args) {
//////    byte b = 10;
//////    short s = 20;
//////    int i = 30;
//////    long l = 30L; // ep kieu int ve long
//////
//////        float f = 3.14f;
//////        double d = 3.14d;
//////
//////        boolean bool = true;
//////        char ch = 'A';
//////
//////
//////        System.out.println(b);
//////        System.out.println(i);
//////        System.out.println(l);
//////        System.out.println(f);
//////        System.out.println(d);
//////        System.out.println(bool);
//////        System.out.println(ch);
////
//////
////        do{
////            System.out.println("==Tiem Pho Duc dtrai===");
////            System.out.println("Moi chon mon: ");
////            System.out.println("1.  Pho chin");
////            System.out.println("2.  Com nguoi");
////            System.out.println("3.  Pho tai");
////            System.out.println("4.  EXIT");
////            Scanner sc = new Scanner(System.in);
////            System.out.print("Nhap lua chon: ");
////            int choice = sc.nextInt();
//////        switch (choice){
//////            case 1:
//////                System.out.println("Pho nhieu hanh");
//////                break;
//////            case 2:
//////                System.out.println("Com nguoi");
//////                break;
//////            case 3:
//////                System.out.println("Pho tai");
//////                break;
//////            default:
//////                System.out.println("sai");
//////                break;
//////        }
////            if(choice == 1) System.out.println("Pho chin nhieu hanh");
////            else if(choice == 2) System.out.println("Com nguoi nhieu hanh");
////            else if(choice == 3)  System.out.println("Pho tai nhieu hanh");
////            else if(choice == 4) return;
////            else System.out.println("Khong ton tai. Moi chon lai");
////        }while(true);
//
//
//
//
//    }
    private String name;

    public HelloWorld(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println("Hello: " + name);
    }
}
