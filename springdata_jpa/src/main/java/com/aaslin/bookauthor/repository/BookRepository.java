package com.aaslin.bookauthor.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aaslin.bookauthor.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

	
	@Query("select b from Book b where b.author.name= :authorName")
	List<Book> findBooksByAuthorName(@Param("authorName") String authorName);
	
	@Query("select b from Book b where lower(b.title) like lower(concat('%', :titlePart,'%'))")
	List<Book> findBooksByTitleContaining(@Param("titlePart") String titlePart);
			
	@Query("select b from Book b where b.genre =:genre")
	Page<Book> findByGenre(@Param("genre") String genre,Pageable pageable);
}
