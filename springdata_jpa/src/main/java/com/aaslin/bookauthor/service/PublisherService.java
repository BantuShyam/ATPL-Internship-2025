package com.aaslin.bookauthor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aaslin.bookauthor.model.Book;
import com.aaslin.bookauthor.model.Publisher;
import com.aaslin.bookauthor.repository.BookRepository;
import com.aaslin.bookauthor.repository.PublisherRepository;

@Service
public class PublisherService {

	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	public PublisherService(BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	
	//create
	public Publisher createPublisher(Publisher publisher) {
		return publisherRepository.save(publisher);
	}
	
	public Book assignPublisherToBook(Long bookId,Long publisherId) {
		Book book=bookRepository.findById(bookId).orElseThrow(()-> new RuntimeException("Book not found"));
		Publisher publisher=publisherRepository.findById(publisherId).orElseThrow(()-> new RuntimeException("Publisher not found"));
		
		book.getPublishers().add(publisher);
		publisher.getBooks().add(book);
		return bookRepository.save(book);
	}
	
	public List<Book> getBooksByPublisher(Long publisherId){
		Publisher publisher=publisherRepository.findById(publisherId).orElseThrow(()-> new RuntimeException("Publisher not found"));
		return publisher.getBooks();
	}
	
	public List<Publisher> getPublisherByBooks(Long bookId){
		Book book=bookRepository.findById(bookId).orElseThrow(()-> new RuntimeException("Book not found"));
		return book.getPublishers();
	}

}
