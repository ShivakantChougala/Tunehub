package com.tunehub.service;

import java.util.List;

import com.tunehub.entity.Song;

public interface SongService {

public	void addSong(Song song);

	public List<Song> viewSongs();

	public boolean songExists(String name);

	public void updateSong(Song song);

}
