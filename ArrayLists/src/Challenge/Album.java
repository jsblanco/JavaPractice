package Challenge;

import java.util.ArrayList;

public class Album {
    private ArrayList<Song> tracklist;


    public Album() {
        this.tracklist = new ArrayList<Song>();
    }

    public ArrayList<Song> getTracklist() {
        return tracklist;
    }

    public Song getTrack(int index) {
        if (tracklist.size() >0 && (index >=0 && index < tracklist.size())) {
            return tracklist.get(index);
        }
        System.out.println("This album does not have a track number "+index);
        return null;
    }

    private boolean isSongAlreadyInTheAlbum(String songToAdd) {
        for (Song songInAlbum : this.tracklist) {
            if (songInAlbum.getTitle().equals((songToAdd))) {
                return true;
            }
        }
        return false;
    }

    public void addSong(Song song) {
        String songTitle = song.getTitle();
        if (!isSongAlreadyInTheAlbum(songTitle)) {
            tracklist.add(song);
        } else {
            System.out.println("Song " + songTitle + " is already in the album");
        }
    }

    public void addSong(int index, Song song) {
        tracklist.add(index, song);
    }

    public void removeSong(Song song) {
        tracklist.remove(song);
    }

    public void removeSong(int index) {
        tracklist.remove(index);
    }
}
