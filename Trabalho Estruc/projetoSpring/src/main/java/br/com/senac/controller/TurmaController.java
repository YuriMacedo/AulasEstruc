package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.service.TurmaService;

@Controller
@RequestMapping("turma")
public class TurmaController {
	
	@Autowired
	private TurmaService _context;
	
	@GetMapping("/listarTurmas")//http://localhost:8080/turma/listarTurmas
	public ModelAndView ListarTodasTurmas() {
		ModelAndView mv = new ModelAndView("turma/paginaListaTurmas");
		mv.addObject("turmas", _context.buscarTodasTurmas());
		return mv;
	}
	
	

	
}
