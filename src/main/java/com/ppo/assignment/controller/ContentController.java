package com.ppo.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppo.assignment.model.Content;
import com.ppo.assignment.service.ContentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContentController {
	@Autowired
	ContentService contentService;

	@GetMapping("/getContentByTitle/{title}")
	private List<Content> getAllMatchingContent(@PathVariable("title") String title) {
		return contentService.getContentByMatchingTitle(title, "0");

	}
	
	@GetMapping("/getContent/{id}")
	private Content getContent(@PathVariable("id") String id) {
		return contentService.getContentById(id);

	}
	

}
