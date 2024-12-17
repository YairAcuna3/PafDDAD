package com.acuna.denunciaservice.controller;

import com.acuna.denunciaservice.service.DenunciaService;
import com.acuna.denunciaservice.entity.Denuncia;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    private final DenunciaService denunciaService;

    // Constructor con la inyección del servicio
    public DenunciaController(DenunciaService denunciaService) {
        this.denunciaService = denunciaService;
    }

    // Crear una nueva denuncia (POST)
    @PostMapping
    public ResponseEntity<Denuncia> createDenuncia(@RequestBody Denuncia denuncia) {
        Date now = new Date();
        denuncia.setCreatedAt(now);  // Asignar la fecha actual a createdAt
        denuncia.setUpdatedAt(now);  // Asignar la misma fecha a updatedAt
        Denuncia savedDenuncia = denunciaService.save(denuncia);
        return ResponseEntity.ok(savedDenuncia);
    }

    // Obtener todas las denuncias (GET)
    @GetMapping  // Ya está mapeado a "/denuncias"
    public ResponseEntity<List<Denuncia>> getAllDenuncias() {
        List<Denuncia> denuncias = denunciaService.getAllDenuncias();
        return ResponseEntity.ok(denuncias);
    }

    // Obtener una denuncia por ID (GET)
    @GetMapping("/id/{id}")
    public ResponseEntity<Denuncia> getDenunciaById(@PathVariable("id") int id) {
        Denuncia denuncia = denunciaService.findById(id);
        if (denuncia != null) {
            return ResponseEntity.ok(denuncia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener denuncias por DNI (GET)
    @GetMapping("/dni/{dni}")
    public ResponseEntity<List<Denuncia>> getDenunciasByDni(@PathVariable("dni") String dni) {
        List<Denuncia> denuncias = denunciaService.findByDni(dni);
        return ResponseEntity.ok(denuncias);
    }

    // Anular una denuncia (PUT)
    @PutMapping("/anular/{id}")
    public ResponseEntity<Denuncia> anularDenuncia(@PathVariable int id) {
        Denuncia updatedDenuncia = denunciaService.anularDenuncia(id);
        if (updatedDenuncia != null) {
            return ResponseEntity.ok(updatedDenuncia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}