import javax.swing.plaf.synth.SynthTableUI;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Duc1","nkmduc1@gmail.com","0904785723"));
        contacts.add(new Contact("Duc2","nkmduc2@gmail.com","0904785723"));
        contacts.add(new Contact("Duc3","nkmduc3@gmail.com","0904785723"));
        contacts.add(new Contact("Duc4","nkmduc4@gmail.com","0904785723"));
        contacts.add(1,new Contact("Duc5","nkmduc5@gmail.com","0904785723"));


//        Iterator<Contact> iterator = contacts.iterator();
//        while(iterator.hasNext()){
//            String student = iterator.next();
//            System.out.println(student);
//        }

        for (Contact c : contacts){
            System.out.println(c);
        }

        contacts.remove(3);

        System.out.println("Sau khi xoa");
        for (Contact c : contacts){
            System.out.println(c);
        }

        Set <String> students = new TreeSet<>();
        students.add("Khang");
        students.add("Khang");
        students.add("Duc");
        students.add("Duc2");
        students.add("Mai");

        for( String s : students){
            System.out.println(s);
        }




    }
}
