public class Main {

    public static void main(String[] args){
        Case myCase = new Case("CoolproXL", "Cooler Master", "UranusPSU", new Dimensions(12,2,4));
        Monitor myMonitor = new Monitor("FX420", "HannsG", 24, new Resolution(1080, 1920));
        Motherboard myMotherboard = new Motherboard("B48", "ASrock", 4, 8, 124);
        Computer myComputer = new Computer(myCase, myMonitor, myMotherboard);

        //myComputer.monitor.drawPixelAt(1,43,"blue");
        //No puedes acceder a claves de una clase a no ser que sean públicas.
        //Una alternativa es usar una función getter:
        myComputer.getMonitor().drawPixelAt(1,43,"blue");

        //En cambio, desde dentro de la clase en sí, sí es posible acceder a claves privadas directamente:
        myComputer.powerUp();
    }
}
