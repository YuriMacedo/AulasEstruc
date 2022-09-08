package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Professor;
import br.com.senac.service.ProfessorService;

@Controller
@RequestMapping("professor")
public class ProfessorController {
	@Autowired
	private ProfessorService _context;
	
	@GetMapping("/listarProfessor")
	public ModelAndView ListaAllProfessor() {		
		Professor professor = new Professor();
		ModelAndView mv = new ModelAndView("professor/paginaListaProfessor");
		return mv;
	}
	
	
	

}
