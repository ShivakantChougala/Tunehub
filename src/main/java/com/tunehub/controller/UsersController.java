package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.entity.Song;
import com.tunehub.entity.Users;
import com.tunehub.service.SongService;
import com.tunehub.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	
	@Autowired
	UsersService service;
	
	@Autowired
	SongService songService;
	
	@PostMapping("/registers1")
	
	
	public String addUser(@ModelAttribute Users user)
	{
		
		boolean userStatus=service.emailExists(user.getEmail());
		
		if(userStatus==false) {
		service.addUser(user);
		System.out.println("user added");
		}
		
		else {
			System.out.println("user already added");
		}
		return "home";
	}
	
	//
@PostMapping("/validate")
	
	public String validate(@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session , Model model) {
	
		if(service.validateUser(email,password)== true) {
			String role =service.getRole(email);
			
			session.setAttribute("email", email);
			
			if(role.equals("admin")) {
			return "adminHome";
			
			//return "home";
		}
		else {
			Users user = service.getUser(email);
			
			boolean userStatus=user.isPremium();
			
			List<Song> songList=songService.viewSongs();
			model.addAttribute("songs" , songList);
			
			model.addAttribute("isPremium", userStatus);
			
				return "customerHome";
		}
		}
		else {
			return "login";
		}
	}

@GetMapping("/logout")

public String logout(HttpSession session) {
	
	return "login";
}
	
	
	
	

}
 
	