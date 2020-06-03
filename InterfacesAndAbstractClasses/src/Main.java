import duckTypes.DeadDuck;
import duckTypes.MallardDuck;
import duckTypes.RubberDuck;

public class Main {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        DeadDuck deadDuck = new DeadDuck();
        RubberDuck rubberDuck = new RubberDuck();

        System.out.println("##############\nMallard duck:\n##############");
        mallardDuck.tryToFly();
        mallardDuck.performQuack();
        System.out.println("\n##############\nDead duck:\n##############");
        deadDuck.tryToFly();
        deadDuck.performQuack();
        System.out.println("\n##############\nRubber duck: \n##############");
        rubberDuck.tryToFly();
        rubberDuck.performQuack();
    }
}
