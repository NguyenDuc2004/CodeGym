public class BodyMassIndex {
    private double weight;
    private double height;

    public BodyMassIndex(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }
    public void checkBody(){
        double bmi = weight / Math.pow(height, 2);

        System.out.printf("%-20s%s", "BMI", "Phân loại\n");

        if (bmi < 18) {
            System.out.printf("%-20.2f%s", bmi, "Thiếu cân");
        } else if (bmi < 25.0) {
            System.out.printf("%-20.2f%s", bmi, "Bình thường");
        } else if (bmi < 30.0) {
            System.out.printf("%-20.2f%s", bmi, "Thừa cân");
        } else {
            System.out.printf("%-20.2f%s", bmi, "Béo phì");
        }
    }

}
