package com.aaslin.bookauthor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aaslin.bookauthor.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

	@Query("select a from Author a where a.name like concat(:letter,'%')")
	List<Author> findAuthorsByNameStartingWith(@Param("letter") String letter);
	
	@Query("select a from Author a join a.books b group by a having count(b) > :bookCount")
	List<Author> findAuthorsWithMoreThanNBooks(@Param("bookCount")int bookCount);

	
}
 