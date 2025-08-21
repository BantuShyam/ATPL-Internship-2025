package com.aaslin.bookauthor.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.bookauthor.model.Author;
import com.aaslin.bookauthor.model.Book;
import com.aaslin.bookauthor.service.AuthorService;
import com.aaslin.bookauthor.service.BookService;

@RestController
@RequestMapping("/api")
public class BookAuthorController {

	private final AuthorService authorService;
	private final BookService bookService;
	public BookAuthorController(AuthorService authorService, BookService bookService) {
		super();
		this.authorService = authorService;
		this.bookService = bookService;
	}
	
	@GetMapping("/books/author")
	public List<Book> getBooksByAuthor(@RequestParam String AuthorName){
		return bookService.getBooksByAuthor(AuthorName);
	}
	
	@GetMapping("/books/title")
	public List<Book> getBooksByTitle(@RequestParam String title){
		return bookService.getBooksByTitle(title);
	}
	
	@GetMapping("/authors/starts")
	public List<Author> getAuthorsByStartingLetter(@RequestParam String letter){
		return authorService.getAuthorByStartingLetter(letter);
	}
	
	@GetMapping("/authors/moreThan")
	public List<Author> getAuthorsWithMoreThanNBooks(@RequestParam int count){
		return authorService.findAuthorsWithMoreThanNBooks(count);
	}
	
	@PostMapping("/authors/{authorId}/books")
	public ResponseEntity<Book> createBook(@PathVariable Long authorId,@RequestBody Book bookRequest){
		
		Book createBook=bookService.createBooksForAuthor(authorId, bookRequest.getTitle(), bookRequest.getGenre());
		return ResponseEntity.ok(createBook);
		
	}
	
	@GetMapping("/books/genre")
	public 	Page<Book> getBooksByGenre(@RequestParam String genre,@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="5") int size){
		PageRequest pageable=PageRequest.of(page, size);
		return bookService.getBooksByGenre(genre,pageable);
	}
	
	@GetMapping("/books/sorted")
	public List<Book> getBooksSorted(@RequestParam(defaultValue="asc") String order){
		Sort sort=order.equalsIgnoreCase("desc")? Sort.by(Sort.Order.desc("genre")).descending(): Sort.by(Sort.Order.desc("genre")).ascending();
		return bookService.getAllBooksSorted(sort);
		}
}
