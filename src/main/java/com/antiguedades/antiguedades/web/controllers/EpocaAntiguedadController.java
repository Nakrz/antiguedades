package com.antiguedades.antiguedades.web.controllers;

import com.antiguedades.antiguedades.domain.services.EpocaAntiguedad.EpocaAntiguedadService;
import com.antiguedades.antiguedades.persistence.entities.EpocaAntiguedad;
import com.antiguedades.antiguedades.domain.dto.EpocaAntiguedadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/epoca")
public class EpocaAntiguedadController {

    private final EpocaAntiguedadService epocaAntiguedadService;

    public EpocaAntiguedadController(EpocaAntiguedadService epocaAntiguedadService) {
        this.epocaAntiguedadService = epocaAntiguedadService;
    }

    @GetMapping
    public ResponseEntity<List<EpocaAntiguedadDTO>> listarEpocas() {
        List<EpocaAntiguedad> epocas = epocaAntiguedadService.findAll();
        List<EpocaAntiguedadDTO> epocasDTO = epocas.stream().map(EpocaAntiguedadDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(epocasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EpocaAntiguedadDTO> obtenerEpoca(@PathVariable Long id) {
        Optional<EpocaAntiguedad> epoca = epocaAntiguedadService.findById(id);
        return epoca.map(e -> ResponseEntity.ok(new EpocaAntiguedadDTO(e))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<EpocaAntiguedadDTO> crearEpoca(@RequestBody EpocaAntiguedad epoca) {
        EpocaAntiguedad nuevaEpoca = epocaAntiguedadService.save(epoca);
        return ResponseEntity.status(HttpStatus.CREATED).body(new EpocaAntiguedadDTO(nuevaEpoca));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EpocaAntiguedadDTO> actualizarEpoca(@PathVariable Long id, @RequestBody EpocaAntiguedad epoca) {
        if (epocaAntiguedadService.findById(id).isPresent()) {
            epoca.setIdEpoca(id);
            EpocaAntiguedad epocaActualizada = epocaAntiguedadService.update(id, epoca);
            return ResponseEntity.ok(new EpocaAntiguedadDTO(epocaActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEpoca(@PathVariable Long id) {
        if (epocaAntiguedadService.findById(id).isPresent()) {
            epocaAntiguedadService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
