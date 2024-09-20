package com.antiguedades.antiguedades.domain.dto;

import com.antiguedades.antiguedades.persistence.entities.RankingAntiguedad;

public class RankingAntiguedadDTO {

    private Long idRanking;
    private String valorRanking;

    public RankingAntiguedadDTO() {
    }

    public RankingAntiguedadDTO(RankingAntiguedad ranking) {
        this.idRanking = ranking.getIdRanking();
        this.valorRanking = ranking.getValorRanking();
    }

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
