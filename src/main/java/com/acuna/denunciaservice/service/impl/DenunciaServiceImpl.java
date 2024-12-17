package com.acuna.denunciaservice.service.impl;

import com.acuna.denunciaservice.entity.Denuncia;
import com.acuna.denunciaservice.repository.DenunciaRepository;
import com.acuna.denunciaservice.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DenunciaServiceImpl implements DenunciaService {

    private final DenunciaRepository denunciaRepository;

    @Autowired
    public DenunciaServiceImpl(DenunciaRepository denunciaRepository) {
        this.denunciaRepository = denunciaRepository;
    }

    @Override
    public Denuncia save(Denuncia denuncia) {
        return denunciaRepository.save(denuncia);
    }

    @Override
    public List<Denuncia> findAll(Pageable pageable) {
        return denunciaRepository.findAll(pageable).getContent();
    }

    @Override
    public Denuncia findById(int id) {
        Optional<Denuncia> denuncia = denunciaRepository.findById(id);
        return denuncia.orElse(null);
    }

    @Override
    public List<Denuncia> findByDni(String dni) {
        return denunciaRepository.findByDni(dni);
    }
    
    public List<Denuncia> getAllDenuncias() {
        return denunciaRepository.findAll();
    }

    @Override
    public Denuncia anularDenuncia(int id) {
        return null;
    }
}
