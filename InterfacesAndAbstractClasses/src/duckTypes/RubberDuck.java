package duckTypes;

import behaviourClasses.FlyingIsImpossible;
import behaviourClasses.SquealCuack;

public class RubberDuck extends Duck{
    public RubberDuck() {
        flyBehaviour= new FlyingIsImpossible();
        quackBehaviour = new SquealCuack();
    }
}
