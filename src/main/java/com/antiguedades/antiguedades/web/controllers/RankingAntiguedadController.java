package com.antiguedades.antiguedades.web.controllers;

import com.antiguedades.antiguedades.domain.services.RankingAntiguedad.RankingAntiguedadService;
import com.antiguedades.antiguedades.persistence.entities.RankingAntiguedad;
import com.antiguedades.antiguedades.domain.dto.RankingAntiguedadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ranking")
public class RankingAntiguedadController {

    private final RankingAntiguedadService rankingAntiguedadService;

    public RankingAntiguedadController(RankingAntiguedadService rankingAntiguedadService) {
        this.rankingAntiguedadService = rankingAntiguedadService;
    }

    @GetMapping
    public ResponseEntity<List<RankingAntiguedadDTO>> listarRankings() {
        List<RankingAntiguedad> rankings = rankingAntiguedadService.findAll();
        List<RankingAntiguedadDTO> rankingsDTO = rankings.stream().map(RankingAntiguedadDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(rankingsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RankingAntiguedadDTO> obtenerRanking(@PathVariable Long id) {
        Optional<RankingAntiguedad> ranking = rankingAntiguedadService.findById(id);
        return ranking.map(r -> ResponseEntity.ok(new RankingAntiguedadDTO(r))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<RankingAntiguedadDTO> crearRanking(@RequestBody RankingAntiguedad ranking) {
        RankingAntiguedad nuevoRanking = rankingAntiguedadService.save(ranking);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RankingAntiguedadDTO(nuevoRanking));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RankingAntiguedadDTO> actualizarRanking(@PathVariable Long id, @RequestBody RankingAntiguedad ranking) {
        if (rankingAntiguedadService.findById(id).isPresent()) {
            ranking.setIdRanking(id);
            RankingAntiguedad rankingActualizado = rankingAntiguedadService.update(id, ranking);
            return ResponseEntity.ok(new RankingAntiguedadDTO(rankingActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarRanking(@PathVariable Long id) {
        if (rankingAntiguedadService.findById(id).isPresent()) {
            rankingAntiguedadService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
