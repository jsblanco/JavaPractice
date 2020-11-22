public class Main {
    public static void main (String[] args){
        ImperialFist regulus = new ImperialFist("Regulus");
        DeathKorps hanns = new DeathKorps("Hanns");
        FireWarrior randomTau = new FireWarrior("Random fire warrior");

        regulus.rangedAttack();
        hanns.rangedAttack();
        randomTau.meleeAttack();
        regulus.meleeAttack();
        hanns.meleeAttack();
        randomTau.meleeAttack();
        regulus.chapterPrimarch();
        regulus.rubiconPrimatis();


        hanns.praiseTheEmperor();
        regulus.praiseTheEmperor();

        regulus.isLoyal();
    }
}
