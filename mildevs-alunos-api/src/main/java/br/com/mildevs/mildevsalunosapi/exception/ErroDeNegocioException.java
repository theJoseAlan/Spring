package br.com.mildevs.mildevsalunosapi.exception;

public class ErroDeNegocioException extends Exception {

    private static final long serialVersionUID = 118470146055125885L;

    //Esse setará a mensagem que irá aparecer quando a excessão for acionada
    public ErroDeNegocioException(String message){
        super(message);
    }

}
