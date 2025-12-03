import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập số nguyên không âm (0-999): ");
            int number = scanner.nextInt();
            if (number < 0 || number > 999) {
                System.out.println("Out of ability");
            } else if (number < 10) {
                // 1 chữ số
                switch (number) {
                    case 0: System.out.println("zero"); break;
                    case 1: System.out.println("one"); break;
                    case 2: System.out.println("two"); break;
                    case 3: System.out.println("three"); break;
                    case 4: System.out.println("four"); break;
                    case 5: System.out.println("five"); break;
                    case 6: System.out.println("six"); break;
                    case 7: System.out.println("seven"); break;
                    case 8: System.out.println("eight"); break;
                    case 9: System.out.println("nine"); break;
                }
            } else if (number < 20) {
                // 10-19
                switch (number) {
                    case 10: System.out.println("ten"); break;
                    case 11: System.out.println("eleven"); break;
                    case 12: System.out.println("twelve"); break;
                    case 13: System.out.println("thirteen"); break;
                    case 14: System.out.println("fourteen"); break;
                    case 15: System.out.println("fifteen"); break;
                    case 16: System.out.println("sixteen"); break;
                    case 17: System.out.println("seventeen"); break;
                    case 18: System.out.println("eighteen"); break;
                    case 19: System.out.println("nineteen"); break;
                }
            } else if (number < 100) {
                // 20-99
                int tens = number / 10;
                int ones = number % 10;
                String tensWord = "";
                switch (tens) {
                    case 2: tensWord = "twenty"; break;
                    case 3: tensWord = "thirty"; break;
                    case 4: tensWord = "forty"; break;
                    case 5: tensWord = "fifty"; break;
                    case 6: tensWord = "sixty"; break;
                    case 7: tensWord = "seventy"; break;
                    case 8: tensWord = "eighty"; break;
                    case 9: tensWord = "ninety"; break;
                }
                String onesWord = "";
                switch (ones) {
                    case 1: onesWord = " one"; break;
                    case 2: onesWord = " two"; break;
                    case 3: onesWord = " three"; break;
                    case 4: onesWord = " four"; break;
                    case 5: onesWord = " five"; break;
                    case 6: onesWord = " six"; break;
                    case 7: onesWord = " seven"; break;
                    case 8: onesWord = " eight"; break;
                    case 9: onesWord = " nine"; break;
                }
                System.out.println(tensWord + onesWord);
            } else {
                // 100-999
                int hundreds = number / 100;
                int remainder = number % 100;
                String hundredsWord = "";
                switch (hundreds) {
                    case 1: hundredsWord = "one"; break;
                    case 2: hundredsWord = "two"; break;
                    case 3: hundredsWord = "three"; break;
                    case 4: hundredsWord = "four"; break;
                    case 5: hundredsWord = "five"; break;
                    case 6: hundredsWord = "six"; break;
                    case 7: hundredsWord = "seven"; break;
                    case 8: hundredsWord = "eight"; break;
                    case 9: hundredsWord = "nine"; break;
                }
                String result = hundredsWord + " hundred";
                if (remainder != 0) {
                    result += " and ";
                    if (remainder < 10) {
                        switch (remainder) {
                            case 1: result += "one"; break;
                            case 2: result += "two"; break;
                            case 3: result += "three"; break;
                            case 4: result += "four"; break;
                            case 5: result += "five"; break;
                            case 6: result += "six"; break;
                            case 7: result += "seven"; break;
                            case 8: result += "eight"; break;
                            case 9: result += "nine"; break;
                        }
                    } else if (remainder < 20) {
                        switch (remainder) {
                            case 10: result += "ten"; break;
                            case 11: result += "eleven"; break;
                            case 12: result += "twelve"; break;
                            case 13: result += "thirteen"; break;
                            case 14: result += "fourteen"; break;
                            case 15: result += "fifteen"; break;
                            case 16: result += "sixteen"; break;
                            case 17: result += "seventeen"; break;
                            case 18: result += "eighteen"; break;
                            case 19: result += "nineteen"; break;
                        }
                    } else {
                        int tens = remainder / 10;
                        int ones = remainder % 10;
                        String tensWord = "";
                        switch (tens) {
                            case 2: tensWord = "twenty"; break;
                            case 3: tensWord = "thirty"; break;
                            case 4: tensWord = "forty"; break;
                            case 5: tensWord = "fifty"; break;
                            case 6: tensWord = "sixty"; break;
                            case 7: tensWord = "seventy"; break;
                            case 8: tensWord = "eighty"; break;
                            case 9: tensWord = "ninety"; break;
                        }
                        String onesWord = "";
                        switch (ones) {
                            case 1: onesWord = " one"; break;
                            case 2: onesWord = " two"; break;
                            case 3: onesWord = " three"; break;
                            case 4: onesWord = " four"; break;
                            case 5: onesWord = " five"; break;
                            case 6: onesWord = " six"; break;
                            case 7: onesWord = " seven"; break;
                            case 8: onesWord = " eight"; break;
                            case 9: onesWord = " nine"; break;
                        }
                        result += tensWord + onesWord;
                    }
                }
                System.out.println(result);
            }
        }

    }
}