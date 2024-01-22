package com.tunehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.Playlist;
import com.tunehub.repository.PlayListRepository;

@Service
public class PlayListServiceImpl implements PlayListService {


	@Autowired
	PlayListRepository repo;
	
	@Override
	public void addPlaylist(Playlist playlist) {
		
		repo.save(playlist);
		
	}

	@Override
	public List<Playlist> fetchAllPlaylist() {
		
		return repo.findAll();
	}

}
