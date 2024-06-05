package lab8;

import java.util.*;
//ALREADY IMPLEMENTED; DO NOT MODIFY
//NO NEED TO SUBMIT THIS FILE

/**
 * The class defines a simple structure called Song,
 * capable of storing the following information about a single song:
 * <p> artist</p>
 * <p> title</p>
 * <p> album</p>
 * <p>price</p>
 * <p>release year</p>
 * <p>length of the song in seconds </p>
 * 
 *
 */
public class Song {
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private String songArtist;
	private String songTitle;
	private String songAlbum;
	private double songPrice;
	private int songYear;
	private int songLength; // Length in seconds

	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public Song(String songTitle, String songArtist, String songAlbum,
			int songYear, int songLength, double songPrice) {

		this.songArtist = songArtist;
		this.songTitle = songTitle;
		this.songAlbum = songAlbum;
		this.songPrice = songPrice; 
		this.songYear = songYear;
		this.songLength = songLength; // length in seconds
	}
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public String getSongArtist() {
		return songArtist;
	}
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public String getSongTitle() {
		return songTitle;
	}
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public String getSongAlbum() {
		return songAlbum;
	}
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public void setSongAlbum(String songAlbum) {
		this.songAlbum = songAlbum;
	}

	public double getSongPrice() {
		return songPrice;
	}
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public void setSongPrice(double songPrice) {
		this.songPrice = songPrice;
	}
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public int getSongYear() {
		return songYear;
	}
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public void setSongYear(int songYear) {
		this.songYear = songYear;
	}

	public int getSongLength() {
		return songLength;
	}
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public void setSongLength(int songLength) {
		this.songLength = songLength;
	}
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	@Override
	public String toString() {
		return String.format("Song|%-20s|%-15s|%-20s|%6s|%d:%02d|%6.2f", this.songTitle, this.songArtist,
				this.songAlbum, this.songYear > 0 ? String.format("%d", this.songYear) : "", this.songLength / 60,
				this.songLength % 60, this.songPrice);
	}
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	@Override
	public int hashCode() {
		return Objects.hash(songAlbum, songArtist, songLength, songPrice, songTitle, songYear);
	}
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		return Objects.equals(songAlbum, other.songAlbum) && Objects.equals(songArtist, other.songArtist)
				&& songLength == other.songLength
				&& Double.doubleToLongBits(songPrice) == Double.doubleToLongBits(other.songPrice)
				&& Objects.equals(songTitle, other.songTitle) && songYear == other.songYear;
	}

	
	
}
