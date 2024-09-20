package com.antiguedades.antiguedades.web.controllers;

import com.antiguedades.antiguedades.domain.services.Despachos.DespachosService;
import com.antiguedades.antiguedades.persistence.entities.Despachos;
import com.antiguedades.antiguedades.domain.dto.DespachosDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/despachos")
public class DespachosController {

    private final DespachosService despachosService;

    public DespachosController(DespachosService despachosService) {
        this.despachosService = despachosService;
    }

    @GetMapping
    public ResponseEntity<List<DespachosDTO>> listarDespachos() {
        List<Despachos> despachos = despachosService.findAll();
        List<DespachosDTO> despachosDTO = despachos.stream().map(DespachosDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(despachosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespachosDTO> obtenerDespacho(@PathVariable Long id) {
        Optional<Despachos> despacho = despachosService.findById(id);
        return despacho.map(d -> ResponseEntity.ok(new DespachosDTO(d))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<DespachosDTO> crearDespacho(@RequestBody Despachos despacho) {
        Despachos nuevoDespacho = despachosService.save(despacho);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DespachosDTO(nuevoDespacho));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DespachosDTO> actualizarDespacho(@PathVariable Long id, @RequestBody Despachos despacho) {
        if (despachosService.findById(id).isPresent()) {
            despacho.setIdDespacho(id);
            Despachos despachoActualizado = despachosService.update(id, despacho);
            return ResponseEntity.ok(new DespachosDTO(despachoActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarDespacho(@PathVariable Long id) {
        if (despachosService.findById(id).isPresent()) {
            despachosService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
