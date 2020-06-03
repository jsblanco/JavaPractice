package duckTypes;

import behaviourClasses.FlyingIsImpossible;
import behaviourClasses.NoQuack;

public class DeadDuck extends Duck{
    public DeadDuck() {
        flyBehaviour = new FlyingIsImpossible();
        quackBehaviour = new NoQuack();
    }
}
