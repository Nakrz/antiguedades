package com.antiguedades.antiguedades.web.controllers;

import com.antiguedades.antiguedades.domain.services.Antiguedades.AntiguedadesService;
import com.antiguedades.antiguedades.persistence.entities.Antiguedades;
import com.antiguedades.antiguedades.domain.dto.AntiguedadesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/antiguedades")
public class AntiguedadesController {

    private final AntiguedadesService antiguedadesService;

    public AntiguedadesController(AntiguedadesService antiguedadesService) {
        this.antiguedadesService = antiguedadesService;
    }

    @GetMapping
    public ResponseEntity<List<AntiguedadesDTO>> listarAntiguedades() {
        List<Antiguedades> antiguedades = antiguedadesService.findAll();
        List<AntiguedadesDTO> antiguedadesDTO = antiguedades.stream().map(AntiguedadesDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(antiguedadesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AntiguedadesDTO> obtenerAntiguedad(@PathVariable Long id) {
        Optional<Antiguedades> antiguedad = antiguedadesService.findById(id);
        return antiguedad.map(a -> ResponseEntity.ok(new AntiguedadesDTO(a))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<AntiguedadesDTO> crearAntiguedad(@RequestBody Antiguedades antiguedad) {
        Antiguedades nuevaAntiguedad = antiguedadesService.save(antiguedad);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AntiguedadesDTO(nuevaAntiguedad));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<AntiguedadesDTO> actualizarAntiguedad(@PathVariable Long id, @RequestBody Antiguedades antiguedad) {
        if (antiguedadesService.findById(id).isPresent()) {
            antiguedad.setIdAntiguedad(id);
            Antiguedades antiguedadActualizada = antiguedadesService.update(id, antiguedad);
            return ResponseEntity.ok(new AntiguedadesDTO(antiguedadActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarAntiguedad(@PathVariable Long id) {
        if (antiguedadesService.findById(id).isPresent()) {
            antiguedadesService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
