package com.antiguedades.antiguedades.web.controllers;

import com.antiguedades.antiguedades.domain.services.Ciudad.CiudadService;
import com.antiguedades.antiguedades.domain.services.Region.RegionService;
import com.antiguedades.antiguedades.persistence.entities.Ciudad;
import com.antiguedades.antiguedades.domain.dto.CiudadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {

    private final CiudadService ciudadService;
    private final RegionService regionService;

    public CiudadController(CiudadService ciudadService, RegionService RegionService) {
        this.ciudadService = ciudadService;
        this.regionService = RegionService;
    }


    @GetMapping
    public ResponseEntity<List<CiudadDTO>> listarCiudades() {
        List<Ciudad> ciudades = ciudadService.findAll();
        List<CiudadDTO> ciudadesDTO = ciudades.stream().map(CiudadDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(ciudadesDTO);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CiudadDTO> obtenerCiudad(@PathVariable Long id) {
        Optional<Ciudad> ciudad = ciudadService.findById(id);
        return ciudad.map(c -> ResponseEntity.ok(new CiudadDTO(c))).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/nuevo")
    public ResponseEntity<CiudadDTO> crearCiudad(@RequestBody Ciudad ciudad) {
        if (regionService.findById(ciudad.getRegion().getIdRegion()).isEmpty()) {
            return ResponseEntity.badRequest().build(); 
        }
        Ciudad nuevaCiudad = ciudadService.save(ciudad);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CiudadDTO(nuevaCiudad));
    }

    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CiudadDTO> actualizarCiudad(@PathVariable Long id, @RequestBody Ciudad ciudad) {
        if (ciudadService.findById(id).isPresent()) {
            ciudad.setIdCiudad(id);
            Ciudad ciudadActualizada = ciudadService.update(id, ciudad);
            return ResponseEntity.ok(new CiudadDTO(ciudadActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCiudad(@PathVariable Long id) {
        if (ciudadService.findById(id).isPresent()) {
            ciudadService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

