class Movie{
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String plot(){
        return "... Well, actually I've got no idea what this movie is about, sorry";
    }
}

class Terminator2 extends Movie {
    public Terminator2(){
        super("Terminator 2");
    }
    @Override
    public String plot(){
        return "the T-800 protecting John Connor instead of hunting him down";
    }
}

class DieHard3 extends Movie {
    public DieHard3(){
        super("Die Hard 3");
    }
    @Override
    public String plot() {
        return "John McLane and Zeus teaming up to fight Fort Knox assault";
    }
}

class Kingsman extends Movie{
    public Kingsman(){
        super("Kingsman");
    }
    @Override
    public String plot() {
        return "very brittish spies fighting a baddly dressed Samuel L Jackson";
    }
}

class MadMaxFuryRoad extends Movie{
    public MadMaxFuryRoad(){
        super("Mad Max: Fury Road");
    }
    @Override
    public String plot() {
        return "Mad Max in a muzzle protecting concuvines from a muzzled COVID-19 patient";
    }
}

class Antena3SaturdayEveningFlick extends Movie{
    public Antena3SaturdayEveningFlick(){
        super("some Antena 3 saturday afternoon flick");
    }
}

public class Main {

    public static void main(String[] args){


        for (int i=1; i<11; i++){
            Movie movie = randomMovie();
            System.out.println("Random movie number "+i+" is "+movie.getName()+", which is about "+movie.plot());
        }


    }



    public static Movie randomMovie(){
        int randomNumber =(int) (Math.random()*5)+1;
        System.out.println("Random number was "+randomNumber);

        switch (randomNumber){
            case 1:
                return new Terminator2();
            case 2:
                return new DieHard3();
            case 3:
                return new Kingsman();
            case 4:
                return new MadMaxFuryRoad();
            case 5:
                return new Antena3SaturdayEveningFlick();
            default:
                return null;
        }
    }

}
