public class Main {

    public static void main(String[] args){
        Playstation playDeJorge= new Playstation();
        //Al ser una clase embedida dentro de otra clase, solo puedo crear
        //instancias de la clase hija dentro de instancias de la clase madre
        Playstation.Game gwent = playDeJorge.new Game("Gwent: the Witcher Card Game");
        //Sino, como en este código, me fallará:
        //Playstation.Game failure = new Playstation.Game("Fallout 76");
        System.out.println(gwent.getTitle());

        //En cualquier caso, normalmente estas clases suelen ser privadas.
        // y se crean en funciones del padre, no con el constructor:
        playDeJorge.addGameToCollection("Destiny 2: Shadowkeep");
        System.out.println(playDeJorge.games.get(0).getTitle());
        System.out.println(playDeJorge.games.get(1).getTitle());
    }
}
