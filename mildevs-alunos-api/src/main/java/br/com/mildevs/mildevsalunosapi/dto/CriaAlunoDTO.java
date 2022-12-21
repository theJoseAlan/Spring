package br.com.mildevs.mildevsalunosapi.dto;

import br.com.mildevs.mildevsalunosapi.entity.Aluno;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CriaAlunoDTO {




    @NotBlank
    private String nome;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate dataNascimento;


    @CPF
    private String cpf;

    @NotNull(message = "valorMensalidade não pode ser nulo")
    private Float valorMensalidade;

    public CriaAlunoDTO(@NotBlank String nome, LocalDate dataNascimento, @CPF String cpf,
                        @NotNull(message = "valor mensalidade não pode ser nulo") Float valorMensalidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.valorMensalidade = valorMensalidade;
    }

    public Aluno toEntity(){
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(this, aluno);
        return aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Float getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(Float valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }
}
