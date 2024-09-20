package com.antiguedades.antiguedades.web.controllers;

import com.antiguedades.antiguedades.domain.services.Categorias.CategoriasService;
import com.antiguedades.antiguedades.persistence.entities.Categorias;
import com.antiguedades.antiguedades.domain.dto.CategoriasDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    private final CategoriasService categoriasService;

    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriasDTO>> listarCategorias() {
        List<Categorias> categorias = categoriasService.findAll();
        List<CategoriasDTO> categoriasDTO = categorias.stream().map(CategoriasDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(categoriasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriasDTO> obtenerCategoria(@PathVariable Long id) {
        Optional<Categorias> categoria = categoriasService.findById(id);
        return categoria.map(c -> ResponseEntity.ok(new CategoriasDTO(c))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<CategoriasDTO> crearCategoria(@RequestBody Categorias categoria) {
        Categorias nuevaCategoria = categoriasService.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CategoriasDTO(nuevaCategoria));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CategoriasDTO> actualizarCategoria(@PathVariable Long id, @RequestBody Categorias categoria) {
        if (categoriasService.findById(id).isPresent()) {
            categoria.setIdCategoria(id);
            Categorias categoriaActualizada = categoriasService.update(id, categoria);
            return ResponseEntity.ok(new CategoriasDTO(categoriaActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        if (categoriasService.findById(id).isPresent()) {
            categoriasService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
