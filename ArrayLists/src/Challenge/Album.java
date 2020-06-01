package Challenge;

import java.util.LinkedList;

public class Album {
    private LinkedList<Song> tracklist;


    public Album() {
        this.tracklist = new LinkedList<Song>();
    }

    public LinkedList<Song> getTracklist() {
        return tracklist;
    }

    public Song getTrack(int index) {
        return tracklist.get(index);
    }

    public void addSong(Song song){
        tracklist.add(song);
    }

    public void addSong(int index, Song song){
        tracklist.add(index, song);
    }

    public void removeSong(Song song){
        tracklist.remove(song);
    }

    public void removeSong(int index){
        tracklist.remove(index);
    }
}
