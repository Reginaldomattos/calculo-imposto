package br.com.zup.calculo_imposto.exceptions;

public class UsuarioInvalidException extends RuntimeException {
    public UsuarioInvalidException(String message) {
        super(message);
    }
}
