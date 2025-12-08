import java.util.Scanner;

public class draw_geometry {

    private int choice;
    private Scanner input;

    public draw_geometry() {
        choice = -1;
        input = new Scanner(System.in);
    }

    public void showMenu() {
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw tam giac vuong");
            System.out.println("3. tam giac can");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            handleChoice(choice);
        }
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Draw the rectangle");
                for(int i = 0; i < 3 ; i++){
                    for(int j = 0; j < 6; j++){
                        System.out.print("* ");
                    }
                    System.out.println();

                }
                break;
            case 2:
                System.out.println("Draw the tam giac vuong");
                    for(int i = 5 ; i>=1;i--){
                        for(int j = 1; j < i; j++){
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                break;
            case 3:
                System.out.println("tam giac can");
                int h = 7;

                for (int i = 1; i <= h; i++) {
                    for (int space = 1; space <= h - i; space++) {
                        System.out.print(" ");
                    }
                    for (int star = 1; star <= 2 * i - 1; star++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 0:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("No choice!");
        }
    }

}
