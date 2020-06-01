package Challenge;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

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
        albums.get(0).addSong(new Song("The hounds", 4.35));
        albums.get(0).addSong(new Song("Hold back the night", 6.21));
        albums.get(1).addSong(new Song("My name is Dark", 6.23));
        albums.get(1).addSong(new Song("Oblivion", 4.12));
        albums.get(1).addSong(new Song("Kill V Maim", 3.55));
        albums.get(2).addSong(new Song("Baka Mitai", 4.12));
        albums.get(2).addSong(new Song("Justice", 3.28));
        albums.get(2).addSong(new Song("24h Cinderella", 2.52));

        addSongToPlaylist(playlist, albums, 2,0);
        addSongToPlaylist(playlist, albums, 0,2);
        addSongToPlaylist(playlist, albums, 1,2);
        addSongToPlaylist(playlist, albums, 1,1);
        addSongToPlaylist(playlist, albums, 0,0);
        addSongToPlaylist(playlist, albums, 2,1);
        addSongToPlaylist(playlist, albums, 9,9);

        playlist.printPlaylist();
        playPlaylist(playlist);

    }

    private static void addSongToPlaylist(Playlist playlist, ArrayList albums, int album, int song){
        if (album>-1&& albums.size()>album) {
            Album thisAlbum = (Album) albums.get(album);
            if (song>-1 && thisAlbum.getTracklist().size()> song)
            playlist.addSong(thisAlbum, song);
        }
    }

    private static void playPlaylist(Playlist playlist) {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> iterator = playlist.listIterator();
        boolean forward = true;
        boolean end = false;

        if (iterator.hasNext()) {
            showMenu(playlist);
            System.out.println("Now playing: " + playlist.getSong(iterator.nextIndex()).getTitle());
            iterator.next();
        } else {
            System.out.println("Your playlist is empty, please add some songs to your playlist first.");
            end = true;
        }

        while (!end) {
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    System.out.println("Stopping playlist");
                    end = true;
                    break;
                case 1:
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        forward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Playing the previous song: " +  playlist.getSong(iterator.previousIndex()).getTitle());
                        iterator.previous();
                    } else {
                        System.out.println("You are at the start of your playlist");
                    }
                    break;
                case 2:
                    if (!forward){
                        if (iterator.hasNext()) {
                            System.out.println("Playing the next song: " +  playlist.getSong(iterator.nextIndex()).getTitle());
                        } else {
                            System.out.println("You have reached the end of your playlist");
                        }
                    } else {
                    if (iterator.hasPrevious()) {
                        System.out.println("Restarting the song: " +  playlist.getSong(iterator.previousIndex()).getTitle());
                    } else {
                        System.out.println("You are at the start of your playlist");
                    }}
                    break;
                case 3:
                    if (!forward) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        forward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Playing the next song: " +  playlist.getSong(iterator.nextIndex()).getTitle());
                        iterator.next();
                    } else {
                        System.out.println("You have reached the end of your playlist");
                    }
                    break;
                case 4:
                    System.out.println("Removed song from the playlist");
                    iterator.remove();
                    break;
                case 5:
                    playlist.printPlaylist();
                    break;
                case 6:
                    showMenu(playlist);
                    break;
            }
        }


    }


    private static void showMenu(Playlist list) {
        System.out.println("Welcome to your playlist. You currently have "+list.size() + " songs queued.");
        System.out.println("Please type what you wish to do:");
        System.out.println("0- Stop playlist");
        System.out.println("1- Play the previous song");
        System.out.println("2- Replay the song");
        System.out.println("3- Play the next song");
        System.out.println("4- Remove song from the playlist");
        System.out.println("5- Show the whole playlist");
        System.out.println("6- Show this menu again");
    }

}
