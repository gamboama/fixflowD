package com.fixflow.com.fixflowD.Repositorios;

import com.fixflow.com.fixflowD.Entidades.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepositorio extends JpaRepository<Bill,String> {

}
