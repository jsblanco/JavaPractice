package duckTypes;

import behaviourClasses.FlyWithWings;
import behaviourClasses.NormalQuacking;

public class MallardDuck extends Duck{

    public MallardDuck() {
        flyBehaviour = new FlyWithWings();
        quackBehaviour= new NormalQuacking();
    }
}
