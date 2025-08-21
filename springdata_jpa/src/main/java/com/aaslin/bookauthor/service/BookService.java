package com.aaslin.bookauthor.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aaslin.bookauthor.model.Author;
import com.aaslin.bookauthor.model.Book;
import com.aaslin.bookauthor.repository.AuthorRepository;
import com.aaslin.bookauthor.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;

	

	public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public List<Book> getBooksByAuthor(String authorName){
		return bookRepository.findBooksByAuthorName(authorName);
	}
	
	public List<Book> getBooksByTitle(String titlePart){
		 return bookRepository.findBooksByTitleContaining(titlePart);
	}
	

	@Transactional
	public Book createBooksForAuthor(Long authorId,String title,String genre) {
		Author author=authorRepository.findById(authorId).orElseThrow(()-> new RuntimeException("Author not found"));
		Book book=new Book();
		book.setAuthor(author);
		book.setTitle(title);
		book.setGenre(genre);
		return bookRepository.save(book);
	}
	
	public Page<Book> getBooksByGenre(String genre,Pageable pageable){
		return bookRepository.findByGenre(genre, pageable);
	}


	public List<Book> getAllBooksSorted(Sort sort) {
		return bookRepository.findAll(sort);
	}

}
