package com.techpro.techpro.repository;

import com.techpro.techpro.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<Files, Long> {
    Files findByName(String name);
}
