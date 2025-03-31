package br.com.zup.calculo_imposto.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculoImpostoRequestDTOTest {

    private Long tipoImpostoId;
    private double valorBase;
    private CalculoImpostoRequestDTO requestDTO;

    @BeforeEach
    public void setUp() {
        tipoImpostoId = 1L;
        valorBase = 1000.0;

        requestDTO = new CalculoImpostoRequestDTO(tipoImpostoId, valorBase)
    }

    @Test
    public void CalculoImpostoRequestDTOTeste() {
        assertEquals(tipoImpostoId, requestDTO.getTipoImpostoId());
        assertEquals(valorBase, requestDTO.getValorBase());
    }
}
