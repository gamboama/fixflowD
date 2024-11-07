package com.fixflow.com.fixflowD.Repositorios;

import com.fixflow.com.fixflowD.Entidades.Reparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReparationRepository extends JpaRepository<Reparation, String> {
}
