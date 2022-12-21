package br.com.mildevs.mildevsalunosapi.exception;

import br.com.mildevs.mildevsalunosapi.dto.ErroValidacaoResponseDTO;
import br.com.mildevs.mildevsalunosapi.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final int POSICAO_ERRO = 0;

    //Isso faz com que exiba uma mensagem caso haja um erro
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler({ErroDeNegocioException.class})
    public @ResponseBody ResponseDTO handleBusinessErrors(Exception e){
        return new ResponseDTO(e.getMessage());
    }

    //Agora os erros são listados, não aprecem mais mensagem tão grandes de erro
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public @ResponseBody List<ErroValidacaoResponseDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException e){
        List<ErroValidacaoResponseDTO> resposta = new ArrayList<ErroValidacaoResponseDTO>();

        for (ObjectError erro : e.getBindingResult().getAllErrors()){
            String erroInteiro = erro.getCodes()[POSICAO_ERRO];
            String nomeCampo = erroInteiro.substring(erroInteiro.lastIndexOf(".")+1, erroInteiro.length());

            resposta.add(new ErroValidacaoResponseDTO(nomeCampo, erro.getDefaultMessage()));
        }

        return resposta;
    }
}
