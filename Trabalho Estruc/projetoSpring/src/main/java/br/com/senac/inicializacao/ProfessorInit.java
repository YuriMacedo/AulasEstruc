package br.com.senac.inicializacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import br.com.senac.entity.Professor;
import br.com.senac.service.ProfessorService;

public class ProfessorInit implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private ProfessorService _context;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Professor prof1 = new Professor();
		Professor prof2 = new Professor();
		Professor prof3 = new Professor();
		
		prof1.setNome("Roberto");
		prof1.setNome("Gabriela");
		prof1.setNome("Fabrício");
		
		_context.salvar(prof1);
		_context.salvar(prof2);
		_context.salvar(prof3);
		
	}

}
