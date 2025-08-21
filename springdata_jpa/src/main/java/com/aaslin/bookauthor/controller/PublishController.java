package com.aaslin.bookauthor.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.bookauthor.model.Book;
import com.aaslin.bookauthor.model.Publisher;
import com.aaslin.bookauthor.service.PublisherService;

@RestController
@RequestMapping("/publishers")
public class PublishController {

	private final PublisherService publisherService;

	public PublishController(PublisherService publisherService) {
		super();
		this.publisherService = publisherService;
	}
	
	@PostMapping
	public Publisher createPublisher(@RequestBody Publisher publisher) {
		return publisherService.createPublisher(publisher);
	}
	
	
	@PostMapping("/{publisherId}/books/{bookId}")
	public Book assignPublisherToBook(@PathVariable Long publisherId,@PathVariable Long bookId) {
		return publisherService.assignPublisherToBook(bookId, publisherId);
	}
	
	
	@GetMapping("/{publisherId}/books")
	public List<Book> getBooksByPublisher(@PathVariable Long publisherId){
		return publisherService.getBooksByPublisher(publisherId);
	}
	
	@GetMapping("/books/{bookId}")
	public List<Publisher> getPublisherByBooks(@PathVariable Long bookId){
		return publisherService.getPublisherByBooks(bookId);
	}
}
