package com.aaslin.setterInjection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
private String  bookName;

public String getBookName() {
	return bookName;
}

@Value("Alice in wonderland....")
public void setBookName(String bookName) {
	this.bookName = bookName;
}

}
