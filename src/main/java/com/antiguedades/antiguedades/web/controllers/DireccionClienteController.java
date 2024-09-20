package com.antiguedades.antiguedades.web.controllers;

import com.antiguedades.antiguedades.domain.services.DireccionCliente.DireccionClienteService;
import com.antiguedades.antiguedades.persistence.entities.DireccionCliente;
import com.antiguedades.antiguedades.domain.dto.DireccionClienteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/direccion")
public class DireccionClienteController {

    private final DireccionClienteService direccionClienteService;

    public DireccionClienteController(DireccionClienteService direccionClienteService) {
        this.direccionClienteService = direccionClienteService;
    }

    @GetMapping
    public ResponseEntity<List<DireccionClienteDTO>> listarDirecciones() {
        List<DireccionCliente> direcciones = direccionClienteService.findAll();
        List<DireccionClienteDTO> direccionesDTO = direcciones.stream().map(DireccionClienteDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(direccionesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionClienteDTO> obtenerDireccion(@PathVariable Long id) {
        Optional<DireccionCliente> direccion = direccionClienteService.findById(id);
        return direccion.map(d -> ResponseEntity.ok(new DireccionClienteDTO(d))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<DireccionClienteDTO> crearDireccion(@RequestBody DireccionCliente direccion) {
        DireccionCliente nuevaDireccion = direccionClienteService.save(direccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DireccionClienteDTO(nuevaDireccion));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DireccionClienteDTO> actualizarDireccion(@PathVariable Long id, @RequestBody DireccionCliente direccion) {
        if (direccionClienteService.findById(id).isPresent()) {
            direccion.setIdDireccion(id);
            DireccionCliente direccionActualizada = direccionClienteService.update(id, direccion);
            return ResponseEntity.ok(new DireccionClienteDTO(direccionActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarDireccion(@PathVariable Long id) {
        if (direccionClienteService.findById(id).isPresent()) {
            direccionClienteService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
