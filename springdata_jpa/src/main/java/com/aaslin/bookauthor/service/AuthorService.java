package com.aaslin.bookauthor.service;

import java.util.List;

import com.aaslin.bookauthor.model.Author;
import org.springframework.stereotype.Service;
import com.aaslin.bookauthor.repository.AuthorRepository;

@Service
public class AuthorService {
	private final AuthorRepository authorRepository;

	public AuthorService(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}
	
	public List<Author> getAuthorByStartingLetter(String letter){
		return authorRepository.findAuthorsByNameStartingWith(letter);
	}
	public List<Author> findAuthorsWithMoreThanNBooks(int count){
		return authorRepository.findAuthorsWithMoreThanNBooks(count);
	}
}
