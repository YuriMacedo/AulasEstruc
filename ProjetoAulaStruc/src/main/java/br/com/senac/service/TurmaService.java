package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Turma;
import br.com.senac.repository.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	TurmaRepository _context;
	
	public List<Turma> getTodasAsTurmas(){
		return _context.findAll();
	}
	
	public Turma getTurmaById(int id) {
		return _context.findById(id).get();
	}
	
	public void Delete(int id) {
		_context.deleteById(id);
	}
	
	public Turma CriarTurma(Turma turma) {
		return _context.save(turma);
	}
	
	public Turma AtualizarTurma(Turma turmaAlterada) {
		Turma turma = getTurmaById(turmaAlterada.getId());
		turma.setNome(turmaAlterada.getNome());
		return _context.save(turma);
	}
}


