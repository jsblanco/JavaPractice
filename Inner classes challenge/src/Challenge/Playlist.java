package Challenge;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {
    private LinkedList<Song> playlist;


    public Playlist() {
        this.playlist = new LinkedList();
    }

    public ListIterator<Song> listIterator(){
        return playlist.listIterator();
    }

    public void addSong(Album album, int song){

        if (album.getTrack(song) != null) {
            playlist.add(album.getTrack(song));
        } else {
            System.out.println("Song was not added to playlist");
        };
    }

    public Song getSong(int index){
        return playlist.get(index);
    }

    public int size(){
        return playlist.size();
    }

    public void printPlaylist(){
        System.out.println("Current playlist: \n##############################");
        for (int i=0; i<playlist.size(); i++){
            System.out.println("Song #"+(i+1)+": "+playlist.get(i).getTitle()+" ("+playlist.get(i).getDuration()+")");
        }
        System.out.println("##############################");
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> iterator = this.playlist.listIterator();
        boolean forward = true;
        boolean end = false;

        if (iterator.hasNext()) {
            showMenu();
            System.out.println("Now playing: " + getSong(iterator.nextIndex()).getTitle());
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
                        System.out.println("Playing the previous song: " +  getSong(iterator.previousIndex()).getTitle());
                        iterator.previous();
                    } else {
                        System.out.println("You are at the start of your playlist");
                    }
                    break;
                case 2:
                    if (!forward){
                        if (iterator.hasNext()) {
                            System.out.println("Playing the next song: " +  getSong(iterator.nextIndex()).getTitle());
                        } else {
                            System.out.println("You have reached the end of your playlist");
                        }
                    } else {
                        if (iterator.hasPrevious()) {
                            System.out.println("Restarting the song: " +  getSong(iterator.previousIndex()).getTitle());
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
                        System.out.println("Playing the next song: " +  getSong(iterator.nextIndex()).getTitle());
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
                    printPlaylist();
                    break;
                case 6:
                    showMenu();
                    break;
            }
        }


    }


    private void showMenu() {
        System.out.println("Welcome to your playlist. You currently have "+playlist.size() + " songs queued.");
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
