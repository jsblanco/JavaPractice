package behaviourClasses;

import Interfaces.IQuackBehaviour;

public class NoQuack  implements IQuackBehaviour {
    @Override
    public void cuack() {
        System.out.println("Silencio absoluto");
    }
}
