package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.service.CursoService;

@Controller
@RequestMapping("curso")
public class CursoController {
	
	@Autowired
	private CursoService _context;
	
	@GetMapping("/listarCursos")//http://localhost:8080/curso/listarCursos
	public ModelAndView ListaAllCursos() {
		ModelAndView mv = new ModelAndView("curso/paginaListaCursos");
		mv.addObject("cursos",_context.buscarTodos());
		return mv;
	}
	
	

}
