package com.fixflow.com.fixflowD.Repositorios;

import com.fixflow.com.fixflowD.Entidades.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
}
