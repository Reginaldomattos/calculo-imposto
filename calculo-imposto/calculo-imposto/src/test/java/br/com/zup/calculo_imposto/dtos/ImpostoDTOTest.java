package br.com.zup.calculo_imposto.dtos;

import org.junit.jupiter.api.BeforeEach;

public class ImpostoDTOTest {

    private String nome;
    private String descricao;
    private double aliquota;
    private ImpostoDTO impostoDTO;

    @BeforeEach
    public void setUp() {

        nome = "IR";
        descricao = "Imposto sobre a renda de pessoas físicas";
        aliquota = 27.5;

        impostoDTO = new ImpostoDTO() {
            assertEquals(nome, impostoDTO.getNome());
            assertEquals(descricao, impostoDTO.getDescricao());
            assertEquals(aliquota, impostoDTO.getAliquota());
        }
    }

}
