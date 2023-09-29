package com.example.lab7_20200825.repository;

import com.example.lab7_20200825.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Technician, Integer> {
}
