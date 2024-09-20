package com.antiguedades.antiguedades.web.controllers;

import com.antiguedades.antiguedades.domain.services.Empleado.EmpleadoService;
import com.antiguedades.antiguedades.persistence.entities.Empleado;
import com.antiguedades.antiguedades.domain.dto.EmpleadoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> listarEmpleados() {
        List<Empleado> empleados = empleadoService.findAll();
        List<EmpleadoDTO> empleadosDTO = empleados.stream().map(EmpleadoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(empleadosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> obtenerEmpleado(@PathVariable Long id) {
        Optional<Empleado> empleado = empleadoService.findById(id);
        return empleado.map(e -> ResponseEntity.ok(new EmpleadoDTO(e))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<EmpleadoDTO> crearEmpleado(@RequestBody Empleado empleado) {
        Empleado nuevoEmpleado = empleadoService.save(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(new EmpleadoDTO(nuevoEmpleado));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EmpleadoDTO> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        if (empleadoService.findById(id).isPresent()) {
            empleado.setIdEmpleado(id);
            Empleado empleadoActualizado = empleadoService.update(id, empleado);
            return ResponseEntity.ok(new EmpleadoDTO(empleadoActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        if (empleadoService.findById(id).isPresent()) {
            empleadoService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
