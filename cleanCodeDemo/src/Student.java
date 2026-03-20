public class Student {
    public static final double PASSINGSCORE = 5.0;
    private int mathScore;
    private int physicsScore;
    private int chemistryScore;

    public double calculateGPA() {
        int totalScore = mathScore + physicsScore + chemistryScore;
        double agvrageStore = totalScore / 3.0;
        return agvrageStore;
    }

    public final void print(){
        System.out.println("ngu");
    }


    public boolean isPassed() {
        return (mathScore + physicsScore + chemistryScore) / 3.0 >= PASSINGSCORE;
    }
}