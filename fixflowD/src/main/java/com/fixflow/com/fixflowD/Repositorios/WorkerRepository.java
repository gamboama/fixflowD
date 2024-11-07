package com.fixflow.com.fixflowD.Repositorios;

import com.fixflow.com.fixflowD.Entidades.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, String> {
}
