package com.antiguedades.antiguedades.domain.services.Categorias;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Categorias;
import com.antiguedades.antiguedades.persistence.repositories.CategoriasRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriasServiceImpl implements CategoriasService {

    @Autowired
    private final CategoriasRepository categoriasRepository;

    public CategoriasServiceImpl(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    @Override
    public List<Categorias> findAll() {
        return (List<Categorias>) categoriasRepository.findAll();
    }

    @Override
    public Optional<Categorias> findById(Long id) {
        return categoriasRepository.findById(id);
    }

    @Override
    public Categorias save(Categorias categoria) {
        return categoriasRepository.save(categoria);
    }

    @Override
    @Transactional
    public Categorias update(Long id, Categorias categoria) {
        if (!categoriasRepository.existsById(id)) {
            throw new EntityNotFoundException("Categoría no encontrada con id " + id);
        }
        categoria.setIdCategoria(id);
        return categoriasRepository.save(categoria);
    }

    @Override
    @Transactional
    public Optional<Categorias> delete(Long id) {
        Optional<Categorias> categoria = categoriasRepository.findById(id);
        if (categoria.isPresent()) {
            categoriasRepository.deleteById(id);
        }
        return categoria;
    }
}
