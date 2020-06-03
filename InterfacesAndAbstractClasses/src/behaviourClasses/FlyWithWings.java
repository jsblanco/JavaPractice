package behaviourClasses;

import Interfaces.IFlyBehaviour;

public class FlyWithWings  implements IFlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Vuela alto pajarillo");
    }
}
