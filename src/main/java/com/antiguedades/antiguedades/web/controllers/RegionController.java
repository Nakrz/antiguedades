package com.antiguedades.antiguedades.web.controllers;

import com.antiguedades.antiguedades.domain.services.Region.RegionService;
import com.antiguedades.antiguedades.persistence.entities.Region;
import com.antiguedades.antiguedades.domain.dto.RegionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/region")
public class RegionController {

    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public ResponseEntity<List<RegionDTO>> listarRegiones() {
        List<Region> regiones = regionService.findAll();
        List<RegionDTO> regionesDTO = regiones.stream().map(RegionDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(regionesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionDTO> obtenerRegion(@PathVariable Long id) {
        Optional<Region> region = regionService.findById(id);
        return region.map(r -> ResponseEntity.ok(new RegionDTO(r))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<RegionDTO> crearRegion(@RequestBody Region region) {
        Region nuevaRegion = regionService.save(region);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RegionDTO(nuevaRegion));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RegionDTO> actualizarRegion(@PathVariable Long id, @RequestBody Region region) {
        if (regionService.findById(id).isPresent()) {
            region.setIdRegion(id);
            Region regionActualizada = regionService.update(id, region);
            return ResponseEntity.ok(new RegionDTO(regionActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarRegion(@PathVariable Long id) {
        if (regionService.findById(id).isPresent()) {
            regionService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
