package br.com.mildevs.mildevsalunosapi.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Locale;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matricula;


    @Column(nullable = false)
    //@NotBlank
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate dataNascimento;

    @Column(unique = true)
    //@CPF
    private String cpf;

    //@NotNull(message = "valorMensalidade não pode ser nulo")
    @Column(name = "valor_mensalidade", nullable = false)
    private Float valorMensalidade;

    public Aluno(){

    }

    public Aluno(long matricula, String nome, LocalDate dataNascimento, String cpf, Float valorMesalidade) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.valorMensalidade = valorMensalidade;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
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

    public void setValorMensalidade(Float valorMesalidade) {
        this.valorMensalidade = valorMesalidade;
    }
}

