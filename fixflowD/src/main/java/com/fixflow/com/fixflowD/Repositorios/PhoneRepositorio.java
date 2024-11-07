package com.fixflow.com.fixflowD.Repositorios;

import com.fixflow.com.fixflowD.Entidades.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepositorio extends JpaRepository<Phone, String> {





    }
