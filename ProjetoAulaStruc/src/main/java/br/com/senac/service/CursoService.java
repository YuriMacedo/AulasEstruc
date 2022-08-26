package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senac.entity.Curso;
import br.com.senac.repository.CursoRepository;

public class CursoService {
	@Autowired
	CursoRepository _context;
	
	public List<Curso> GetAllCursos(){
		return _context.findAll();
	}
	
	public Curso GetCursoById(Integer id) {
		return _context.findById(id).get();
	}
	
	public Curso CreateCurso(Curso curso) {
		return _context.save(curso);
	}
	
	public void DeleteCurso(Integer id) {
		_context.deleteById(id);
	}
	
	public Curso UpdateCurso(Curso cursoAlterado) {
		Curso curso = GetCursoById(cursoAlterado.getId());
		curso.setNome(cursoAlterado.getNome());
		return _context.save(curso);
	}
	
}
