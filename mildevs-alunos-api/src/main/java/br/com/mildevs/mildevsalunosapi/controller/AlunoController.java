package br.com.mildevs.mildevsalunosapi.controller;

import br.com.mildevs.mildevsalunosapi.dto.CriaAlunoDTO;
import br.com.mildevs.mildevsalunosapi.entity.Aluno;
import br.com.mildevs.mildevsalunosapi.exception.ErroDeNegocioException;
import br.com.mildevs.mildevsalunosapi.repository.AlunoRepository;
import br.com.mildevs.mildevsalunosapi.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    //AlunoRepository alunoRepo;
    AlunoService alunoService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public boolean insereAluno(@RequestBody @Valid CriaAlunoDTO aluno) throws ErroDeNegocioException{
        return alunoService.insereAluno(aluno);
    }

    //Buscando por matricula
    @GetMapping(path = "/{matricula}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Aluno buscaAluno(@PathVariable long matricula){
        return alunoService.consultaAluno(matricula);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Aluno> buscaAluno(){
        return alunoService.listaAlunos();
    }

    @DeleteMapping(path = "/{matricula}")
    public boolean removeAluno(@PathVariable Long matricula){
        return alunoService.removeAluno(matricula);

    }

    //Buscando por cpf
    /*@GetMapping(path = "/{cpf}/busca-cpf", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Aluno> buscaPorCpf(@PathVariable String cpf){
        return this.alunoRepo.findByCpf(cpf);
    }*/

}
