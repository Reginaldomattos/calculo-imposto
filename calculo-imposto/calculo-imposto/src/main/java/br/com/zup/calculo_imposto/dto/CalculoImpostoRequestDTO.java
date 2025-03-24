package br.com.zup.calculo_imposto.dto;

import lombok.Data;

@Data
public class CalculoImpostoRequestDTO {

    private Long tipoImpostoId;
    private double ValorBase;

    public CalculoImpostoRequestDTO(Long tipoImpostoId, double valorBase) {
        this.tipoImpostoId = tipoImpostoId;
        this.valorBase = valorBase;

    }
    public CalculoImpostoRequestDTO() {

    }
}
