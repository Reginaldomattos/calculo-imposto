package br.com.zup.calculo_imposto.dto;

import lombok.Data;

@Data
public class CalculoImpostoResponseDTO {

    private String tipoImposto;
    private double valorBase;
    private double aliquota;
    private double valorImposto;

    public CalculoImpostoResponseDTO(String tipoImposto, double valorBase, double aliquota, double valorImposto) {

        this.tipoImposto = tipoImposto;
        this.valorBase = valorBase;
        this.aliquota = aliquota;
        this.valorImposto = valorImposto;
    }

    public CalculoImpostoResponseDTO() {

    }
}
