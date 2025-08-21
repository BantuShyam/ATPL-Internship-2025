package com.aaslin.bookauthor.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books_shyam")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String title;
	private String genre;
	
	@ManyToOne
	@JoinColumn(name="author_id",nullable=false)
	@JsonBackReference
	private Author author;
	
	@ManyToMany
	@JoinTable(name="book_publisher",joinColumns=@JoinColumn(name="book_id"),inverseJoinColumns=@JoinColumn(name="publisher_id"))
	private List<Publisher> publishers=new ArrayList<>();
	public List<Publisher> getPublishers() {
		return publishers;
	}
	public void setPublishers(List<Publisher> publishers) {
		this.publishers = publishers;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
}
