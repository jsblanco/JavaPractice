package behaviourClasses;

import Interfaces.IQuackBehaviour;

public class SquealCuack implements IQuackBehaviour {
    @Override
    public void cuack() {
        System.out.println("Los patos de goma hacen ruido, pero no cuack");
    }
}
