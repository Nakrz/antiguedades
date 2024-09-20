package com.antiguedades.antiguedades.web.controllers;

import com.antiguedades.antiguedades.domain.services.Administrador.AdministradorService;
import com.antiguedades.antiguedades.persistence.entities.Administrador;
import com.antiguedades.antiguedades.domain.dto.AdministradorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping
    public ResponseEntity<List<AdministradorDTO>> listarAdministradores() {
        List<Administrador> administradores = administradorService.findAll();
        List<AdministradorDTO> administradoresDTO = administradores.stream().map(AdministradorDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(administradoresDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDTO> obtenerAdministrador(@PathVariable Long id) {
        Optional<Administrador> administrador = administradorService.findById(id);
        return administrador.map(a -> ResponseEntity.ok(new AdministradorDTO(a))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<AdministradorDTO> crearAdministrador(@RequestBody Administrador administrador) {
        Administrador nuevoAdministrador = administradorService.save(administrador);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AdministradorDTO(nuevoAdministrador));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<AdministradorDTO> actualizarAdministrador(@PathVariable Long id, @RequestBody Administrador administrador) {
        if (administradorService.findById(id).isPresent()) {
            administrador.setIdAdministrador(id);
            Administrador administradorActualizado = administradorService.update(id, administrador);
            return ResponseEntity.ok(new AdministradorDTO(administradorActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarAdministrador(@PathVariable Long id) {
        if (administradorService.findById(id).isPresent()) {
            administradorService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
