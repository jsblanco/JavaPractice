import java.util.ArrayList;

public class Playstation {
    public ArrayList<Game> games;
    private int gamesCollection;

    public Playstation() {
        this.games = new ArrayList<>();
        Game yakuza = new Game("Yakuza 0");
        this.games.add(yakuza);
        this.gamesCollection = this.games.size();
    }

    public void addGameToCollection(String title){
    this.games.add(new Game(title));
    }

    //Para el ejemplo está Public, pero suelen ser privadas
    public class Game {
        private String title;

        public Game(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}
