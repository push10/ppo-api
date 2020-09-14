package com.ppo.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppo.assignment.model.Content;
import com.ppo.assignment.repo.ContentJdbcRepository;

@Service
public class ContentServiceImpl implements ContentService{
	@Autowired
	ContentJdbcRepository contentRepo;
	
	@Override
	public List<Content> getContentByMatchingTitle(String title, String offset) {
		// TODO Auto-generated method stub
		return contentRepo.findAllByTitle(title, offset);
	}

	@Override
	public Content getContentById(String id) {
		// TODO Auto-generated method stub
		return contentRepo.findById(Integer.parseInt(id));
	}
}
