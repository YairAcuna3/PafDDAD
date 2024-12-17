package com.acuna.denunciaservice.service;

import com.acuna.denunciaservice.entity.Denuncia;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DenunciaService {
    Denuncia save(Denuncia denuncia);
    List<Denuncia> findAll(Pageable pageable);
    Denuncia findById(int id);
    List<Denuncia> findByDni(String dni);
    Denuncia anularDenuncia(int id);
    List<Denuncia> getAllDenuncias();
}
