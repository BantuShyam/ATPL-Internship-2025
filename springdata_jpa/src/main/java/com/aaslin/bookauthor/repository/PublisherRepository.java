package com.aaslin.bookauthor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaslin.bookauthor.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {

}
