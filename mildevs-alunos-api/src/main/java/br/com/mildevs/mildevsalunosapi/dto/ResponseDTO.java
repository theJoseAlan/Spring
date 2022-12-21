package br.com.mildevs.mildevsalunosapi.dto;

public class ResponseDTO {

    private String mensagem;

    public ResponseDTO(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
