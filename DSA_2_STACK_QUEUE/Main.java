import java.util.*;

public class Main {

    public static void main(String[] args) {
//        Stack<String> histories = new Stack<>();
//        histories.push("gg.com.vn");
//        histories.push("codegym.vn");
//        histories.push("ytb.vn");
//        histories.push("fb.vn");
//
//
//        System.out.println("Back history: " + histories.size());
//        System.out.println("Trang web hien tai: " + histories.peek());//tra ve pt tren cung
//        System.out.println("Con lai history: "+ histories.size());
//
//        while(!histories.isEmpty()){
//            System.out.println("Back to: " + histories.pop());
//            //lay ra va xoa phan tu tren cung cua stack
//        }
//
//        System.out.println("Con lai history: "+ histories.size());

//        PriorityQueue<String> tickets = new PriorityQueue<>();
//        tickets.add("Khang");
//        tickets.add("Duc");
//        tickets.add("Ngoc Dao");
//
//        System.out.println("Tickets size: " + tickets.size());
//        while (!tickets.isEmpty()){
//            System.out.println("Next ticket: " + tickets.poll());
//        }

        List<Student> students = new ArrayList<>();
        students.add(new Student("An",3));
        students.add(new Student("Khang",3.5));
        students.add(new Student("Thinh",3.8));
        students.add(new Student("Vuong",4.0));
        students.add(new Student("Vuong2",1.5));

        Collections.sort(students);
        for (Student s : students){
            System.out.println(s);
        }

        Collections.sort(students,new StudentScoreComparator());
        for (Student s : students){
            System.out.println(s);
        }
        System.out.println("sap xep theo ten: ");
        Collections.sort(students,new StudentNameComparator());
        for (Student s : students){
            System.out.println(s);
        }
    }
}
