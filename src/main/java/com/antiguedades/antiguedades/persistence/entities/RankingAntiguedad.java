package com.antiguedades.antiguedades.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;


@Entity
@Table(name = "ranking_antiguedad")
public class RankingAntiguedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ranking")
    private Long idRanking;

    @Column(name = "valor_ranking")
    private String valorRanking;


    public Long getIdRanking() {
        return idRanking;
    }

    public void setIdRanking(Long idRanking) {
        this.idRanking = idRanking;
    }

    public String getValorRanking() {
        return valorRanking;
    }

    public void setValorRanking(String valorRanking) {
        this.valorRanking = valorRanking;
    }
}