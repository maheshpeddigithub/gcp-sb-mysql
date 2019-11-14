package com.ssil.gcp.sb.mysql.repository;

import com.ssil.gcp.sb.mysql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
