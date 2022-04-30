package com.geological.classes.data.access.repository;

import com.geological.classes.data.access.entity.GeologicClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeologicClassRepository extends JpaRepository<GeologicClass, Long> {

  Optional<GeologicClass> findByCode(String code);

  Optional<GeologicClass> findByName(String name);
}
