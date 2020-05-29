public class Witcher {

    private int swords;
    private int potions;
    private String name;
    private String school;
    private String horseName;


    public void setData(String name, String school, String horseName, int swords, int potions){
        this.name = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
        this.horseName = horseName.substring(0,1).toUpperCase()+horseName.substring(1).toLowerCase();
        this.potions = potions;
        this.swords = swords;

        switch (school.toLowerCase()) {
            case "wolf":case "cat":case "bear":case "griffin":
            this.school = school.substring(0,1).toUpperCase()+school.substring(1).toLowerCase();
            break;
            default:
                this.school = "Unknown";
                break;
        }
    }

    public void printWitcherData(){
        System.out.println("Witcher "+this.name+" from the school of the "+this.school+" has "+this.swords+" swords, "+
                this.potions+" potions, and rides on a horse called "+this.horseName+".");
        if (this.name == "Lambert") System.out.println("Also, he's a prick.");
    }
}
