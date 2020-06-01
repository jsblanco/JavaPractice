package Challenge;

import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {
    private LinkedList<Song> playlist;


    public Playlist() {
        this.playlist = new LinkedList();
    }

    public ListIterator<Song> listIterator(){
        return playlist.listIterator();
    }

    public void addSong(Album album, int song){
        playlist.add(album.getTrack(song));
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

}
