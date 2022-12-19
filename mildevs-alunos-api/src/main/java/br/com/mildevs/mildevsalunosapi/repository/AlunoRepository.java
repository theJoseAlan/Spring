package br.com.mildevs.mildevsalunosapi.repository;

import br.com.mildevs.mildevsalunosapi.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

}*/

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findByCpf(String cpf);


}
