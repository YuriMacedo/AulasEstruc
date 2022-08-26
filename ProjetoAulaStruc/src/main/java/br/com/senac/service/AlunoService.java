package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	AlunoRepository repo;
	
	public List<Aluno> buscarTodosAlunos(){
		 return repo.findAll();
	}
	
	public Aluno salvar(Aluno aluno) {
		return repo.save(aluno);
		
	}
	
	public Aluno buscarAlunoById(Integer id){
		return repo.findById(id).get();
	}
	
	public void DeletarAluno(Integer id) {
		repo.deleteById(id);
	}
	
	public Aluno SalvarAlteracao(Aluno alunoAlterado) {
		Aluno aluno = buscarAlunoById(alunoAlterado.getId());
		aluno.setNome(alunoAlterado.getNome());
		return salvar(aluno);
	}
}
