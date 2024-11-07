package com.fixflow.com.fixflowD.Repositorios;


import com.fixflow.com.fixflowD.Entidades.Brands;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandsRepositorio extends JpaRepository <Brands, String>{
}
