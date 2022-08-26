package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Professor;
import br.com.senac.entity.Turma;
import br.com.senac.repository.ProfessorRepository;

@Service
public class ProfessorService {
	@Autowired
	ProfessorRepository _context;
	
	public List<Professor> getTodasOsProfessores(){
		return _context.findAll();
	}
	
	public Professor getProfessoresById(int id) {
		return _context.findById(id).get();
	}
	
	public void Delete(int id) {
		_context.deleteById(id);
	}
	
	public Turma CadastrarProfessor(Professor professor) {
		return _context.save(professor);
	}
	
	public Professor AtualizarProfessor(Professor professorAlterado) {
		Professor professor = getProfessoresById(professorAlterado.getId());
		professor.setNome(professorAlterado.getNome());
		return _context.save(professor);
	}
}
