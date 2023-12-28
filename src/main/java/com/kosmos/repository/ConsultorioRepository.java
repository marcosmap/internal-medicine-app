package com.kosmos.repository;

import com.kosmos.model.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio, Integer> {
    Optional<Consultorio> findBynumeroConsultorio(Integer numeroConsultorio);
}
