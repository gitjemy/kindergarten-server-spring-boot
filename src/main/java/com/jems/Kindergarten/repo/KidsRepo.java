package com.jems.Kindergarten.repo;

import com.jems.Kindergarten.model.Kid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KidsRepo extends JpaRepository<Kid, Long> {
    Optional<Kid> findKidById(Long id);
}