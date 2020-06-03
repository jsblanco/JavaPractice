package duckTypes;

import Interfaces.IQuackBehaviour;
import Interfaces.IFlyBehaviour;

public class Duck {
    IFlyBehaviour flyBehaviour;
    IQuackBehaviour quackBehaviour;

    public void performQuack(){
        quackBehaviour.cuack();
    }

    public void tryToFly(){
        flyBehaviour.fly();
    }

}
