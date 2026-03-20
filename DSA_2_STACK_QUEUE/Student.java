public class Student implements Comparable<Student>{
    private String name;
    private double score;

    public Student() {
    }

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + '\t' + score;
    }

    @Override
    public int compareTo(Student o){
        return this.score > o.score ? -1 : (this.score < o.score ? 1 : 0);
    }
}
