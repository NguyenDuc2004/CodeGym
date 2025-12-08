public class isPrime {
    private int number;

    public isPrime(int number) {
        this.number = number;
    }

    public void checkPrime (){
        if (number < 2){
            System.out.println(number + " is not a prime");
        }
        else {
            int i = 2;
            boolean check = true;
            while (i < number) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check)
                System.out.println(number + " is a prime");
            else
                System.out.println(number + " is not a prime");
        }
    }

}
