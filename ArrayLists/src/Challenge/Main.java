package Challenge;

import java.util.ArrayList;

public class Main {


    /*
    Creating a song playlist program that runs in the console.
    To be added to the playlist, every song must be inside an album, which must be inside an array.
    You must be able to move to the previous song, to the next song, or to replay the song.
    You must also be able to remove songs from the playlist.
     */


    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        ArrayList<Album> albums = new ArrayList<Album>();

        albums.add(new Album());
        albums.add(new Album());
        albums.add(new Album());
        albums.get(0).addSong(new Song("Light up the night", 3.42));
        albums.get(0).addSong(new Song("Born to last", 4.35));
        albums.get(0).addSong(new Song("Born to last", 4.35));
        albums.get(0).addSong(new Song("Hold back the night", 6.21));
        albums.get(1).addSong(new Song("My name is Dark", 6.23));
        albums.get(1).addSong(new Song("Oblivion", 4.12));
        albums.get(1).addSong(new Song("Kill V Maim", 3.55));
        albums.get(2).addSong(new Song("Baka Mitai", 4.12));
        albums.get(2).addSong(new Song("Justice", 3.28));
        albums.get(2).addSong(new Song("24h Cinderella", 2.52));

        playlist.addSong( albums.get(2),0);
        playlist.addSong( albums.get(0),2);
        playlist.addSong(albums.get(1),0);
        playlist.addSong(albums.get(1),1);
        playlist.addSong( albums.get(0),0);
        playlist.addSong(albums.get(0),1);
        playlist.addSong(albums.get(1),9);

        playlist.printPlaylist();
        playlist.play();

    }


}
