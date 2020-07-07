package Challenge;

import java.util.ArrayList;

public class Album {
    private SongList tracklist;


    public Album() {
        this.tracklist = new SongList();
    }

    public ArrayList<Song> getTracklist() {
        return this.tracklist.getTrackList();
    }

    public Song getTrack(int index) {
        if (tracklist.getTrackList().size() > 0 && (index >= 0 && index < tracklist.getTrackList().size())) {
            return tracklist.getTrackList().get(index);
        }
        System.out.println("This album does not have a track number " + index);
        return null;
    }

    public void addSong(Song song) {
        this.tracklist.addSong(song);
    }


    public void removeSong(Song song) {
        tracklist.removeSong(song);
    }

    public void removeSong(int index) {
        tracklist.removeSong(index);
    }

    private class SongList {
        ArrayList<Song> trackList;

        public SongList() {
            this.trackList = new ArrayList<Song>();
        }

        public void addSong(Song song) {
            String songTitle = song.getTitle();
            if (!isSongAlreadyInTheAlbum(songTitle)) {
                this.trackList.add(song);
                System.out.println("Song " + songTitle + " was added to the album");
            } else {
                System.out.println("Song " + songTitle + " is already in the album");
            }

        }

        public void removeSong(Song song) {
            this.trackList.remove(song);
        }

        public void removeSong(int index) {
            this.trackList.remove(index);
        }

        public ArrayList<Song> getTrackList() {
            return this.trackList;
        }

        private boolean isSongAlreadyInTheAlbum(String songToAdd) {
            for (Song songInAlbum : this.trackList) {
                if (songInAlbum.getTitle().equals((songToAdd))) {
                    return true;
                }
            }
            return false;
        }
    }
}
