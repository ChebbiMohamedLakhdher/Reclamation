package com.example.reclamationweb;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReclamationRepositories extends JpaRepository<Reclamation, Integer> {
    @Query("select r from Reclamation r where r.subject like :subject")
    public Page<Reclamation> reclamationByTitle(@Param("subject") String n, Pageable pageable);
}
