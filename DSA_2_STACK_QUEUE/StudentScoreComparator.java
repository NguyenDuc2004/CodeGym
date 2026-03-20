import java.util.Comparator;

public class StudentScoreComparator implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {
        return o1.getScore() < o2.getScore() ? 1 : (o1.getScore() > o2.getScore() ? -1 : 0);
    }
}
