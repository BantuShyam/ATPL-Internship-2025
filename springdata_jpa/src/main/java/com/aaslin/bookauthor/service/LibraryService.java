package com.aaslin.bookauthor.service;

import java.util.List;

import com.aaslin.bookauthor.model.Author;
import com.aaslin.bookauthor.model.Book;
import com.aaslin.bookauthor.repository.AuthorRepository;
import com.aaslin.bookauthor.repository.BookRepository;

public class LibraryService {
	private final AuthorRepository authorRepo;
	private final BookRepository bookRepo;
	public LibraryService(AuthorRepository authorRepo, BookRepository bookRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
	}
	
	//create
	public Author createAuthor(Author author) {
		return authorRepo.save(author);
	}
	
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}

	//display
	public List<Author> getAllAuthors(){
		return authorRepo.findAll();
	}
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	//update
	public Author updateAuthor(Long id,String newName) {
		Author author=authorRepo.findById(id).orElseThrow();
		author.setName(newName);
		return authorRepo.save(author);
	}
	
	public Book updateBook(Long id,String newTitle) {
		Book book=bookRepo.findById(id).orElseThrow();
		book.setTitle(newTitle);
		return bookRepo.save(book);
	}
	
	//delete
	public void deleteAuthor(Long id) {
		authorRepo.deleteById(id);
	}
	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
}
