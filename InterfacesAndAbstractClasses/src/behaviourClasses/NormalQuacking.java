package behaviourClasses;

import Interfaces.IQuackBehaviour;

public class NormalQuacking implements IQuackBehaviour {
    @Override
    public void cuack() {
        System.out.println("Cuack cuack mortherfucker");
    }
}
