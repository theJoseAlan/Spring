package br.com.mildevs.mildevsalunosapi.service;

import br.com.mildevs.mildevsalunosapi.entity.Aluno;
import br.com.mildevs.mildevsalunosapi.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    //Create
    public boolean insereAluno(Aluno aluno){
        if(alunoRepository.existsById(aluno.getMatricula())){
            return false;
        }

        alunoRepository.save(aluno);

        return true;
    }

    //Read (consulta e listagem)
    public Aluno consultaAluno(Long matricula){
        Optional<Aluno> alunoDb = alunoRepository.findById(matricula);

        if(alunoDb.isEmpty()){
            return null;
        }
        return alunoDb.get();
    }

    public List<Aluno> listaAlunos(){
        return alunoRepository.findAll();
    }
    //Update
    public boolean alteraAluno(Aluno aluno){
        if(!alunoRepository.existsById(aluno.getMatricula())){
            return false;
        }
        alunoRepository.save(aluno);
        return true;
    }
    //Delete
    public boolean removeAluno(Long matricula){
        if(!alunoRepository.existsById(matricula)){
            return false;
        }

        alunoRepository.deleteById(matricula);

        return true;
    }

}
