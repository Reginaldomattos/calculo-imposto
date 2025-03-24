package br.com.zup.calculo_imposto.dto;

import lombok.Data;

@Data
public class ImpostoDTO {

    private String nome;
    private String descricao;
    private double aliquota;

    public ImpostoDTO() {

    }

    public ImpostoDTO(String nome, String descricao, double aliquota) {
        this.nome =  nome;
        this.descricao = descricao;
        this.aliquota = aliquota;
    }
}
