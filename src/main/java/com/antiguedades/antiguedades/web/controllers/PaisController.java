package com.antiguedades.antiguedades.web.controllers;

import com.antiguedades.antiguedades.domain.services.Pais.PaisService;
import com.antiguedades.antiguedades.persistence.entities.Pais;
import com.antiguedades.antiguedades.domain.dto.PaisDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pais")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping
    public ResponseEntity<List<PaisDTO>> listarPaises() {
        List<Pais> paises = paisService.findAll();
        List<PaisDTO> paisesDTO = paises.stream().map(PaisDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(paisesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaisDTO> obtenerPais(@PathVariable Long id) {
        Optional<Pais> pais = paisService.findById(id);
        return pais.map(p -> ResponseEntity.ok(new PaisDTO(p))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<PaisDTO> crearPais(@RequestBody Pais pais) {
        Pais nuevoPais = paisService.save(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PaisDTO(nuevoPais));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PaisDTO> actualizarPais(@PathVariable Long id, @RequestBody Pais pais) {
        if (paisService.findById(id).isPresent()) {
            pais.setIdPais(id);
            Pais paisActualizado = paisService.update(id, pais);
            return ResponseEntity.ok(new PaisDTO(paisActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPais(@PathVariable Long id) {
        if (paisService.findById(id).isPresent()) {
            paisService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
