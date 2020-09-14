package com.ppo.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ppo.assignment.model.Content;

@Service
public interface ContentService {
	List<Content> getContentByMatchingTitle(String title, String offset);
	
	Content getContentById(String id);
}
