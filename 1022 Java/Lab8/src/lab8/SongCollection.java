package lab8;

import java.util.*;

public class SongCollection {
	
	
	// TODO: Your implementation starts here
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	private String ListName;
	private List<Song> ListofSongs;
	
	public SongCollection(String str) {
		this.ListName = str;
		this.ListofSongs = new ArrayList<Song>();
		
	}
	
	public SongCollection(SongCollection collection) {
		this.ListName = collection.ListName;
		this.ListofSongs = new ArrayList<Song>();
		
		List<Song> newlist = collection.ListofSongs;
		
		for(int i = 0; i < newlist.size();i++) {
			this.ListofSongs.add(newlist.get(i));
		}
	}

	public String getListName() {
		return ListName;
	}

	public void setListName(String listName) {
		ListName = listName;
	}

	public List<Song> getListofSongs() {
		return ListofSongs;
	}

	public void addSongs(List<Song> songs) {
		for(int i = 0; i < songs.size(); i++) {
			this.ListofSongs.add(songs.get(i));
		}
	}
	public void removeSong(Song song) {
		if(this.ListofSongs.contains(song)) {
			this.ListofSongs.remove(song);
		}
	}
	public boolean contains(Song song) {
		if(this.ListofSongs.contains(song)) {
			return true;
		}
		return false;
	}
	
	public boolean inSongCollection(String name) {
		for(int i = 0; i < this.ListofSongs.size(); i++) {
			Song song = this.ListofSongs.get(i);
			String artist = song.getSongArtist();
			if (name == artist) {
				return true;
			}
		}
		
		return false;
	}
	
	public List<Song> getSongsforArtist(String name) {
		List<Song> byartist = new ArrayList<Song>();

		for(int i = 0; i < this.ListofSongs.size(); i++) {
			Song song = this.ListofSongs.get(i);
			String artist = song.getSongArtist();
			if (name == artist) {
				byartist.add(song);
			}
		}
		return byartist;
	}
	public String totalListeningTime() {
		int time = 0;
		for(int i = 0; i < this.ListofSongs.size(); i++) {
			Song song = this.ListofSongs.get(i);
			int duration = song.getSongLength();
			time += duration;
		}
		String result = "Total Listening Time: ";
		
		int hours = time/3600;
		int minutes = (time%3600)/60;
		int seconds = time%60;
		
		return String.format(result + "%d:%02d:%02d", hours, minutes, seconds);
	}

}
