package behaviourClasses;

import Interfaces.IFlyBehaviour;

public class FlyingIsImpossible implements IFlyBehaviour {
    @Override
    public void fly() {
        System.out.println("No puedo volar!");
    }
}
