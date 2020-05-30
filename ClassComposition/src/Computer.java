public class Computer {

    private Case computerCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public Computer(Case computerCase, Monitor monitor, Motherboard motherboard) {
        this.computerCase = computerCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp(){
        computerCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo(){
        monitor.drawPixelAt(13,37,"bile green");
    }


    public Monitor getMonitor() {
        return monitor;
    }
}
