package DemoInterface;

public class  Bird extends Animal implements Flyable{
    @Override
    public void fly() {
        System.out.println("Bay di chim");
    }

    @Override
    public void makeSound() {
        System.out.println("chim chim");
    }
}
