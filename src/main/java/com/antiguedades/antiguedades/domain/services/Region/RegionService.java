package com.antiguedades.antiguedades.domain.services.Region;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Region;

public interface RegionService {

    List<Region> findAll();
    Optional<Region> findById(Long id);
    Region save(Region region);
    Region update(Long id, Region region);
    Optional<Region> delete(Long id);
}
