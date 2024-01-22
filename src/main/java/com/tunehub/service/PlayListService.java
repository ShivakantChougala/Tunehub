package com.tunehub.service;

import java.util.List;

import com.tunehub.entity.Playlist;

public interface PlayListService {

public 	void addPlaylist(Playlist playlist);

public List<Playlist> fetchAllPlaylist();

}
