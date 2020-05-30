public class Motherboard {
    private String model;
    private String manifacturer;
    private int ramSlots;
    private int cardSlots;
    private int bios;

    public Motherboard(String model, String manifacturer, int ramSlots, int cardSlots, int bios) {
        this.model = model;
        this.manifacturer = manifacturer;
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }

    public void loadProgram(String programName){
        System.out.println(programName+" is now loading.");
    }

    public String getModel() {
        return model;
    }

    public String getManifacturer() {
        return manifacturer;
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public int getCardSlots() {
        return cardSlots;
    }

    public int getBios() {
        return bios;
    }
}
