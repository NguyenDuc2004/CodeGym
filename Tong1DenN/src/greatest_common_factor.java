public class greatest_common_factor {
    private int a;
    private int b;

    public greatest_common_factor(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void checkUCLN(){
        if (a == 0 || b == 0) {
            System.out.println("No greatest common factor");
        }
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        System.out.println("Greatest common factor: " + a);
    }

}
