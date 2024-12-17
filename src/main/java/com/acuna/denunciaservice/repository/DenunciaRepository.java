package com.acuna.denunciaservice.repository;

import  com.acuna.denunciaservice.entity.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {
    List<Denuncia> findByDni(String dni);
}
