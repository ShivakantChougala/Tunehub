package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entity.Playlist;
import com.tunehub.entity.Song;
import com.tunehub.service.PlayListService;
import com.tunehub.service.SongService;

@Controller
public class PlayListController {

	@Autowired
	SongService SongService;
	@Autowired
	PlayListService  playlistService;
	@GetMapping("/createPlaylist")

public String createPlaylist(Model model) {
		
		List<Song> songList=SongService.viewSongs();
		
		model.addAttribute("songs" , songList);
		
		
		
		return "createPlaylist";
	}
	
	@PostMapping("/addPlaylist")
	
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		
		
		playlistService.addPlaylist(playlist);
		List<Song> songlist=playlist.getSongs();
		
		for(Song s: songlist) {
			s.getPlaylist().add(playlist); 
			SongService.updateSong(s);
		}
		return "adminHome";
		
	}
	
	@GetMapping("/viewPlaylist")
	
	public String viewPlaylist(Model model) {
		
		List<Playlist> allPlaylists=playlistService.fetchAllPlaylist();
		model.addAttribute("allPlaylists" ,allPlaylists);
		return "displayPlayList";
	}



}
