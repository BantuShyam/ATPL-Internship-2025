package com.aaslin.setterInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Library {
	private Book book;
	@Autowired
	public void setBook(Book book) {
		this.book = book;
	}
	public void  show() {
		System.out.println("Book Name is "+book.getBookName());
	}

}
