public class Student {
    private int mathScore;
    private int physicsScore;
    private int chemistryScore;

    public double calculateGPA() {
        return (mathScore + physicsScore + chemistryScore) / 3.0;
    }

    public boolean isPassed() {
        return (mathScore + physicsScore + chemistryScore) / 3.0 >= 5.0;
    }
}