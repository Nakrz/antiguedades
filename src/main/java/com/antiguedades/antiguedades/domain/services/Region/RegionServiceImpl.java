package com.antiguedades.antiguedades.domain.services.Region;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Region;
import com.antiguedades.antiguedades.persistence.repositories.RegionRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public List<Region> findAll() {
        return (List<Region>) regionRepository.findAll();
    }

    @Override
    public Optional<Region> findById(Long id) {
        return regionRepository.findById(id);
    }

    @Override
    public Region save(Region region) {
        return regionRepository.save(region);
    }

    @Override
    @Transactional
    public Region update(Long id, Region region) {
        if (!regionRepository.existsById(id)) {
            throw new EntityNotFoundException("Región no encontrada con id " + id);
        }
        region.setIdRegion(id);
        return regionRepository.save(region);
    }

    @Override
    @Transactional
    public Optional<Region> delete(Long id) {
        Optional<Region> region = regionRepository.findById(id);
        if (region.isPresent()) {
            regionRepository.deleteById(id);
        }
        return region;
    }
}
