package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Professor;
import br.com.senac.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository _context;
	
	
	//Buscar todos
		public List<Professor> buscarTodos(){
			return _context.findAll();
		}

		//Buscar por id
		public Professor buscarPorId(Integer id) {
			Optional<Professor> professor = _context.findById(id);
			return professor.orElseThrow(() -> new ObjectNotFoundException(1L, "Professor não encontrado"));
		}
		
		//cadastrar curso
		public Professor salvar(Professor professor) {
			return _context.save(professor);
		}
		//Deletar Curso
		public void deletarPorId(Integer id) {
			Optional<Professor> professor = _context.findById(id);
			_context.deleteById(id);
		}
		//Atualizar Curso
		public Professor atualizarPorId(Integer id, Professor obj) {
			Professor professor = buscarPorId(id);
			professor.setNome(obj.getNome());
			return _context.save(professor);
		}
		//Atualizar Curso
		public Professor atualizarCurso(Professor professorAlterado) {
			Professor professor = buscarPorId(professorAlterado.getId());
			professor.setNome(professorAlterado.getNome());
			return salvar(professor);
		}

}
