package com.aaslin.multipleDependency;

public class University {
	private String universityName;
	private Library library;
	private Faculty faculty;
	public University(Library library, Faculty faculty) {
		super();
		this.library = library;
		this.faculty = faculty;
	}
	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String toString() {
		return "University has a faculty"+faculty.getFaculty_name()+" and teaches the comic book of "+library.getBookName();
	}
	
}
