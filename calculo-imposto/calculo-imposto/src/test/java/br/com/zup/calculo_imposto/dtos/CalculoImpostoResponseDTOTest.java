package br.com.zup.calculo_imposto.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculoImpostoResponseDTOTest {

    private String tipoImposto;
    private double valorBase;
    private double aliquota;
    private double valorImposto;
    private CalculoImpostoResponseDTO responseDTO;

    @BeforeEach
    public void setUp() {
        tipoImposto = "IR";
        valorBase = 1000.0;
        aliquota = 27.5;
        valorImposto = 275.0;

        responseDTO = new CalculoImpostoResponseDTO(tipoImposto, valorBase, aliquota, valorImposto);
    }
    @Test
    public void calculoImpostoResponseDTOTeste(){
        assertEquals("IR", responseDTO.getTipoImposto());
        assertEquals(1000.0, responseDTO.getValorBase());
        assertEquals(27.5, responseDTO.getAliquota());
        assertEquals(275.0, responseDTO.getValorImposto());
    }
}
