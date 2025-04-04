package br.com.zup.calculo_imposto.dtos;

import lombok.Data;

@Data
public class CalculoImpostoRequestDTO {

    private Long tipoImpostoId;
    private double ValorBase;

    public CalculoImpostoRequestDTO(Long tipoImpostoId, double valorBase) {
        this.tipoImpostoId = tipoImpostoId;
        this.ValorBase = valorBase;

    }
    public CalculoImpostoRequestDTO() {

    }
}
