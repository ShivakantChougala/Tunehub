package com.tunehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.Song;
import com.tunehub.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService{
@Autowired

 SongRepository repo;

	@Override
	public void addSong(Song song) {
		
		repo.save(song);
		
		
	}

	@Override
	public List<Song> viewSongs() {
		
		return repo.findAll();
	}

	@Override
	public boolean songExists(String name) {
		
		
		Song song =repo.getByName(name);
		if(song ==null) {
		return false;
	}
		else {
			return true;
		}

}

	@Override
	public void updateSong(Song song) {
		repo.save(song);
		
	}
}
